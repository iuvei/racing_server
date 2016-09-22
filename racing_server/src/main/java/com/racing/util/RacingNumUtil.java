package com.racing.util;

import java.util.Date;

public class RacingNumUtil {

  public static String dealNewRacingNum(Date nowDate) {
    return RacingNumUtil.dealNewRacingNum(nowDate, null);
  }

  public static String dealNewRacingNum(Date nowDate, String previousRacingNum) {
    String nowDateStr = DateUtil.parseToString(nowDate, DateUtil.DateFormat_yyyyMMdd);

    if (previousRacingNum == null || previousRacingNum.equals("")) {
      return nowDateStr + "0001";
    }

    String preDateStr = previousRacingNum.substring(0, 8);

    if (nowDateStr.equals(preDateStr)) {
      String num = Integer.parseInt(previousRacingNum.substring(8)) + 1 + "";
      if (num.length() < 4) {
        int l = num.length();
        for (int i = 0; i < 4 - l; i++) {
          num = "0" + num;
        }
      }
      return preDateStr + num;
    } else {
      return nowDateStr + "0001";
    }

  }

}
