package com.racing.model.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.RankingStakeMapper;
import com.racing.model.po.RankingStake;
import com.racing.model.po.RankingStakeExample;

@Repository
public class RankingStakeRepo {

  @Autowired
  private RankingStakeMapper mapper;

  public boolean batchAddRankingStake(List<RankingStake> rankingStakeList, String racingNum) {
    if (CollectionUtils.isNotEmpty(rankingStakeList)) {
      for (RankingStake rankingStake : rankingStakeList) {
        rankingStake.setRacingNum(racingNum);
        int i = mapper.insertSelective(rankingStake);
        if (i != 1) {
          return false;
        }
      }
    }
    return true;
  }

  public RankingStake addRankingStake(RankingStake rankingStake) {
    int i = mapper.insertSelective(rankingStake);
    if (i != 1) {
      return rankingStake;
    }
    return null;
  }

  public Map<Integer, RankingStake> getRankingStakeListByRacingNum(String racingNum) {
    Map<Integer, RankingStake> result = new HashMap<Integer, RankingStake>();
    List<RankingStake> rankingStakes = this.getRankingStakeList(racingNum);
    if (CollectionUtils.isNotEmpty(rankingStakes)) {
      for (RankingStake rankingStake : rankingStakes) {
        result.put(rankingStake.getRankingNum(), rankingStake);
      }
    }
    return result;
  }

  public List<RankingStake> getRankingStakeList(String racingNum) {
    RankingStakeExample example = new RankingStakeExample();
    example.createCriteria().andRacingNumEqualTo(racingNum);
    List<RankingStake> rankingStakes = mapper.selectByExample(example);
    return rankingStakes;
  }


  public boolean updateRankingStakeById(RankingStake rankingStake) {
    mapper.updateByPrimaryKeySelective(rankingStake);
    return true;
  }

}
