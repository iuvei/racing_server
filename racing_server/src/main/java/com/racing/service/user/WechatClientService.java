package com.racing.service.user;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.WechatClient;
import com.racing.model.repo.WechatClientRepo;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WechatClientService {
    @Autowired
    WechatClientRepo wechatClientRepo;

    public Object select(Integer userId, Integer page) {
        List<WechatClient> list = wechatClientRepo.select(userId, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(list);
    }

    public Object update(Integer userId, WechatClient wechatClient) {
        int result = wechatClientRepo.update(wechatClient);
        if (result == 1) {
            return ApiResult.createSuccessReuslt();
        }
        return ApiResult.createErrorReuslt("更新失败");
    }
}
