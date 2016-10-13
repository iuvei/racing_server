package com.racing.service.stake;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.RecordResult;
import com.racing.model.repo.RecordResultRepo;
import com.racing.util.DateUtil;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordResultService {

    @Autowired
    private RecordResultRepo recordResultRepo;

    public ApiResult updateRacingResult(Integer[] racingResult, String racingNum) {
        Date nowDate = new Date();
        RecordResult recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
        if (recordResult == null) {
            return ApiResult.createErrorReuslt("未找到" + racingNum + "的比赛信息");
        }
        long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
        if (!(betweenTime >= 15 && betweenTime <= 40)) {// 原本是20~40秒可修改，以防万一，缓冲5秒
            return ApiResult.createErrorReuslt("当前" + racingNum + "的比赛暂不支持修改比赛结果");
        }

        if (racingResult.length != 10) {
            return ApiResult.createErrorReuslt("车号必须为十个，请确认调整的车号");
        }

        Map<Integer, Boolean> resultMap = new HashMap<Integer, Boolean>();
        for (Integer carNum : racingResult) {
            if (resultMap.get(carNum) == null || resultMap.get(carNum) == false) {
                resultMap.put(carNum, true);
            } else {
                return ApiResult.createErrorReuslt("车号有重复的，请确认调整的车号");
            }
        }

        recordResult.setFirst(racingResult[0]);
        recordResult.setSecond(racingResult[1]);
        recordResult.setThird(racingResult[2]);
        recordResult.setFourth(racingResult[3]);
        recordResult.setFifth(racingResult[4]);
        recordResult.setSixth(racingResult[5]);
        recordResult.setSeventh(racingResult[6]);
        recordResult.setEighth(racingResult[7]);
        recordResult.setNinth(racingResult[8]);
        recordResult.setTenth(racingResult[9]);

        recordResult.setFirstAddSecond(racingResult[0] + racingResult[1]);
        recordResult.setIsFirstSecondBig((racingResult[0] + racingResult[1]) > 11);
        recordResult.setIsFirstSecondOdd((racingResult[0] + racingResult[1]) % 2 == 0);
        recordResult.setIsFirstUp(racingResult[0] > racingResult[9]);
        recordResult.setIsSecondUp(racingResult[1] > racingResult[8]);
        recordResult.setIsThirdUp(racingResult[2] > racingResult[7]);
        recordResult.setIsFourthUp(racingResult[3] > racingResult[6]);
        recordResult.setIsFifthUp(racingResult[4] > racingResult[5]);

        recordResultRepo.updateRecordResultByRacingNum(recordResult, racingNum);
        return ApiResult.createSuccessReuslt("结果修改成功！");
    }

    public Object selectRacingResult(Integer page) {
        Date date = new Date();
        date.setTime(date.getTime() - 40);
        List<RecordResult> list = recordResultRepo.selectRacingResult(date, PageUtil.createPage(page, 20));
        return ApiResult.createSuccessReuslt(list);
    }
}
