package com.racing.service.member;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.Members;
import com.racing.model.po.MembersAccountRecord;
import com.racing.model.repo.MembersAccountRecordRepo;
import com.racing.model.repo.MembersRepo;
import com.racing.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class MembersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MembersService.class);

    @Autowired
    MembersRepo membersRepo;
    @Autowired
    MembersAccountRecordRepo membersAccountRecordRepo;

    public Object select(Integer userId, String nickname, Integer page) {
        List<Members> membersList = membersRepo.select(userId, nickname, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(membersList);
    }

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

    public Object updatePoint(Integer userId, String wechatSn,
                              String nickName, BigDecimal points, String type) {
        Members members = membersRepo.selectPoint(userId, wechatSn);
        if (members == null) {
            members = new Members();
            members.setUserId(userId);
            members.setWechatSn(wechatSn);
            members.setNickName(nickName);
            members.setPoints(points);
            int a = membersRepo.addMember(members);
            members = membersRepo.selectPoint(userId, wechatSn);
            if (a == 1) {
                MembersAccountRecord membersAccountRecord = new MembersAccountRecord();
                membersAccountRecord.setMembersId(members.getId());
                membersAccountRecord.setOperationPoints(points);
                membersAccountRecord.setOperationTime(new Date());
                membersAccountRecord.setType(type);
                membersAccountRecordRepo.add(membersAccountRecord);
                return ApiResult.createSuccessReuslt(members);
            }
            return ApiResult.createErrorReuslt("异常");
        } else {
            members.setNickName(nickName);
            members.setPoints(members.getPoints().add(points));
            membersRepo.updateMember(members);
            MembersAccountRecord membersAccountRecord = new MembersAccountRecord();
            membersAccountRecord.setMembersId(members.getId());
            membersAccountRecord.setOperationPoints(points);
            membersAccountRecord.setOperationTime(new Date());
            membersAccountRecord.setType(type);
            membersAccountRecordRepo.add(membersAccountRecord);
            return ApiResult.createSuccessReuslt(members);
        }
    }

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
