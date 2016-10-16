package com.racing.controller.stake;

import com.racing.controller.vo.ApiResult;
import com.racing.service.stake.RecordResultService;
import com.racing.util.LoginStatusSaveUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordResultController {
    @Autowired
    private RecordResultService recordResultService;

    @ApiOperation("总盘-开奖管理-开奖列表")
    @RequestMapping(value = "/manager/racing/result", method = RequestMethod.GET)
    public Object selectRacingResult(
        @RequestParam(required = false,defaultValue = "1") Integer page) {
        Integer loginId = LoginStatusSaveUtil.getManagerId();
        if (loginId == null) {
            return ApiResult.createNoLoginReuslt();
        }
        return recordResultService.selectRacingResult(page);
    }

    @ApiOperation("分盘-开奖管理-开奖列表")
    @RequestMapping(value = "/user/racing/result", method = RequestMethod.GET)
    public Object userSelectRacingResult(
        @RequestParam(required = false,defaultValue = "1") Integer page) {
        Integer loginId = LoginStatusSaveUtil.getUserWebId();
        if (loginId == null) {
            return ApiResult.createNoLoginReuslt();
        }
        return recordResultService.selectRacingResult(page);
    }
}
