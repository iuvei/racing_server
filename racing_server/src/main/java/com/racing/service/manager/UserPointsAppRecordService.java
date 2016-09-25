package com.racing.service.manager;

import com.racing.controller.vo.manager.UserPointsRecordVo;
import com.racing.model.po.User;
import com.racing.model.po.UserPointsAppRecord;
import com.racing.model.repo.UserPointsAppRecordRepo;
import com.racing.model.repo.UserRepo;
import com.racing.util.PageUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPointsAppRecordService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserPointsAppRecordRepo userPointsAppRecordRepo;

    public List<UserPointsRecordVo> selectPoints(String nickName, Integer userId,
                                           String status, Integer page) {
        if (null == page) {
            page = 1;
        }
        List<User> users = userRepo.selectUser(nickName, userId);
        List<Integer> userIds = new ArrayList<>();
        users.stream().forEach(a -> userIds.add(a.getId()));
        if (0 != users.size()) {
            List<UserPointsAppRecord> list = userPointsAppRecordRepo.selectByUserIds(
                userIds, status, PageUtil.createPage(page, 15));
            List<UserPointsRecordVo> userPointsRecordVoList = new ArrayList<>();
            list.stream()
                .forEach(a -> {
                    UserPointsRecordVo userPointsRecordVo = new UserPointsRecordVo();
                    try {
                        PropertyUtils.copyProperties(userPointsRecordVo, a);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    users.stream()
                        .filter(b->a.getUserId().equals(b.getId()))
                        .forEach(b->userPointsRecordVo.setUserNickName(b.getNickName()));
                    userPointsRecordVoList.add(userPointsRecordVo);
                });

            return userPointsRecordVoList;
        } else {
            return null;
        }
    }

    public boolean updateStatus(Integer id,String status){
        UserPointsAppRecord userPointsAppRecord=userPointsAppRecordRepo.selectById(id);
        if("audit".equals(userPointsAppRecord.getStatus())){
            userPointsAppRecord.setStatus(status);
        }
        return userPointsAppRecordRepo.updateStatus(userPointsAppRecord);
    }

    public List<UserPointsAppRecord> selectPointsByUserId(Integer userId, Integer page) {
        if (null == page) {
            page = 1;
        }
        return userPointsAppRecordRepo.selectPointsByUserId(userId, PageUtil.createPage(page, 15));
    }
}
