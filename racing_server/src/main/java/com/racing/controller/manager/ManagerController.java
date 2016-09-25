package com.racing.controller.manager;

import com.racing.controller.vo.UserVo;
import com.racing.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public UserVo selectUser(@RequestParam(required = false) String nickName,
                             @RequestParam(required = false) Integer id,
                             @RequestParam(required = false) Integer page) {
        return userService.selectUser(nickName, id, page);
    }
}
