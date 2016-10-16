package com.racing.controller.user;

import com.racing.controller.vo.UserVo;
import com.racing.model.po.WechatClient;
import com.racing.service.user.UserService;
import com.racing.service.user.WechatClientService;
import com.racing.util.LoginStatusSaveUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    WechatClientService wechatClientService;

    /**
     * 分盘个人信息管理修改个人信息
     *
     * @return
     */
    @ApiOperation("分盘-个人信息管理-修改个人信息")
    @RequestMapping( method = RequestMethod.PUT)
    public Object updateUserNickName(@RequestBody UserVo userVo) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userService.updateUserNickNameAndPassword(userId, userVo.getNickName(), userVo.getPassword());
    }

    @ApiOperation("分盘页面头部积分信息")
    @RequestMapping(value = "/point", method = RequestMethod.GET)
    public Object userPoint() {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userService.getUserPoint(userId);
    }

    @ApiOperation("分盘-机器人管理-是否报盘")
    @RequestMapping(value = "/robot/enable", method = RequestMethod.PUT)
    public Object robotIsEnable(@RequestBody UserVo userVo) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userService.updateRobotIsEnable(userId, userVo.getClientIsEnable());
    }

    @ApiOperation("分盘-机器人管理-机器人赔率列表")
    @RequestMapping(value = "/robot/rate", method = RequestMethod.GET)
    public Object robotRate() {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return wechatClientService.select(userId);
    }

    @ApiOperation("分盘-机器人管理-修改机器人赔率")
    @RequestMapping(value = "/robot/rate", method = RequestMethod.PUT)
    public Object robotRate(@RequestBody WechatClient wechatClient) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return wechatClientService.update(userId, wechatClient);
    }

    @ApiOperation(value = "获取机器人信息")
    @RequestMapping(method = RequestMethod.GET)
    public Object selectUser() {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userService.getUser(userId);
    }
}
