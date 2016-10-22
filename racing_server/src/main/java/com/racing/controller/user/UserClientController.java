package com.racing.controller.user;

import com.racing.model.po.WechatClient;
import com.racing.service.stake.RecordResultService;
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
    @Autowired
    private RecordResultService recordResultService;

    @ApiOperation("客户端-机器人赔率列表")
    @RequestMapping(value = "/robot/rate", method = RequestMethod.GET)
    public Object robotRate() {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        return wechatClientService.select(userId);
    }

    @ApiOperation("客户端-修改机器人赔率")
    @RequestMapping(value = "/robot/rate", method = RequestMethod.PUT)
    public Object robotRate(@RequestBody WechatClient wechatClient) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        return wechatClientService.update(userId, wechatClient);
    }

    @ApiOperation("客户端-查询历史冠军走向")
    @RequestMapping(value = "/history/champion", method = RequestMethod.GET)
    public Object historyChampion(@RequestParam(required = false, defaultValue = "10") Integer nper) {
        if (nper > 10) {
            nper = 10;
        }
        return recordResultService.historyChampion(nper);
    }
}
