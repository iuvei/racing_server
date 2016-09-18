package com.racing.model.repo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.DayCountStakeMapper;
import com.racing.model.po.DayCountStake;
import com.racing.model.po.DayCountStakeExample;
import com.racing.util.DateUtil;

@Repository
public class DayCountStakeRepo {

  @Autowired
  private DayCountStakeMapper mapper;

  public DayCountStake addNewDayCountStake(BigDecimal totalStakeAmount, BigDecimal totalDeficitAmount, Integer totalStakeCount, Date day) {
    DayCountStake dayCountStake = new DayCountStake();
    dayCountStake.setTotalDeficitAmount(totalDeficitAmount);
    dayCountStake.setTotalStakeAmount(totalStakeAmount);
    dayCountStake.setTotalStakeCount(totalStakeCount);
    dayCountStake.setUpdateTime(new Date());
    dayCountStake.setDay(DateUtil.parseToString(day, DateUtil.DateFormat_yyyy_MM_dd));
    int i = mapper.insertSelective(dayCountStake);
    if (i == 1) {
      return dayCountStake;
    }
    return null;
  }

  public boolean updateTotalStakeAmountAndTotalDeficitAmount(Date day, BigDecimal totalStakeAmount, BigDecimal totalDeficitAmount, Integer totalStakeCount) {
    DayCountStake dayCountStake = new DayCountStake();
    dayCountStake.setTotalDeficitAmount(totalDeficitAmount);
    dayCountStake.setTotalStakeAmount(totalStakeAmount);
    dayCountStake.setTotalStakeCount(totalStakeCount);
    dayCountStake.setUpdateTime(new Date());

    DayCountStakeExample example = new DayCountStakeExample();
    example.createCriteria().andDayEqualTo(DateUtil.parseToString(day, DateUtil.DateFormat_yyyy_MM_dd));

    mapper.updateByExampleSelective(dayCountStake, example);
    return true;

  }

  public DayCountStake getDayCountStake(Date day) {
    DayCountStakeExample example = new DayCountStakeExample();
    example.createCriteria().andDayEqualTo(DateUtil.parseToString(day, DateUtil.DateFormat_yyyy_MM_dd));
    List<DayCountStake> list = mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  public List<DayCountStake> getDayCountStake(Date startDay, Date endDay) {
    DayCountStakeExample example = new DayCountStakeExample();
    example.createCriteria().andDayGreaterThanOrEqualTo(DateUtil.parseToString(startDay, DateUtil.DateFormat_yyyy_MM_dd))
        .andDayLessThanOrEqualTo(DateUtil.parseToString(endDay, DateUtil.DateFormat_yyyy_MM_dd));
    example.setOrderByClause(" day ASC");
    List<DayCountStake> list = mapper.selectByExample(example);
    return list;
  }

}
