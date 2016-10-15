package com.racing.service.member;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.model.po.Members;
import com.racing.model.po.MembersAccountRecord;
import com.racing.model.po.User;
import com.racing.model.po.UserAccountRecord;
import com.racing.model.repo.MembersAccountRecordRepo;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.UserAccountRecordRepo;
import com.racing.model.repo.UserRepo;
import com.racing.util.PageUtil;

@Service
public class MembersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MembersService.class);

    @Autowired
    MembersRepo membersRepo;
    @Autowired
    MembersAccountRecordRepo membersAccountRecordRepo;
    @Autowired
    UserRepo userRepo;

    @Autowired
    private UserAccountRecordRepo userAccountRecordRepo;

    public Object select(Integer userId, String nickname, Integer page) {
        List<Members> membersList = membersRepo.select(userId, nickname, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(membersList);
    }

    @Transactional(rollbackFor = Exception.class)
    public Object selectPoint(Integer userId, String wechatSn, String nickName) {
        Members members = membersRepo.selectPoint(userId, wechatSn);
        if (members == null) {
            members = new Members();
            members.setUserId(userId);
            members.setWechatSn(wechatSn);
            members.setNickName(nickName);
            members.setPoints(BigDecimal.ZERO);
            int a = membersRepo.addMember(members);
            members = membersRepo.selectPoint(userId, wechatSn);
            if (a == 1) {
                return ApiResult.createSuccessReuslt(members);
            }
            return ApiResult.createErrorReuslt("异常");
        }
        return ApiResult.createSuccessReuslt(members);
    }

    @Transactional(rollbackFor = Exception.class)
    public Object updatePoint(Integer userId, String wechatSn,
                              String nickName, BigDecimal updatePoints, String type) {
        userRepo.updatePoint(userId, updatePoints.negate(), updatePoints);
        Members members = membersRepo.selectPoint(userId, wechatSn);
        if (members == null) {
            members = new Members();
            members.setUserId(userId);
            members.setWechatSn(wechatSn);
            members.setNickName(nickName);
            members.setPoints(updatePoints);
            int a = membersRepo.addMember(members);
            members = membersRepo.selectPoint(userId, wechatSn);
            if (a == 1) {
                MembersAccountRecord membersAccountRecord = new MembersAccountRecord();
                membersAccountRecord.setMembersId(members.getId());
                membersAccountRecord.setOperationPoints(updatePoints);
                membersAccountRecord.setResultPoints(members.getPoints());
                membersAccountRecord.setOperationTime(new Date());
                membersAccountRecord.setType(type);
                membersAccountRecordRepo.add(membersAccountRecord);
                
                UserAccountRecord userAccountRecord = new UserAccountRecord();
        		userAccountRecord.setUserId(userId);
        		if(updatePoints.compareTo(BigDecimal.ZERO)>0){
        			userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_ADD);
        		}else{
        			userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_SUBTRACT);
        		}
        		User user = userRepo.selectById(userId);
        		userAccountRecord.setOperationTotalPoints(BigDecimal.ZERO);
        		userAccountRecord.setResultTotalPoints(user.getTotalPoints());
        		userAccountRecord.setOperationUserPoints(updatePoints.negate());
        		userAccountRecord.setResultUserPoints(user.getUserPoints());
        		userAccountRecord.setOperationMembersPoints(updatePoints);
        		userAccountRecord.setResultMembersPoints(user.getMembersPoints());
        		userAccountRecord.setOperationTime(new Date());
                userAccountRecordRepo.insert(userAccountRecord);
                
                return ApiResult.createSuccessReuslt(members);
            }
            return ApiResult.createErrorReuslt("异常");
        } else {
            members.setNickName(nickName);
            members.setPoints(members.getPoints().add(updatePoints));
            membersRepo.updateMember(members);
            members = membersRepo.selectPoint(userId, wechatSn);
            MembersAccountRecord membersAccountRecord = new MembersAccountRecord();
            membersAccountRecord.setMembersId(members.getId());
            membersAccountRecord.setOperationPoints(updatePoints);
            membersAccountRecord.setOperationTime(new Date());
            membersAccountRecord.setType(type);
            membersAccountRecord.setResultPoints(members.getPoints());
            membersAccountRecordRepo.add(membersAccountRecord);
            
            UserAccountRecord userAccountRecord = new UserAccountRecord();
    		userAccountRecord.setUserId(userId);
    		if(updatePoints.compareTo(BigDecimal.ZERO)>0){
    			userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_ADD);
    		}else{
    			userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_SUBTRACT);
    		}
    		User user = userRepo.selectById(userId);
    		userAccountRecord.setOperationTotalPoints(BigDecimal.ZERO);
    		userAccountRecord.setResultTotalPoints(user.getTotalPoints());
    		userAccountRecord.setOperationUserPoints(updatePoints.negate());
    		userAccountRecord.setResultUserPoints(user.getUserPoints());
    		userAccountRecord.setOperationMembersPoints(updatePoints);
    		userAccountRecord.setResultMembersPoints(user.getMembersPoints());
    		userAccountRecord.setOperationTime(new Date());
            userAccountRecordRepo.insert(userAccountRecord);
            
            return ApiResult.createSuccessReuslt(members);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public Object selectMembersAccountRecord(Integer userId, String wechatSn, Integer page) {
        Members members = membersRepo.selectPoint(userId, wechatSn);
        if (members == null) {
            members = new Members();
            members.setUserId(userId);
            members.setWechatSn(wechatSn);
            members.setPoints(BigDecimal.ZERO);
            membersRepo.addMember(members);
            members = membersRepo.selectPoint(userId, wechatSn);
        }
        List<MembersAccountRecord> list = membersAccountRecordRepo.selectMembersAccountRecord(members.getId(), PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(list);
    }
}
