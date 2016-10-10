package com.racing.service.member;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.Members;
import com.racing.model.repo.MembersRepo;
import com.racing.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MembersService.class);

    @Autowired
    MembersRepo membersRepo;

    public Object select(Integer userId, String nickname, Integer page) {
        List<Members> membersList = membersRepo.select(userId, nickname, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(membersList);
    }
}
