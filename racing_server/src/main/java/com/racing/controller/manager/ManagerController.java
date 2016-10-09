package com.racing.controller.manager;

import com.racing.controller.vo.manager.ModifyManagerInfoVo;
import com.racing.service.manager.ManagerService;
import com.racing.util.LoginStatusSaveUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {

  @Autowired
  private ManagerService managerService;


  /**
   * 获取全部总盘管理员信息
   * 
   * @return
   */
  @ApiOperation(value="总盘-用户管理-总盘用户管理-获取全部用户")
  @RequestMapping(value = "/manager", method = RequestMethod.GET)
  public Object getManagerList() {
    return managerService.getManagerInfoVo();
  }

  // @RequestMapping(value = "/manager", method = RequestMethod.POST)
  // public Object addNewManager() {
  // return managerService.getManagerInfoVo();
  // }

  @ApiOperation(value="总盘-用户管理-总盘用户管理-禁用用户")
  @RequestMapping(value = "/manager/{managerId}/status/disable", method = RequestMethod.PUT)
  public Object updateManagerDisable(@PathVariable("managerId") int managerId) {
    return managerService.updateMangerIsEnable(managerId, false);
  }

  @ApiOperation(value="总盘-用户管理-总盘用户管理-启用用户")
  @RequestMapping(value = "/manager/{managerId}/status/enable", method = RequestMethod.PUT)
  public Object updateManagerEnable(@PathVariable("managerId") int managerId) {
    return managerService.updateMangerIsEnable(managerId, true);
  }

  @ApiOperation(value="总盘-用户管理-总盘用户管理-修改用户")
  @RequestMapping(value = "/manager/{managerId}", method = RequestMethod.PUT)
  public Object updateManagerInfo(@PathVariable("managerId") int managerId, @RequestBody ModifyManagerInfoVo vo) {
    Integer nowLoginManagerId = LoginStatusSaveUtil.getManagerId();
    return managerService.updateMangerInfo(nowLoginManagerId, managerId, vo);
  }

  @ApiOperation(value="总盘-用户管理-总盘用户管理-删除用户")
  @RequestMapping(value = "/manager/{managerId}", method = RequestMethod.DELETE)
  public Object deleteManagerInfo(@PathVariable("managerId") int managerId) {
    Integer nowLoginManagerId = LoginStatusSaveUtil.getManagerId();
    return managerService.deleteMangerInfo(nowLoginManagerId, managerId);
  }

}
