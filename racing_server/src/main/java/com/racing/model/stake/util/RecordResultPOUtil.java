package com.racing.model.stake.util;

import com.racing.model.po.RecordResult;

public class RecordResultPOUtil {

  public static Integer[] convertResult(RecordResult recordResult) {
    Integer[] result = new Integer[10];

    result[0] = (recordResult.getFirst());
    result[1] = (recordResult.getSecond());
    result[2] = (recordResult.getThird());
    result[3] = (recordResult.getFourth());
    result[4] = (recordResult.getFifth());
    result[5] = (recordResult.getSixth());
    result[6] = (recordResult.getSeventh());
    result[7] = (recordResult.getEighth());
    result[8] = (recordResult.getNinth());
    result[9] = (recordResult.getTenth());
    return result;
  }

}
