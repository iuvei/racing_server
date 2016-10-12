package com.racing.model.repo;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.RecordResultMapper;
import com.racing.model.po.RecordResult;
import com.racing.model.po.RecordResultExample;
import com.racing.util.RacingNumUtil;

@Repository
public class RecordResultRepo {

	@Autowired
	private RecordResultMapper mapper;

	public RecordResult addNewRecordResult(RecordResult recordResult) {
		int i = mapper.insertSelective(recordResult);
		if (i == 1) {
			return recordResult;
		}
		return null;
	}

	public boolean updateRecordResultByRacingNum(RecordResult recordResult, String racingNum) {
		RecordResultExample example = new RecordResultExample();
		example.createCriteria().andRacingNumEqualTo(racingNum);
		int i = mapper.updateByExampleSelective(recordResult, example);
		if (i == 1) {
			return true;
		}
		return false;
	}

	public String getNewRecordResultRacingNum() {
		RecordResultExample example = new RecordResultExample();
		example.setOrderByClause(" racing_num DESC limit 0,1");
		List<RecordResult> result = mapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(result)) {
			return RacingNumUtil.dealNewRacingNum(new Date(), result.get(0).getRacingNum());
		} else {
			return RacingNumUtil.dealNewRacingNum(new Date());
		}
	}

	/**
	 * 获取当前时间之后的第一场比赛
	 * 
	 * @param nowDate
	 * @return
	 */
	public RecordResult getNowNextRecordResult(Date nowDate) {
		RecordResultExample example = new RecordResultExample();
		example.createCriteria().andStartTimeGreaterThanOrEqualTo(nowDate);
		example.setOrderByClause(" start_time ASC limit 0,1");
		List<RecordResult> result = mapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(result)) {
			return result.get(0);
		}
		return null;
	}

	/**
	 * 获取当前时间之前的最后一场比赛
	 * 
	 * @param nowDate
	 * @return
	 */
	public RecordResult getNowBeforLastRecordResult(Date nowDate) {
		RecordResultExample example = new RecordResultExample();
		example.createCriteria().andStartTimeLessThanOrEqualTo(nowDate);
		example.setOrderByClause(" start_time DESC limit 0,1");
		List<RecordResult> result = mapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(result)) {
			return result.get(0);
		}
		return null;
	}

	public List<RecordResult> getRecordResultByAfterTime(Date beforeTime) {
		RecordResultExample example = new RecordResultExample();
		example.createCriteria().andStartTimeLessThan(beforeTime);
		example.setOrderByClause(" start_time DESC limit 0,30");

		List<RecordResult> result = mapper.selectByExample(example);

		return result;
	}

	public RecordResult getRecordResultByRacingNum(String racingNum) {
		RecordResultExample example = new RecordResultExample();
		example.createCriteria().andRacingNumEqualTo(racingNum);
		List<RecordResult> result = mapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(result)) {
			return result.get(0);
		}
		return null;
	}

	public List<RecordResult> getRecordResultByStartTime(Date startDate, Date endDate) {
		RecordResultExample example = new RecordResultExample();
		example.createCriteria().andStartTimeGreaterThanOrEqualTo(startDate).andStartTimeLessThanOrEqualTo(endDate);
		List<RecordResult> result = mapper.selectByExample(example);

		return result;
	}
}
