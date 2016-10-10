package com.racing.controller.user;

import com.racing.controller.vo.UserVo;
import com.racing.model.po.WechatClient;
import com.racing.service.user.UserService;
import com.racing.service.user.WechatClientService;
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
     * @param userId
     * @return
     */
    @ApiOperation("分盘-个人信息管理-修改个人信息")
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public Object updateUserNickName(@PathVariable Integer userId,
                                     @RequestBody UserVo userVo) {
        return userService.updateUserNickNameAndPassword(userId, userVo.getNickName(), userVo.getPassword());
    }

    @ApiOperation("分盘页面头部积分信息")
    @RequestMapping(value = "/{userId}/point", method = RequestMethod.GET)
    public Object userPoint(@PathVariable Integer userId) {
        return userService.getUserPoint(userId);
    }

    @ApiOperation("模糊查询昵称列表")
    @RequestMapping(value = "/{userId}/nicname", method = RequestMethod.GET)
    public Object selectNicName(@PathVariable Integer userId,
                                @RequestParam String nicName) {
        return userService.selectNicName(userId, nicName);
    }

    @ApiOperation("分盘-机器人管理-是否报盘")
    @RequestMapping(value = "/{userId}/robot/enable", method = RequestMethod.PUT)
    public Object robotIsEnable(@PathVariable Integer userId,
                                @RequestBody UserVo userVo) {
        return userService.updateRobotIsEnable(userId, userVo.getClientIsEnable());
    }

    @ApiOperation("分盘-机器人管理-机器人赔率列表")
    @RequestMapping(value = "/{userId}/robot/rate", method = RequestMethod.GET)
    public Object robotRate(@PathVariable Integer userId,
                            @RequestParam(required = false, defaultValue = "1") Integer page) {
        return wechatClientService.select(userId, page);
    }

    @ApiOperation("分盘-机器人管理-修改机器人赔率")
    @RequestMapping(value = "/{userId}/robot/rate", method = RequestMethod.PUT)
    public Object robotRate(@PathVariable Integer userId,
                            @RequestBody WechatClient wechatClient) {
        return wechatClientService.update(userId, wechatClient);
    }
}
