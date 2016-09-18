package com.racing.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.NewRacingResultVO;
import com.racing.controller.vo.RacingResultHistoryVO;
import com.racing.model.po.RecordResult;
import com.racing.model.po.util.RecordResultPOUtil;
import com.racing.model.repo.RecordResultRepo;
import com.racing.util.DateUtil;

@Service
public class RacingService {

  @Autowired
  private RecordResultRepo repo;

  public NewRacingResultVO getNewRacingResult() {
    Date nowDate = DateUtil.setDateMillisecondZero(new Date());
    NewRacingResultVO result = new NewRacingResultVO();
    RecordResult recordResult = repo.getNowNextRecordResult(nowDate);// 获取下一场比赛
    if (recordResult == null || DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate) > 300) {// 下一场比赛距离现在时间超过300秒不进行开始比赛（主要用于每天的第一场比赛）
      result.setIsCanStart(false);
      result.setServerTime(nowDate);
    } else {
      Long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);// 当前时间和下一场比赛的时间差
      if (betweenTime > 280) {// 若该比赛距离当前比赛还差280秒才开始，则获取的为上一轮比赛的信息，并且服务时间为上一轮比赛时间相差一秒
        RecordResult beforrecordResult = repo.getNowBeforLastRecordResult(nowDate);// 获取上一轮比赛
        if (beforrecordResult == null) {// 为获取到上一轮信息，使用下一场比赛的信息
          result.setIsCanStart(true);
          result.setRacingNum(recordResult.getRacingNum());
          if (betweenTime < 8) {// 离比赛开始时间小于五秒（缓冲3秒，代码写成8秒）
            result.setRacingResult(RecordResultPOUtil.convertResult(recordResult));
          }
          result.setStartTime(recordResult.getStartTime());
          result.setServerTime(nowDate);
        } else if (DateUtil.secondBetweenTwoDate(beforrecordResult.getStartTime(), nowDate) > 20) {// 若上一轮比赛距离现在大于20秒，则视为暂时比赛未开始
          result.setIsCanStart(false);
          result.setServerTime(nowDate);
        } else {
          result.setIsCanStart(true);
          result.setRacingNum(beforrecordResult.getRacingNum());
          result.setRacingResult(RecordResultPOUtil.convertResult(beforrecordResult));
          result.setStartTime(DateUtil.addSecond(beforrecordResult.getStartTime(), 3));// 开始时间加3秒
          result.setServerTime(beforrecordResult.getStartTime());// 开始时间作为服务器时间
        }
      } else {
        result.setIsCanStart(true);
        result.setRacingNum(recordResult.getRacingNum());
        if (betweenTime < 8) {// 离比赛开始时间小于五秒（缓冲3秒，代码写成8秒）
          result.setRacingResult(RecordResultPOUtil.convertResult(recordResult));
        }
        result.setStartTime(recordResult.getStartTime());
        result.setServerTime(nowDate);
      }
    }
    return result;
  }

  public List<RacingResultHistoryVO> getRacingResultHistory() {
    List<RacingResultHistoryVO> result = new ArrayList<RacingResultHistoryVO>();
    Date nowDate = DateUtil.setDateMillisecondZero(new Date());
    List<RecordResult> recordResultList = repo.getRecordResultByAfterTime(new Date());

    if (CollectionUtils.isNotEmpty(recordResultList)) {
      for (int i = 0; i < recordResultList.size(); i++) {
        RecordResult recordResult = recordResultList.get(i);
        if (i == 0) {
          Long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
          if (betweenTime < 20) {// 最近的一场比赛距离当前时间少于20秒则不显示记录
            continue;
          }
        }

        RacingResultHistoryVO vo = new RacingResultHistoryVO();
        if (i == 0) {
          vo.setIsLastResult(true);
        } else {
          vo.setIsLastResult(false);
        }

        vo.setRacingNum(recordResult.getRacingNum());
        vo.setRacingResult(RecordResultPOUtil.convertResult(recordResult));
        vo.setRacingTime(DateUtil.parseToString(recordResult.getStartTime(), DateUtil.DateFormat_HHmm));
        vo.setFirstAddSecond(recordResult.getFirstAddSecond());
        vo.setIsFirstSecondBig(recordResult.getIsFirstSecondBig());
        vo.setIsFirstSecondOdd(recordResult.getIsFirstSecondOdd());
        vo.setIsFirstUp(recordResult.getIsFirstUp());
        vo.setIsSecondUp(recordResult.getIsSecondUp());
        vo.setIsThirdUp(recordResult.getIsThirdUp());
        vo.setIsFourthUp(recordResult.getIsFourthUp());
        vo.setIsFifthUp(recordResult.getIsFifthUp());
        result.add(vo);
      }
    }

    return result;
  }

}
