package com.racing.controller.user;

import com.racing.service.user.UserAccountRecordService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAccountRecordController {
    @Autowired
    UserAccountRecordService userAccountRecordService;

    @ApiOperation("分盘积分管理操作记录")
    @RequestMapping(value = "/{userId}/state", method = RequestMethod.GET)
    public Object selectByState(@ApiParam(required = true, name = "userId", value = "用户id")
                                @PathVariable Integer userId,
                                @ApiParam(required = false, name = "status", value = "操作类型")
                                @RequestParam(required = false) String status,
                                @ApiParam(required = false, name = "page")
                                @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userAccountRecordService.selectByState(userId, status, page);
    }
}