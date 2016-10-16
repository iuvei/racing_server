package com.racing.service.member;


import com.racing.controller.vo.ApiResult;
import com.racing.model.po.MemberStake;
import com.racing.model.po.Members;
import com.racing.model.po.MembersDayCountIncome;
import com.racing.model.repo.MembersDayCountIncomeRepo;
import com.racing.model.repo.MembersRacingIncomeRepo;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.MembersStakeRepo;
import com.racing.util.DateUtil;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MembersRacingIncomeService {
    @Autowired
    MembersRacingIncomeRepo membersRacingIncomeRepo;
    @Autowired
    MembersRepo membersRepo;
    @Autowired
    MembersStakeRepo membersStakeRepo;
    @Autowired
    MembersDayCountIncomeRepo membersDayCountIncomeRepo;

    public Object selectByDate(Integer userId, String nickname, Date sDate, Date eDate, Integer page) {
        Members members = membersRepo.selectByUserIdAndNicName(userId, nickname);

        if (null == members) {
            return ApiResult.createErrorReuslt("用户不存在");
        }
        String startDateNew = "";
        String endDateNew = "";
        if (sDate != null) {
            startDateNew = DateUtil.parseToString(sDate, DateUtil.DateFormat_yyyy_MM_dd);
        }
        if (eDate != null) {
            endDateNew = DateUtil.parseToString(eDate, DateUtil.DateFormat_yyyy_MM_dd);
        }
        List<MembersDayCountIncome> list = membersDayCountIncomeRepo.selectByDate(
            members.getId(), startDateNew, endDateNew, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(
            list, page, 15, membersDayCountIncomeRepo.selectCountByDate(members.getId(), startDateNew, endDateNew));
    }

    public Object selectByRacingNum(Integer userId, String nickname, Date sDate, Date eDate, String racingNum, Integer page) {
        Members members = membersRepo.selectByUserIdAndNicName(userId, nickname);

        List<MemberStake> list = membersStakeRepo.getStakeInfoByMembersIdAndDateAndRacingNum(
            members.getId(), sDate, eDate, racingNum, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(list, page, 15, membersStakeRepo.getCountByMembersIdAndDateAndRacingNum(
            members.getId(), sDate, eDate, racingNum));
    }
}
