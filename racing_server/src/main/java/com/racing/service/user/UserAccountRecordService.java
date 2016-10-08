package com.racing.service.user;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.UserAccountRecord;
import com.racing.model.repo.UserAccountRecordRepo;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountRecordService {

    @Autowired
    UserAccountRecordRepo userAccountRecordRepo;

    public Object selectByUserIdOrState(Integer userId, String status, Integer page) {
        List<UserAccountRecord> userAccountRecordList = userAccountRecordRepo.selectByUserIdOrState(
            userId, status, PageUtil.createPage(page, 15));
        int count = userAccountRecordRepo.countByUserIdOrState(userId, status);
        return ApiResult.createSuccessReuslt(userAccountRecordList, page, 15, count);
    }
}
