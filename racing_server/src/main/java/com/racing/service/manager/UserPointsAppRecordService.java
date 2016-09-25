package com.racing.service.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.racing.constant.UserPointsAppStatusConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.manager.UserPointsAppRecordVo;
import com.racing.model.po.User;
import com.racing.model.po.UserPointsAppRecord;
import com.racing.model.repo.UserPointsAppRecordRepo;
import com.racing.model.repo.UserRepo;
import com.racing.util.PageUtil;

@Service
public class UserPointsAppRecordService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserPointsAppRecordService.class);

  @Autowired
  UserRepo userRepo;
  @Autowired
  UserPointsAppRecordRepo userPointsAppRecordRepo;

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
    if (!UserPointsAppStatusConstant.UNTREATED.equals(userPointsAppRecord.getStatus())) {
      return ApiResult.createErrorReuslt("该申请已处理！不能重复处理！");
    }

    if (UserPointsAppStatusConstant.AUDIT.equals(status)) {
      // TODO 状态为批准，则执行操作积分操作
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
}
