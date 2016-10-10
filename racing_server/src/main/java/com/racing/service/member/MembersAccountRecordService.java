package com.racing.service.member;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.MembersAccountRecord;
import com.racing.model.repo.MembersAccountRecordRepo;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MembersAccountRecordService {

    @Autowired
    MembersAccountRecordRepo membersAccountRecordRepo;

    public Object select(Integer memberId, Date sDate, Date eDate, String type, Integer page) {
        List<MembersAccountRecord> membersAccountRecordList = membersAccountRecordRepo.select(
            memberId, sDate, eDate, type, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(membersAccountRecordList);
    }
}
