package com.racing.service.member;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.model.po.*;
import com.racing.model.repo.*;
import com.racing.util.DateUtil;
import com.racing.util.PageUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MembersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MembersService.class);

    @Autowired
    MembersRepo membersRepo;
    @Autowired
    MembersAccountRecordRepo membersAccountRecordRepo;
    @Autowired
    MembersDayCountIncomeRepo membersDayCountIncomeRepo;
    @Autowired
    MembersStakeRepo membersStakeRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MembersService membersService;
    @Autowired
    private UserAccountRecordRepo userAccountRecordRepo;
    @Autowired
    RecordResultRepo recordResultRepo;

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

    public Object selctPointByBatch(Integer userId, List<String> wechatSns) {
        List<Members> membersList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(wechatSns)) {
            wechatSns.stream()
                .forEach(a -> {
                    LOGGER.info("wechatSns is : {}", a);
                    Members members = membersRepo.getByWechatSnAndUserId(a, userId);
                    if (members != null) {
                        membersList.add(members);
                    }
                });
        }
        return ApiResult.createSuccessReuslt(membersList);
    }

    @Transactional(rollbackFor = Exception.class)
    public Object updatePoint(Integer userId, String wechatSn,
                              String nickName, BigDecimal updatePoints, String type) {
        boolean isAdd = false;
        if (updatePoints.compareTo(BigDecimal.ZERO) > 0) {
            isAdd = true;
        }
        User user = userRepo.selectById(userId);
        if (isAdd) {//上分需要判断分盘结余积分是否足够
            if (user.getUserPoints().subtract(updatePoints).compareTo(BigDecimal.ZERO) < 0) {
                return ApiResult.createErrorReuslt("分盘当前积分不足，无法上分");
            }
        }
        userRepo.updatePoint(userId, updatePoints.negate(), updatePoints);
        Members members = membersRepo.selectPoint(userId, wechatSn);
        if (members == null) {
            if (!isAdd) {//用户不存在时，操作是下分，则不执行任何信息
                return ApiResult.createErrorReuslt("新玩家无法进行下分操作");
            }
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
                if (updatePoints.compareTo(BigDecimal.ZERO) > 0) {
                    userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_ADD);
                } else {
                    userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_SUBTRACT);
                }
                user = userRepo.selectById(userId);
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
            if (!isAdd) {//下分操作，判断玩家积分是否足够
                if (members.getPoints().compareTo(updatePoints.negate()) < 0) {
                    return ApiResult.createErrorReuslt("玩家积分不足，无法执行下分操作");
                }
            }
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
            if (updatePoints.compareTo(BigDecimal.ZERO) > 0) {
                userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_ADD);
            } else {
                userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_SUBTRACT);
            }
            user = userRepo.selectById(userId);
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

    public Object selectNicName(Integer userId, String nicName) {
        User user = userRepo.selectById(userId);
        if (null == user) {
            return ApiResult.createErrorReuslt("分盘不存在");
        }
        List<Members> list = membersRepo.select(userId, nicName, PageUtil.createPage(1, 10));
        List<String> nicNames = new ArrayList<>();
        list.stream()
            .forEach(a -> nicNames.add(a.getNickName()));
        return ApiResult.createSuccessReuslt(nicNames);
    }

    public Object selctPointByAll(Integer userId) {
        LOGGER.info("userId is : {}", userId);
        List<Members> membersList = membersRepo.getListByUserId(userId);
        return ApiResult.createSuccessReuslt(membersList);
    }

    @Transactional(rollbackFor = Exception.class)
    public Object delete(Integer userId, String weChatSN) {
        LOGGER.info("High-energy userId is : {} ; weChatSN is : {}", userId, weChatSN);
        Members members = membersRepo.selectPoint(userId, weChatSN);
        if (null == members) {
            return ApiResult.createSuccessReuslt();
        }
        RecordResult nowRecordResult = recordResultRepo.getNowNextRecordResult(new Date());
        if(nowRecordResult != null){
        	MemberStake nowMemberStake = membersStakeRepo.selectByMembersIdAndTacingNum(members.getId(), nowRecordResult.getRacingNum());
        	if (nowMemberStake != null) {
        		return ApiResult.createErrorReuslt("当期有下注,不能删除");
        	}
        }
        RecordResult beforeRecordResult = recordResultRepo.getNowBeforLastRecordResult(new Date());
        if(beforeRecordResult != null && DateUtil.secondBetweenTwoDate(beforeRecordResult.getStartTime(), new Date())<10){
        	MemberStake beforeMemberStake = membersStakeRepo.selectByMembersIdAndTacingNum(members.getId(), beforeRecordResult.getRacingNum());
        	if (beforeMemberStake != null && !beforeMemberStake.getIsComplateStatistics()) {
        		return ApiResult.createErrorReuslt("上期未结算,不能删除");
        	}
        }
        ApiResult updatePointResult = (ApiResult) membersService.updatePoint(userId, weChatSN, "", members.getPoints().negate(), "SUBTRACT");
        if ("SUCCESS".equals(updatePointResult.getResult())) {
            membersAccountRecordRepo.delete(members.getId());
            membersDayCountIncomeRepo.delete(members.getId());
            membersStakeRepo.delete(members.getId());
            membersRepo.delete(members.getId());
            LOGGER.info("delete success!!!");
            return ApiResult.createSuccessReuslt("删除成功");
        }
        return ApiResult.createErrorReuslt("删除失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public Object updatePointByMemberId(Integer userId, Integer memberId,
                                        BigDecimal updatePoints, String type) {
        if (updatePoints.compareTo(BigDecimal.ZERO) < 0) {
            return ApiResult.createErrorReuslt("不能在网站下分");
        }
        User user = userRepo.selectById(userId);
            if (user.getUserPoints().subtract(updatePoints).compareTo(BigDecimal.ZERO) < 0) {
                return ApiResult.createErrorReuslt("分盘当前积分不足，无法上分");
            }
        Members members = membersRepo.getById(memberId);
        if (members == null) {
            return ApiResult.createErrorReuslt("用户不存在");
        } else if(userId.equals(members.getUserId())){
            return ApiResult.createErrorReuslt("此玩家不属于该分盘");
        }else {
            userRepo.updatePoint(userId, updatePoints.negate(), updatePoints);

            members.setPoints(members.getPoints().add(updatePoints));
            membersRepo.updateMember(members);
            members = membersRepo.getById(memberId);
            MembersAccountRecord membersAccountRecord = new MembersAccountRecord();
            membersAccountRecord.setMembersId(members.getId());
            membersAccountRecord.setOperationPoints(updatePoints);
            membersAccountRecord.setOperationTime(new Date());
            membersAccountRecord.setType(type);
            membersAccountRecord.setResultPoints(members.getPoints());
            membersAccountRecordRepo.add(membersAccountRecord);

            UserAccountRecord userAccountRecord = new UserAccountRecord();
            userAccountRecord.setUserId(userId);
            userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_USER_ADD);
            user = userRepo.selectById(userId);
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
}
