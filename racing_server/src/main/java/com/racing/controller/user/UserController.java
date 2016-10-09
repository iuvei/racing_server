package com.racing.controller.user;

import com.racing.controller.vo.UserVo;
import com.racing.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

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
}
