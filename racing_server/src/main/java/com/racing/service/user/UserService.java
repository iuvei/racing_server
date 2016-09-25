package com.racing.service.user;

import com.racing.controller.vo.UserVo;
import com.racing.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserVo selectUser(String nickName, Integer id,
                             Integer page) {
        return userRepo.selectUser(nickName, id, page);
    }
}
