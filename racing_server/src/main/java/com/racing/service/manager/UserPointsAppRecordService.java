package com.racing.service.manager;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.manager.UserPointsAppRecordVo;
import com.racing.model.po.User;
import com.racing.model.po.UserAccountRecord;
import com.racing.model.po.UserPointsAppRecord;
import com.racing.model.repo.UserAccountRecordRepo;
import com.racing.model.repo.UserPointsAppRecordRepo;
import com.racing.model.repo.UserRepo;
import com.racing.util.PageUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserPointsAppRecordService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserPointsAppRecordService.class);

  @Autowired
  UserRepo userRepo;
  @Autowired
  UserPointsAppRecordRepo userPointsAppRecordRepo;
  @Autowired
  UserAccountRecordRepo userAccountRecordRepo;

  public ApiResult selectPoints(String nickName, Integer userId, String status, Integer page) {
    List<UserPointsAppRecordVo> result = new ArrayList<>();
    int count = 0;
    List<User> users = userRepo.selectUser(nickName, userId);
    List<Integer> userIds = new ArrayList<>();
    users.stream().forEach(a -> userIds.add(a.getId()));
    if (0 != users.size()) {
      List<UserPointsAppRecord> list = userPointsAppRecordRepo.selectByUserIds(userIds, status, PageUtil.createPage(page, 15));
      list.stream().forEach(a -> {
        UserPointsAppRecordVo userPointsRecordVo = new UserPointsAppRecordVo();
        try {
          PropertyUtils.copyProperties(userPointsRecordVo, a);
        } catch (Exception e) {
          LOGGER.error("拷贝属性出现异常", e);
        }
        users.stream().filter(b -> a.getUserId().equals(b.getId())).forEach(b -> userPointsRecordVo.setUserNickName(b.getNickName()));
        result.add(userPointsRecordVo);
      });
      count = userPointsAppRecordRepo.countByUserIds(userIds, status);
    }
    return ApiResult.createSuccessReuslt(result, page, 15, count);
  }

  @Transactional(rollbackFor = Exception.class)
  public ApiResult updateStatus(Integer id, String status, String comment) {
    UserPointsAppRecord userPointsAppRecord = userPointsAppRecordRepo.selectById(id);
    if (!UserConstant.POINTS_APP_STATUS_UNTREATED.equals(userPointsAppRecord.getStatus())) {
      return ApiResult.createErrorReuslt("该申请已处理！不能重复处理！");
    }
    if (UserConstant.POINTS_APP_STATUS_AUDIT.equals(status)) {
      User user=userRepo.selectById(userPointsAppRecord.getUserId());
      UserAccountRecord userAccountRecord = new UserAccountRecord();
      userAccountRecord.setUserId(userPointsAppRecord.getUserId());
      if(userPointsAppRecord.getAppPoints().compareTo(BigDecimal.ZERO) >= 0) {
        userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_MANAGER_ADD);
      }else{
        userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_MANAGER_ADD);
      }
      userAccountRecord.setOperationTotalPoints(userPointsAppRecord.getAppPoints());
      userAccountRecord.setResultTotalPoints(user.getTotalPoints());
      userAccountRecord.setOperationUserPoints(userPointsAppRecord.getAppPoints());
      userAccountRecord.setResultUserPoints(user.getUserPoints());
      userAccountRecord.setOperationMembersPoints(BigDecimal.ZERO);
      userAccountRecord.setResultMembersPoints(user.getMembersPoints());
      userAccountRecord.setOperationTime(new Date());
      int insertNum = userAccountRecordRepo.insert(userAccountRecord);
      if(insertNum == 0){
        return ApiResult.createErrorReuslt("积分变化记录异常,请重试!");
      }
    }
    userPointsAppRecord.setStatus(status);
    userPointsAppRecord.setOperationComment(comment);
    userPointsAppRecord.setOperationTime(new Date());
    userPointsAppRecordRepo.updateStatus(userPointsAppRecord);
    return ApiResult.createSuccessReuslt();
  }

  public List<UserPointsAppRecord> selectPointsByUserId(Integer userId, Integer page) {
    if (null == page) {
      page = 1;
    }
    return userPointsAppRecordRepo.selectPointsByUserId(userId, PageUtil.createPage(page, 15));
  }

  public ApiResult userSelectPointsByDate(Integer userId, String status, Date startDate, Date endDate, Integer page) {
      List<UserPointsAppRecordVo> result = new ArrayList<>();
      User user=userRepo.selectById(userId);
      int count;
          List<UserPointsAppRecord> list = userPointsAppRecordRepo.userSelectByUserIdAndDateAndState(
              userId, startDate, endDate, status, PageUtil.createPage(page, 15));
          list.stream().forEach(a -> {
              UserPointsAppRecordVo userPointsRecordVo = new UserPointsAppRecordVo();
              try {
                  PropertyUtils.copyProperties(userPointsRecordVo, a);
              } catch (Exception e) {
                  LOGGER.error("拷贝属性出现异常", e);
              }
              userPointsRecordVo.setUserNickName(user.getNickName());
              result.add(userPointsRecordVo);
          });
          count = userPointsAppRecordRepo.countByUser(userId, startDate, endDate, status);

      return ApiResult.createSuccessReuslt(result, page, 15, count);
  }
}
