package com.racing.controller.old;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResutl;
import com.racing.controller.vo.StakeConfigVo;
import com.racing.controller.vo.StakeVo;
import com.racing.service.RacingStakeService;
import com.racing.util.JsonUtils;
import com.racing.util.SessionUtil;

@RestController
public class RacingStakeController {

  @Autowired
  private RacingStakeService racingStakeService;

  @RequestMapping(value = "/stake/config", method = RequestMethod.GET)
  public Object getStakeConfig(HttpSession session) {
    if (!SessionUtil.checkUser(session)) {
      return ApiResutl.createErrorReuslt("非法请求");
    }
    StakeConfigVo result = racingStakeService.getStakeConfig();
    if (result == null) {
      return ApiResutl.createErrorReuslt("暂无比赛");
    } else {
      return ApiResutl.createSuccessReuslt(result);
    }
  }

  @RequestMapping(value = "/stake/invoke", method = RequestMethod.POST)
  public Object invokeStake(HttpSession session, @RequestParam("stake") String stake) {
    StakeVo req = JsonUtils.toObj(stake, StakeVo.class);
    if (!SessionUtil.checkUser(session)) {
      return ApiResutl.createErrorReuslt("非法请求");
    }
    ApiResutl apiResutl = racingStakeService.addNewStake(req);
    return apiResutl;
  }

  @RequestMapping(value = "/stake/result", method = RequestMethod.PUT)
  public Object modifyResult(@RequestParam("racingResult") String racingResultStr, @RequestParam("racingNum") String racingNum, HttpSession session) {
    if (!SessionUtil.checkUser(session)) {
      return ApiResutl.createErrorReuslt("非法请求");
    }
    List<Integer> racingResult = JsonUtils.toObjList(racingResultStr, Integer.class);
    return racingStakeService.updateRacingResult(racingResult.toArray(new Integer[racingResult.size()]), racingNum);
  }

  @RequestMapping(value = "/stake/count", method = RequestMethod.GET)
  public Object getDayCountStake(HttpSession session) throws ParseException {
    if (!SessionUtil.checkUser(session)) {
      return ApiResutl.createErrorReuslt("非法请求");
    }
    return racingStakeService.getDayCountStake();
  }

}
