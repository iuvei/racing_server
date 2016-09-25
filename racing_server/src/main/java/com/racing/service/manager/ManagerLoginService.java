package com.racing.service.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.racing.controller.vo.ApiResutl;
import com.racing.controller.vo.ManagerLoginInfoVO;
import com.racing.model.po.Manager;
import com.racing.model.repo.ManagerRepo;
import com.racing.util.AccessKeyUtil;
import com.racing.util.DateUtil;
import com.racing.util.UUIDUtil;

import jodd.util.StringUtil;

@Service
public class ManagerLoginService {

  @Autowired
  private ManagerRepo managerRepo;


  @Transactional(rollbackFor = Exception.class)
  public ApiResutl login(String userName, String password, String ip) {
    if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
      return ApiResutl.createErrorReuslt("用户名密码不能为空");
    }

    Manager manager = this.managerRepo.getByUserNameAndPassword(userName, password);
    if (manager == null) {
      return ApiResutl.createErrorReuslt("用户名或密码错误");
    }
    if (!manager.getIsEnable()) {
      return ApiResutl.createErrorReuslt("该账号暂时不可用");
    }

    String securityKey = UUIDUtil.getUUIDUpcase();
    String accessKey = UUIDUtil.getUUIDUpcase();
    Date lastLoginTime = new Date();
    Date webOutTime = DateUtil.getEndOfDay(lastLoginTime);// 仅限当天有效

    manager.setAccessKey(accessKey);
    manager.setLastLoginIp(ip);
    manager.setLastLoginTime(lastLoginTime);
    manager.setSecurityKey(securityKey);
    manager.setWebOutTime(webOutTime);

    this.managerRepo.update(manager);

    ManagerLoginInfoVO result = new ManagerLoginInfoVO();
    result.setAccessKey(AccessKeyUtil.createManagerAccessKey(accessKey));
    result.setSecurityKey(securityKey);
    result.setNickName(manager.getNickName());

    return ApiResutl.createSuccessReuslt(result);
  }

  public void loginout(Integer managerId) {
    this.managerRepo.updateWebOutTime(managerId, new Date());
  }

}
