package com.racing.controller.manager;

import com.racing.controller.vo.UserVo;
import com.racing.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerUserController {
    @Autowired
    private UserService userService;

    /**
     * 获取全部用户的基本信息和机器人状态信息
     *
     * @return
     */
    @ApiOperation(value="获取全部用户的基本信息和机器人状态信息")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object selectUser() {
        return userService.getUserList();
    }

    /**
     * 新增用户
     * clientSn,clientExpireDate
     */
    @ApiOperation(value="新增用户")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Object addUser(@RequestBody UserVo user) {
        return userService.addUser(user.getClientSn(), user.getClientExpireDate());
    }

    /**
     * 新增机器人,设置机器人时间
     */
    @ApiOperation(value="新增机器人,设置机器人时间")
    @RequestMapping(value = "/user/{userId}/robot", method = RequestMethod.POST)
    public Object addRobot(@PathVariable Integer userId,
                           @RequestBody UserVo user) {
        return userService.addRobot(userId, user.getClientExpireDate());
    }

    /**
     * 修改信息
     */
    @ApiOperation(value="修改信息")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public Object updateUserNickName(@PathVariable Integer userId,
                                     @RequestBody UserVo user) {
        return userService.updateUserNickName(userId, user.getNickName());
    }

    /**
     * 启用或者禁用用户
     */
    @ApiOperation(value="启用或者禁用用户")
    @RequestMapping(value = "/user/{userId}/available", method = RequestMethod.PUT)
    public Object updateUserIsEnable(@PathVariable Integer userId,
                                     @RequestBody UserVo user) {
        return userService.updateUserIsEnable(userId, user.getIsEnable());
    }

    /**
     * 启用或者禁用robot
     */
    @ApiOperation(value="启用或者禁用robot")
    @RequestMapping(value = "/user/{userId}/robot/available", method = RequestMethod.PUT)
    public Object updateRobotIsEnable(@PathVariable Integer userId,
                                      @RequestBody UserVo user) {
        return userService.updateRobotIsEnable(userId, user.getIsEnable());
    }

    /**
     * 删除用户
     */
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer userId) {
        return userService.delete(userId);
    }

    /**
     * 获取全部用户的ID、用户名、昵称信息列表，用于页面的select空间
     *
     * @return
     */
    @ApiOperation(value = "获取全部用户的ID、用户名、昵称信息列表，用于页面的select空间")
    @RequestMapping(value = "/user/idinfo", method = RequestMethod.GET)
    public Object selectUserIdInfo() {
        return userService.selectUserIdInfo();
    }

}
