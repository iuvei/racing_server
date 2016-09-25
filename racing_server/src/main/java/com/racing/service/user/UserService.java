package com.racing.service.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.manager.UserIdVO;
import com.racing.model.po.User;
import com.racing.model.repo.UserRepo;

@Service
public class UserService {
  @Autowired
  UserRepo userRepo;

  public ApiResult selectUserIdInfo() {
    List<UserIdVO> voList = new ArrayList<UserIdVO>();
    List<User> userList = userRepo.selectUser();
    if (CollectionUtils.isNotEmpty(userList)) {
      for (User user : userList) {
        UserIdVO idVO = new UserIdVO();
        idVO.setId(user.getId());
        idVO.setNickName(user.getNickName());
        idVO.setUserName(user.getUserName());
      }
    }
    return ApiResult.createSuccessReuslt(voList);
  }
}
