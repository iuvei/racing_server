package com.racing.model.repo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.UserStakeMapper;
import com.racing.model.po.UserStakeExample;
import com.racing.model.po.UserStakeWithBLOBs;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.JsonUtils;

@Repository
public class UserStakeRepo {

	@Autowired
	private UserStakeMapper mapper;
	
	public UserStakeWithBLOBs getByUserIdAndRacingNum(Integer userId, String racingNum){
		UserStakeExample example = new UserStakeExample();
		example.createCriteria().andUserIdEqualTo(userId).andRacingNumEqualTo(racingNum);
		List<UserStakeWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	}
	
	public void update(UserStakeWithBLOBs userStake){
		userStake.setId(null);
		UserStakeExample example = new UserStakeExample();
		example.createCriteria().andUserIdEqualTo(userStake.getUserId()).andRacingNumEqualTo(userStake.getRacingNum());
		mapper.updateByExampleSelective(userStake, example);
	}
	
	public void addNew(UserStakeWithBLOBs userStake){
		userStake.setId(null);
		mapper.insertSelective(userStake);
	}
	
	public void updateIncome(UserStakeWithBLOBs record){
		if(this.getByUserIdAndRacingNum(record.getUserId(), record.getRacingNum()) == null){
			record.setTotalDeficitAmount(record.getTotalIncomeAmount().subtract(record.getTotalStakeAmount()));
			StakeVo stakeVo = StakeVoUtil.createNewStake(record.getRacingNum());
			record.setAppointStake(JsonUtils.toJsonHasNullKey(stakeVo.getAppointStakeList()));
			record.setCommonStake(JsonUtils.toJsonHasNullKey(stakeVo.getCommonStake()));
			record.setRankingStake(JsonUtils.toJsonHasNullKey(stakeVo.getRankingStakeList()));
			mapper.insertSelective(record);
		}else{
			mapper.updateIncome(record);
		}
	}
	
}
