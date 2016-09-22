package com.racing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.racing.controller.vo.ApiResutl;
import com.racing.controller.vo.StakeOperationVo;
import com.racing.controller.vo.StakeVo;
import com.racing.service.RacingStakeService;
import com.racing.util.SessionUtil;

import jodd.util.StringUtil;

@Controller
public class RacingStakeViewController {

  @Autowired
  private RacingStakeService racingStakeService;

  @RequestMapping(value = "/view/login", method = RequestMethod.GET)
  public String loginView() {
    return "login";
  }


  @RequestMapping(value = "/stake/login", method = RequestMethod.POST)
  public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model, HttpSession session) {
    if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
      model.addAttribute("message", "用户名密码不能为空");
      return "login";
    }
    if (userName.equals("xianggracing") && password.equals("xgscAdmin123!@#")) {
      SessionUtil.setUser(session);
      return "redirect:/view/stake";
    } else {
      model.addAttribute("message", "用户名密码错误");
      return "login";
    }

  }

  // @RequestMapping(value = "/view/stake", method = RequestMethod.GET)
  // public String addRacingStakeView(Model model, HttpSession session, HttpServletRequest request,
  // RedirectAttributes attr) {
  // if (!SessionUtil.checkUser(session)) {
  // model.addAttribute("message", "登录超时，或未登录！");
  // return "login";
  // }
  // StakeOperationVo stakeOperationVo = racingStakeService.getNowRacingNum();
  // model.addAttribute("StakeOperationVo", stakeOperationVo);
  // if (stakeOperationVo != null) {
  // model.addAttribute("serverTime", stakeOperationVo.getServerTime().getTime());
  // model.addAttribute("startTime", stakeOperationVo.getStartTime().getTime());
  // model.addAttribute("endStakeTime", stakeOperationVo.getEndStakeTime().getTime());
  // } else {
  // model.addAttribute("serverTime", 0);
  // model.addAttribute("startTime", 0);
  // model.addAttribute("endStakeTime", 0);
  // }
  // return "addStake";
  // }

  @RequestMapping(value = "/stake", method = RequestMethod.POST)
  public String addNewRacingStake(StakeVo req, Model model, HttpSession session, RedirectAttributes attr) throws Exception {
    if (!SessionUtil.checkUser(session)) {
      model.addAttribute("message", "登录超时，或未登录！");
      return "login";
    }
    ApiResutl apiResutl = racingStakeService.addNewStake(req);
    if (apiResutl.getResult().equals("SUCCESS")) {
      attr.addFlashAttribute("message", "信息录入成功！");
    } else {
      attr.addFlashAttribute("message", apiResutl.getMessage());
      attr.addFlashAttribute("appointStakeList", req.getAppointStakeList());
      attr.addFlashAttribute("commonStake", req.getCommonStake());
    }
    return "redirect:/view/stake";
  }

  @RequestMapping(value = "/stake/now", method = RequestMethod.GET)
  @ResponseBody
  public Object getNowRacingNum(HttpSession session) {
    if (!SessionUtil.checkUser(session)) {
      return ApiResutl.createErrorReuslt("非法请求");
    }
    StakeOperationVo stakeOperationVo = racingStakeService.getNowRacingNum();
    if (stakeOperationVo != null) {
      return ApiResutl.createSuccessReuslt(stakeOperationVo);
    } else {
      return ApiResutl.createErrorReuslt("暂无比赛");
    }
  }

  @RequestMapping(value = "/stake/racing/{racingNum}/result", method = RequestMethod.POST)
  @ResponseBody
  public Object updateResultRacingResult(@RequestParam("racingResult") String racingResult, @PathVariable("racingNum") String racingNum, HttpSession session) {
    if (!SessionUtil.checkUser(session)) {
      return ApiResutl.createErrorReuslt("非法请求");
    }
    String[] racingResultStr = racingResult.substring(1, racingResult.length() - 1).split(",");
    Integer[] rr = new Integer[10];
    for (int i = 0; i < 10; i++) {
      rr[i] = Integer.parseInt(racingResultStr[i]);
    }

    return racingStakeService.updateRacingResult(rr, racingNum);
  }

  @RequestMapping(value = {"/stake/view", "/view/stake"}, method = RequestMethod.GET)
  public String stake(HttpSession session) {
    if (!SessionUtil.checkUser(session)) {
      return "login";
    }
    return "stake";
  }

  @RequestMapping(value = "/stake/history", method = RequestMethod.GET)
  public String history(HttpSession session) {
    if (!SessionUtil.checkUser(session)) {
      return "login";
    }
    return "history";
  }

}
