package com.racing.service.user;

import com.racing.controller.vo.UserVo;
import com.racing.model.repo.UserRepo;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserVo selectUser(String nickName, Integer id,
                             Integer page) {
        if (null == page) {
            page = 1;
        }
        UserVo userVo = new UserVo();
        userVo.setUsers(
            userRepo.selectUser(nickName, id, PageUtil.createPage(page, 15)));
        userVo.setTotalPage(
            PageUtil.getTotalPage(userRepo.count(nickName, id), 15));
        return userVo;
    }
}
