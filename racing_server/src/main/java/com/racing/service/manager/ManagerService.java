package com.racing.service.manager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.manager.ManagerInfoVo;
import com.racing.model.po.Manager;
import com.racing.model.repo.ManagerRepo;

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

}

