package com.racing.service.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.UserPointsInfoVO;
import com.racing.controller.vo.manager.UserIdVO;
import com.racing.model.po.User;
import com.racing.model.repo.UserRepo;
import com.racing.util.PageUtil;

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

  public ApiResult getUserPointsInfoList(String nickName, Integer userId, Integer page) {
    List<User> userList = userRepo.selectUser(nickName, userId, PageUtil.createPage(page, 15));
    int count = 0;
    List<UserPointsInfoVO> userPointsInfoList = new ArrayList<UserPointsInfoVO>();
    if (CollectionUtils.isNotEmpty(userList)) {
      for (User user : userList) {
        UserPointsInfoVO infoVO = new UserPointsInfoVO();
        infoVO.setUserId(user.getId());
        infoVO.setNickName(user.getNickName());
        infoVO.setUserName(user.getUserName());
        infoVO.setTotalPoints(user.getTotalPoints());
        infoVO.setUserPoints(user.getUserPoints());
        infoVO.setMembersPoints(user.getMembersPoints());
        userPointsInfoList.add(infoVO);
      }
      count = userRepo.count(nickName, userId);
    }
    return ApiResult.createSuccessReuslt(userPointsInfoList, page, 15, count);
  }

}
