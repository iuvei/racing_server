package com.racing.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import jodd.util.StringUtil;

public class SignUtil {

  /**
   * 根据参数生成签名并返回签名之后的参数
   * 
   * @param para
   * @param signKey
   * @return
   */
  public static Map<String, String> signParameter(Map<String, String> para, String signKey) {
    Map<String, String> result = new HashMap<String, String>();
    String sign = generateSign(para, signKey);
    result.putAll(para);
    result.put("sign", sign);
    return result;
  }

  /**
   * 根据参数生成签名
   * 
   * @param para
   * @param signKey
   * @return
   */
  public static String generateSign(Map<String, String> para, String signKey) {
    if (para == null || para.isEmpty()) {
      throw new RuntimeException("生成交易签名错误");
    } else {
      Map<String, String> sortPara = new TreeMap<String, String>();
      sortPara.putAll(para);
      String signStr = "";
      for (String key : sortPara.keySet()) {
        String value = sortPara.get(key);
        if (!StringUtil.isEmpty(value)) {
          signStr += value;
        }
      }
      signStr += signKey;
      return EncryptUtil.md5UpperCase(signStr);
    }
  }

}
