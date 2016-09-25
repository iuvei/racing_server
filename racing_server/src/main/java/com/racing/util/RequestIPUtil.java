package com.racing.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jodd.util.StringUtil;

public class RequestIPUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(RequestIPUtil.class);

  /**
   * 获取访问者IP
   * 
   * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
   * 
   * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)， 如果还不存在则调用Request .getRemoteAddr()。
   * 
   * @param request
   * @return
   */
  public static String getIpAddr(HttpServletRequest request) {
    try {
      String ip = request.getHeader("X-Real-IP");
      if (!StringUtil.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
        return ip;
      }
      ip = request.getHeader("X-Forwarded-For");
      if (!StringUtil.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
        // 多次反向代理后会有多个IP值，第一个为真实IP。
        int index = ip.indexOf(',');
        if (index != -1) {
          return ip.substring(0, index);
        } else {
          return ip;
        }
      } else {
        return request.getRemoteAddr();
      }
    } catch (Exception e) {
      LOGGER.error("获取IP地址出现异常！", e);
      return "";
    }
  }

}
