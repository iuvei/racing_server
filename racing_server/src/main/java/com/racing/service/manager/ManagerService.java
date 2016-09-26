package com.racing.service.manager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.manager.ManagerInfoVo;
import com.racing.controller.vo.manager.ModifyManagerInfoVo;
import com.racing.model.po.Manager;
import com.racing.model.repo.ManagerRepo;
import com.racing.util.EncryptUtil;

import jodd.util.StringUtil;

@Service
public class ManagerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ManagerService.class);

  @Autowired
  private ManagerRepo managerRepo;

  public ApiResult getManagerInfoVo() {
    List<ManagerInfoVo> result = new ArrayList<ManagerInfoVo>();
    List<Manager> managerList = managerRepo.getManagerList();
    if (CollectionUtils.isNotEmpty(managerList)) {
      for (Manager manager : managerList) {
        ManagerInfoVo vo = new ManagerInfoVo();
        try {
          PropertyUtils.copyProperties(vo, manager);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
          LOGGER.error("拷贝bean出现异常", e);
        }
      }
    }
    return ApiResult.createSuccessReuslt(result);
  }

  public ApiResult updateMangerIsEnable(int managerId, boolean isEnable) {
    Manager manager = new Manager();
    manager.setId(managerId);
    manager.setIsEnable(isEnable);
    managerRepo.update(manager);
    return ApiResult.createSuccessReuslt();
  }

  public ApiResult updateMangerInfo(int nowLoginManagerId, int managerId, ModifyManagerInfoVo vo) {
    if (vo == null) {
      return ApiResult.createSuccessReuslt();
    }
    if (vo.getNickName() != null && vo.getNickName().length() < 4) {
      return ApiResult.createErrorReuslt("昵称不能为空且长度大于3");
    }
    if (vo.getPassword() != null && vo.getPassword().equals("")) {
      return ApiResult.createErrorReuslt("密码不能为空");
    }
    if (StringUtil.isNotEmpty(vo.getPassword()) && !vo.getPassword().equals(vo.getRepassword())) {
      return ApiResult.createErrorReuslt("密码、确认密码必须一致");
    }
    Manager manager = new Manager();
    manager.setId(managerId);
    if (vo.getNickName() != null) {
      manager.setNickName(vo.getNickName());
    }
    if (vo.getPassword() != null) {
      manager.setPassword(EncryptUtil.md5AndSha1Upcase(vo.getPassword()));
      if (nowLoginManagerId != managerId) {
        manager.setWebOutTime(new Date());// 超时时间为当前时间，强制该管理员重新登录
      }
    }

    managerRepo.update(manager);
    return ApiResult.createSuccessReuslt();

  }

}

