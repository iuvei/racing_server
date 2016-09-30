package com.racing.controller.user;

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
     * @param nickName
     * @param password
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public Object updateUserNickName(@PathVariable Integer userId,
                                     @RequestBody String nickName,
                                     @RequestBody String password) {
        return userService.updateUserNickNameAndPassword(userId, nickName, password);
    }
}
