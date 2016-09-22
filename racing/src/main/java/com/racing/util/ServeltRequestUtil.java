package com.racing.util;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServeltRequestUtil {

  private static Logger logger = LoggerFactory.getLogger(ServeltRequestUtil.class);

  public static String getRequestJsonString(ServletRequest request) {
    StringBuffer jsonBuf = new StringBuffer();
    byte[] buf = new byte[1024];
    int len = -1;

    InputStream in;
    try {
      in = request.getInputStream();
      while ((len = in.read(buf)) != -1) {
        jsonBuf.append(new String(buf, 0, len));
      }
    } catch (IOException e) {
      logger.error("", e);
      return "";
    }
    return jsonBuf.toString().replaceAll(" ", "");
  }

}
