package com.racing.model.repo;

import com.racing.model.po.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.MemberStakeMapper;

import java.util.Date;
import java.util.List;

@Repository
public class MembersStakeRepo {

    @Autowired
    private MemberStakeMapper mapper;


    public MemberStake addNew(MemberStakeWithBLOBs memberStake) {
    	memberStake.setCreateTime(new Date());
        mapper.insertSelective(memberStake);
        return memberStake;
    }

    public MemberStake selectByMembersIdAndTacingNum(Integer membersId, String racingNum) {
        MemberStakeExample example = new MemberStakeExample();
        example.createCriteria().andMembersIdEqualTo(membersId).andRacingNumEqualTo(racingNum);
        List<MemberStake> list = this.mapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public MemberStakeWithBLOBs getStakeInfoByMembersIdAndTacingNum(Integer membersId, String racingNum) {
    	MemberStakeExample example = new MemberStakeExample();
    	example.createCriteria().andMembersIdEqualTo(membersId).andRacingNumEqualTo(racingNum);
    	List<MemberStakeWithBLOBs> list = this.mapper.selectByExampleWithBLOBs(example);
    	if (CollectionUtils.isNotEmpty(list)) {
    		return list.get(0);
    	}
    	return null;
    }
    
    public void updateIncome(MemberStakeWithBLOBs record){
    	mapper.updateIncome(record);
    }
}
