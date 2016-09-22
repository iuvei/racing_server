package com.racing.controller.old;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResutl;
import com.racing.util.EncryptUtil;
import com.racing.util.ListUtil;
import com.racing.util.ServeltRequestUtil;

import jodd.util.StringUtil;

@RestController
public class SingTestController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SingTestController.class);

  @RequestMapping(value = "/sign/check", method = RequestMethod.POST)
  public Object checkSign(HttpServletRequest request) {

    String source = "";

    String accesskey = "098oiujklmnb";// 暂时写死，需要通过头部Accesskey的值获取

    String requestSign = request.getHeader("Authorization");

    String securityKey = "123ewqasdcxz";// 暂时写死，需要通过Accesskey获取对应用户的securityKey

    String url = request.getRequestURI();
    Map<String, String> requestQueryString = this.getRequestQueryStringData(request);
    String requestMethod = request.getMethod();
    String valueStr = "";
    if (requestMethod.equalsIgnoreCase("POST") || requestMethod.equalsIgnoreCase("PUT")) {
      String requestBody = ServeltRequestUtil.getRequestJsonString(request);
      if (StringUtil.isEmpty(requestBody)) {
        requestBody = "";
      }
      requestQueryString.put("requestBody", requestBody);
    }
    valueStr = ListUtil.sortMapParameterValueStr(requestQueryString);

    String preSign = url + valueStr + securityKey;
    LOGGER.debug("加密前的串为：" + preSign);
    String sign = EncryptUtil.sha1UpperCase(preSign);
    LOGGER.debug("加密后的串为：" + sign);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("加密前的串为", preSign);
    result.put("加密后的串为", sign);
    result.put("验证结果", sign.equals(requestSign));
    return ApiResutl.createSuccessReuslt(result);
  }

  private Map<String, String> getRequestQueryStringData(ServletRequest request) {
    Map<String, String> dataMap = new HashMap<String, String>();
    Map<String, String[]> urlData = request.getParameterMap();
    for (String key : urlData.keySet()) {
      dataMap.put(key, urlData.get(key)[0]);
    }
    return dataMap;
  }


}
