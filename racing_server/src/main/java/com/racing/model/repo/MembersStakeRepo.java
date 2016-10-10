package com.racing.model.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.MemberStakeMapper;

@Repository
public class MembersStakeRepo {

  @Autowired
  private MemberStakeMapper mapper;


}
