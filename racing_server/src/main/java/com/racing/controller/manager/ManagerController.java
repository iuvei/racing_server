package com.racing.controller.manager;

import com.racing.controller.vo.UserVo;
import com.racing.controller.vo.manager.UserPointsRecordVo;
import com.racing.model.po.UserPointsAppRecord;
import com.racing.service.manager.UserPointsAppRecordService;
import com.racing.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    UserService userService;
    @Autowired
    UserPointsAppRecordService userPointsAppRecordService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserVo selectUser(@RequestParam(required = false) String nickName,
                             @RequestParam(required = false) Integer id,
                             @RequestParam(required = false) Integer page) {
        return userService.selectUser(nickName, id, page);
    }

    @RequestMapping(value = "/user/points", method = RequestMethod.GET)
    public List<UserPointsRecordVo> selectPoints(@RequestParam(required = false) String nickName,
                                                 @RequestParam(required = false) Integer userId,
                                                 @RequestParam(required = false) String status,
                                                 @RequestParam(required = false) Integer page) {
        return userPointsAppRecordService.selectPoints(nickName, userId, status, page);
    }

    /**
     * untreated/audit/reject/cancel
     * 待处理/批注/拒绝/取消
     *
     * @param id
     */
    @RequestMapping(value = "/user/point/{id}/status/audit", method = RequestMethod.PUT)
    public boolean toUserPointAudit(@PathVariable Integer id) {
        return userPointsAppRecordService.updateStatus(id, "audit");
    }

    @RequestMapping(value = "/user/point/{id}/status/reject", method = RequestMethod.PUT)
    public boolean toUserPointReject(@PathVariable Integer id) {
        return userPointsAppRecordService.updateStatus(id, "reject");
    }

    @RequestMapping(value = "/user/point/{id}/status/cancel", method = RequestMethod.PUT)
    public boolean toUserPointUntreated(@PathVariable Integer id) {
        return userPointsAppRecordService.updateStatus(id, "cancel");
    }

    @RequestMapping(value = "/user/{userId}/points", method = RequestMethod.GET)
    public List<UserPointsAppRecord> selectPointsByUserId(@PathVariable Integer userId,
                                                         @RequestParam(required = false) Integer page) {
        return userPointsAppRecordService.selectPointsByUserId(userId, page);
    }
}
