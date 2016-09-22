package com.racing.util;

import javax.servlet.http.HttpSession;

import jodd.util.StringUtil;

public class SessionUtil {

  public static boolean checkUser(HttpSession session) {
    if (session.getAttribute("user") != null) {
      String islogin = (String) session.getAttribute("user");
      if (StringUtil.isNotEmpty(islogin) && islogin.equals("true")) {
        return true;
      }
    }
    return false;
  }

  public static void setUser(HttpSession session) {
    session.setAttribute("user", "true");
  }

}
