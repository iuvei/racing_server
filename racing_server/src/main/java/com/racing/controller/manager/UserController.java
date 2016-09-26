package com.racing.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.racing.service.user.UserService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/manager")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 获取全部用户的ID、用户名、昵称信息列表，用于页面的select空间
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object selectUser() {
        return userService.selectUserIdInfo();
    }

    /**
     * 根据分盘用户昵称和编号查询分盘积分情况列表
     *
     * @param nickName
     * @param userId
     * @param page
     * @return
     */
    @RequestMapping(value = "/user/points", method = RequestMethod.GET)
    public Object getUserPointsInfoList(@RequestParam(required = false) String nickName, @RequestParam(required = false) Integer userId,
                                        @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userService.getUserPointsInfoList(nickName, userId, page);
    }

    /**
     * 总盘给用户添加积分
     * @param userId
     * @param points
     * @return
     */
    @RequestMapping(value = "/add/points/user/{id}", method = RequestMethod.PUT)
    public Object managerAddPointsToUser(@PathVariable Integer userId,
                                         @RequestBody BigDecimal points) {
        return userService.updatePoint(userId, points);
    }

    /**
     * 总盘给用户减少积分
     * @param userId
     * @param points
     * @return
     */
    @RequestMapping(value = "/subtract/points/user/{id}", method = RequestMethod.PUT)
    public Object managerSubtractPointsToUser(@PathVariable Integer userId,
                                         @RequestBody BigDecimal points) {
        return userService.updatePoint(userId,points);
    }

}
