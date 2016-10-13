package com.racing.controller.user;

import com.racing.model.po.WechatClient;
import com.racing.service.user.UserService;
import com.racing.service.user.WechatClientService;
import com.racing.util.LoginStatusSaveUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/client")
public class UserClientController {
    @Autowired
    UserService userService;
    @Autowired
    WechatClientService wechatClientService;

    @ApiOperation("分盘-机器人管理-机器人赔率列表")
    @RequestMapping(value = "/robot/rate", method = RequestMethod.GET)
    public Object robotRate(@RequestParam(required = false, defaultValue = "1") Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        return wechatClientService.select(userId, page);
    }

    @ApiOperation("分盘-机器人管理-修改机器人赔率")
    @RequestMapping(value = "/robot/rate", method = RequestMethod.PUT)
    public Object robotRate(@RequestBody WechatClient wechatClient) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        return wechatClientService.update(userId, wechatClient);
    }
}
