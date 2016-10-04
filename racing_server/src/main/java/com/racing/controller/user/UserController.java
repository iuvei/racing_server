package com.racing.controller.user;

import com.racing.controller.vo.UserVo;
import com.racing.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 分盘个人信息管理修改个人信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public Object updateUserNickName(@PathVariable Integer userId,
                                     @RequestBody UserVo userVo) {
        return userService.updateUserNickNameAndPassword(userId, userVo.getNickName(), userVo.getPassword());
    }
}
