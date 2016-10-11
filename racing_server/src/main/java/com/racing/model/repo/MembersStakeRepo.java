package com.racing.model.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.MemberStakeMapper;
import com.racing.model.po.MemberStake;
import com.racing.model.po.MemberStakeWithBLOBs;

@Repository
public class MembersStakeRepo {

  @Autowired
  private MemberStakeMapper mapper;


  public MemberStake addNew(MemberStakeWithBLOBs memberStake) {
    mapper.insert(memberStake);
    return memberStake;
  }
  
  


}
