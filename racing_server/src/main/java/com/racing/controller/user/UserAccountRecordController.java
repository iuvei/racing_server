package com.racing.controller.user;

import com.racing.service.user.UserAccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAccountRecordController {
    @Autowired
    UserAccountRecordService userAccountRecordService;

    /**
     * 分盘积分管理操作记录
     *
     * @return
     */
    @RequestMapping(value = "/{userId}/state", method = RequestMethod.GET)
    public Object select() {
        return null;
    }
}