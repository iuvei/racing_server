package com.racing.model.repo;

import com.racing.model.mapper.MembersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersRepo {
    @Autowired
    MembersMapper membersMapper;
}
