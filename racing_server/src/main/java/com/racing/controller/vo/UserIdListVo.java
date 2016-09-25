package com.racing.controller.vo;

import java.util.List;

import com.racing.controller.vo.manager.UserIdVO;

public class UserIdListVo extends PageVo {

  private List<UserIdVO> usersIdVOList;

  public List<UserIdVO> getUsersIdVOList() {
    return usersIdVOList;
  }

  public void setUsersIdVOList(List<UserIdVO> usersIdVOList) {
    this.usersIdVOList = usersIdVOList;
  }

}
