package com.racing.model.repo;

import com.racing.model.mapper.UserAccountRecordMapper;
import com.racing.model.po.UserAccountRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRecordRepo {
    @Autowired
    UserAccountRecordMapper mapper;

    public int insert(UserAccountRecord userPointsAppRecord) {
        return mapper.insert(userPointsAppRecord);
    }
}
