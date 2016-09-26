package com.racing.service.user;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.UserPointsInfoVO;
import com.racing.controller.vo.manager.UserIdVO;
import com.racing.controller.vo.manager.UserInfoVo;
import com.racing.model.po.User;
import com.racing.model.po.UserAccountRecord;
import com.racing.model.repo.UserAccountRecordRepo;
import com.racing.model.repo.UserRepo;
import com.racing.util.PageUtil;

import jodd.util.StringUtil;

@Service
public class UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  @Autowired
  UserRepo userRepo;
  @Autowired
  UserAccountRecordRepo userAccountRecordRepo;

  public ApiResult getUserList(String nickName, Integer id) {
    List<UserInfoVo> result = new ArrayList<UserInfoVo>();

    List<User> userList = userRepo.selectUser(nickName, id);
    if (CollectionUtils.isNotEmpty(userList)) {
      for (User user : userList) {
        UserInfoVo vo = new UserInfoVo();
        try {
          PropertyUtils.copyProperties(vo, user);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
          LOGGER.error("拷贝bean出现异常！", e);
        }
        if (StringUtil.isNotEmpty(user.getClientSn())) {// 有微信机器人
          vo.setIsHaveClient(true);
          if (user.getClientExpireDate().compareTo(new Date()) > 0) {// 未过期
            vo.setIsClientExpired(true);
          } else {// 已过期
            vo.setIsClientExpired(true);
          }
        } else {// 无客户端
          vo.setIsHaveClient(false);
        }
      }
    }

    return ApiResult.createSuccessReuslt(result);
  }

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

  public Object updatePoint(Integer userId, BigDecimal points) {
    int returnNum = userRepo.updatePoint(userId, points);
    User user = userRepo.selectById(userId);
    if (returnNum == 0) {
      return ApiResult.createErrorReuslt("分数变更失败");
    }

    UserAccountRecord userAccountRecord = new UserAccountRecord();
    userAccountRecord.setUserId(userId);
    if (points.compareTo(BigDecimal.ZERO) >= 0) {
      userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_MANAGER_ADD);
    } else {
      userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_MANAGER_ADD);
    }
    userAccountRecord.setOperationTotalPoints(points);
    userAccountRecord.setResultTotalPoints(user.getTotalPoints());
    userAccountRecord.setOperationUserPoints(points);
    userAccountRecord.setResultUserPoints(user.getUserPoints());
    userAccountRecord.setOperationMembersPoints(BigDecimal.ZERO);
    userAccountRecord.setResultMembersPoints(user.getMembersPoints());
    userAccountRecord.setOperationTime(new Date());
    returnNum = userAccountRecordRepo.insert(userAccountRecord);
    if (returnNum == 0) {
      return ApiResult.createErrorReuslt("分数变更记录插入失败");
    }
    return ApiResult.createSuccessReuslt();
  }
}
