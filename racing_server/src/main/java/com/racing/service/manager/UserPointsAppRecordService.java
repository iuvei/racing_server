package com.racing.service.manager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
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
  @Autowired
  UserRepo userRepo;
  @Autowired
  UserPointsAppRecordRepo userPointsAppRecordRepo;

  public List<UserPointsAppRecordVo> selectPoints(String nickName, Integer userId, String status, Integer page) {
    if (null == page) {
      page = 1;
    }
    List<User> users = userRepo.selectUser(nickName, userId);
    List<Integer> userIds = new ArrayList<>();
    users.stream().forEach(a -> userIds.add(a.getId()));
    if (0 != users.size()) {
      List<UserPointsAppRecord> list = userPointsAppRecordRepo.selectByUserIds(userIds, status, PageUtil.createPage(page, 15));
      List<UserPointsAppRecordVo> userPointsRecordVoList = new ArrayList<>();
      list.stream().forEach(a -> {
        UserPointsAppRecordVo userPointsRecordVo = new UserPointsAppRecordVo();
        try {
          PropertyUtils.copyProperties(userPointsRecordVo, a);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          e.printStackTrace();
        } catch (NoSuchMethodException e) {
          e.printStackTrace();
        }
        users.stream().filter(b -> a.getUserId().equals(b.getId())).forEach(b -> userPointsRecordVo.setUserNickName(b.getNickName()));
        userPointsRecordVoList.add(userPointsRecordVo);
      });

      return userPointsRecordVoList;
    } else {
      return null;
    }
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
