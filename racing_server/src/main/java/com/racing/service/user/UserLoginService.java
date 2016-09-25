package com.racing.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResutl;
import com.racing.controller.vo.LoginInfoVO;
import com.racing.model.po.User;
import com.racing.model.repo.UserRepo;
import com.racing.util.AccessKeyUtil;
import com.racing.util.DateUtil;
import com.racing.util.UUIDUtil;

import jodd.util.StringUtil;

@Service
public class UserLoginService {

  @Autowired
  private UserRepo userRepo;

  public ApiResutl webLogin(String userName, String password, String ip) {
    if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
      return ApiResutl.createErrorReuslt("用户名密码不能为空");
    }

    User user = this.userRepo.getByUserNameAndPassword(userName, password);
    if (user == null) {
      return ApiResutl.createErrorReuslt("用户名或密码错误");
    }
    if (!user.getIsEnable()) {
      return ApiResutl.createErrorReuslt("该账号暂时不可用");
    }

    String accessKey = UUIDUtil.getUUIDUpcase();
    String securityKey = UUIDUtil.getUUIDUpcase();
    Date lastLoginTime = new Date();
    Date webOutTime = DateUtil.getEndOfDay(lastLoginTime);// 仅限当天有效

    user.setWebAccessKey(accessKey);
    user.setWebSecurityKey(securityKey);
    user.setWebOutTime(webOutTime);

    this.userRepo.update(user);

    LoginInfoVO result = new LoginInfoVO();
    result.setAccessKey(AccessKeyUtil.createWebUserAccessKey(accessKey));
    result.setSecurityKey(securityKey);
    result.setNickName(user.getNickName());

    return ApiResutl.createSuccessReuslt(result);
  }

  public void webLoginout(Integer userId) {
    this.userRepo.updateWebOutTime(userId, new Date());
  }

  public ApiResutl clientLogin(String userName, String password, String clientSN) {
    if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
      return ApiResutl.createErrorReuslt("用户名密码不能为空");
    }
    if (StringUtil.isEmpty(clientSN)) {
      return ApiResutl.createErrorReuslt("该客户端暂不可用");
    }

    User user = this.userRepo.getByUserNameAndPasswordAndClientSN(userName, password, clientSN);
    if (user == null) {
      return ApiResutl.createErrorReuslt("用户名或密码错误");
    }
    if (!user.getIsEnable()) {
      return ApiResutl.createErrorReuslt("该账号暂时不可用");
    }

    if (!user.getClientIsEnable() || user.getClientExpireDate().compareTo(new Date()) <= 0) {
      return ApiResutl.createErrorReuslt("该客户端暂时不可用");
    }
    String accessKey = UUIDUtil.getUUIDUpcase();
    String securityKey = UUIDUtil.getUUIDUpcase();
    Date lastLoginTime = new Date();
    Date clientOutTime = DateUtil.getEndOfDay(lastLoginTime);// 仅限当天有效

    user.setClientAccessKey(accessKey);
    user.setClientSecurityKey(securityKey);
    user.setClientOutTime(clientOutTime);

    this.userRepo.update(user);

    LoginInfoVO result = new LoginInfoVO();
    result.setAccessKey(AccessKeyUtil.createClientUserAccessKey(accessKey));
    result.setSecurityKey(securityKey);
    result.setNickName(user.getNickName());

    return ApiResutl.createSuccessReuslt(result);
  }

  public void clientLoginout(Integer userId) {
    this.userRepo.updateClientOutTime(userId, new Date());
  }

  public ApiResutl checkClientIsEnable(String clientSN) {
    if (StringUtil.isEmpty(clientSN)) {
      return ApiResutl.createErrorReuslt("该客户端暂未在盘口注册");
    }
    User user = this.userRepo.getByClientSN(clientSN);
    if (user == null) {
      return ApiResutl.createErrorReuslt("该客户端暂未激活注册");
    }

    if (!user.getClientIsEnable()) {
      return ApiResutl.createErrorReuslt("该客户端暂时不可用");
    }
    if (user.getClientExpireDate().compareTo(new Date()) <= 0) {
      return ApiResutl.createErrorReuslt("该客户端已到期，请联系盘口管理员续费");
    }
    int daySub = DateUtil.daysBetweenTwoDate(user.getClientExpireDate(), new Date());
    if (daySub < 7) {
      return ApiResutl.createSuccessReuslt(String.format("您的客户端%s天后到期，请及时续费", daySub));
    }
    return ApiResutl.createSuccessReuslt();
  }

}
