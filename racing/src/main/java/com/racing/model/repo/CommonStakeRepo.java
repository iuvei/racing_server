package com.racing.model.repo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.CommonStakeMapper;
import com.racing.model.po.CommonStake;
import com.racing.model.po.CommonStakeExample;

@Repository
public class CommonStakeRepo {

  @Autowired
  private CommonStakeMapper mapper;

  public CommonStake addNewCommonStake(CommonStake commonStake, String racingNum) {
    commonStake.setRacingNum(racingNum);
    int i = mapper.insertSelective(commonStake);
    if (i == 1) {
      return commonStake;
    }
    return null;
  }

  public CommonStake getCommonStakeByRacingNum(String racingNum) {
    CommonStakeExample example = new CommonStakeExample();
    example.createCriteria().andRacingNumEqualTo(racingNum);
    List<CommonStake> result = mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(result)) {
      return result.get(0);
    }
    return null;
  }

  public boolean updateCommonStakeById(CommonStake commonStake) {
    mapper.updateByPrimaryKeySelective(commonStake);
    return true;
  }

}
