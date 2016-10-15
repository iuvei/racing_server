package com.racing.service.user;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.WechatClient;
import com.racing.model.repo.WechatClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatClientService {
    @Autowired
    WechatClientRepo wechatClientRepo;

    public Object select(Integer userId) {
        WechatClient wechatClient = wechatClientRepo.select(userId);
        return ApiResult.createSuccessReuslt(wechatClient);
    }

    public Object update(Integer userId, WechatClient wechatClient) {
        int result = wechatClientRepo.update(wechatClient);
        if (result == 1) {
            return ApiResult.createSuccessReuslt();
        }
        return ApiResult.createErrorReuslt("更新失败");
    }
}
