package com.racing.model.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.AppointStakeMapper;
import com.racing.model.po.AppointStake;
import com.racing.model.po.AppointStakeExample;

@Repository
public class AppointStakeRepo {

  @Autowired
  private AppointStakeMapper mapper;


  public boolean batchAddAppointStake(List<AppointStake> appointStakeList, String racingNum) {
    if (CollectionUtils.isNotEmpty(appointStakeList)) {
      for (AppointStake appointStake : appointStakeList) {
        appointStake.setRacingNum(racingNum);
        int i = mapper.insertSelective(appointStake);
        if (i != 1) {
          return false;
        }
      }
    }
    return true;
  }

  public AppointStake addAppointStake(AppointStake appointStake) {
    int i = mapper.insertSelective(appointStake);
    if (i != 1) {
      return appointStake;
    }
    return null;

  }

  public Map<Integer, AppointStake> getAppointStakeListByRacingNum(String racingNum) {
    Map<Integer, AppointStake> map = new HashMap<Integer, AppointStake>();
    List<AppointStake> appointStakes = this.getAppointStakeList(racingNum);
    if (CollectionUtils.isNotEmpty(appointStakes)) {
      for (AppointStake appointStake : appointStakes) {
        map.put(appointStake.getCarNum(), appointStake);
      }
    }
    return map;
  }

  public List<AppointStake> getAppointStakeList(String racingNum) {
    AppointStakeExample example = new AppointStakeExample();
    example.createCriteria().andRacingNumEqualTo(racingNum);
    List<AppointStake> appointStakes = mapper.selectByExample(example);
    return appointStakes;
  }

  public boolean updateAppointStakeById(AppointStake appointStake) {
    mapper.updateByPrimaryKeySelective(appointStake);
    return true;
  }

}
