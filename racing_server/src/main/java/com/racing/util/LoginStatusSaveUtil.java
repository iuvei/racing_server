package com.racing.util;

import java.util.HashMap;
import java.util.Map;

public class LoginStatusSaveUtil {

  private static ThreadLocal<Map<String, String>> loginInfo = new ThreadLocal<Map<String, String>>();

  private final static String LOGIN_TYPE_MANAGER = "M";
  private final static String LOGIN_TYPE_USER_WEB = "UB";

  private final static String LOGIN_TYPE_USER_CLIENT = "UC";

  public static void setManagerLoginInfo(Integer managerId) {
    Map<String, String> managerLoginInfo = new HashMap<String, String>();
    managerLoginInfo.put("type", LOGIN_TYPE_MANAGER);
    managerLoginInfo.put("id", managerId.toString());
    loginInfo.set(managerLoginInfo);
  }

  public static Integer getManagerId() {
    Map<String, String> loginInfoMap = loginInfo.get();
    if (loginInfoMap == null) {
      return null;
    }
    return LOGIN_TYPE_MANAGER.equalsIgnoreCase(loginInfoMap.get("type")) ? Integer.parseInt(loginInfoMap.get("id")) : null;

  }

  public static void setUserWebLoginInfo(Integer userId) {
    Map<String, String> managerLoginInfo = new HashMap<String, String>();
    managerLoginInfo.put("type", LOGIN_TYPE_USER_WEB);
    managerLoginInfo.put("id", userId.toString());
    loginInfo.set(managerLoginInfo);
  }

  public static Integer getUserWebId() {
    Map<String, String> loginInfoMap = loginInfo.get();
    if (loginInfoMap == null) {
      return null;
    }
    return LOGIN_TYPE_USER_WEB.equalsIgnoreCase(loginInfoMap.get("type")) ? Integer.parseInt(loginInfoMap.get("id")) : null;

  }

  public static void setUserClientLoginInfo(Integer userId) {
    Map<String, String> managerLoginInfo = new HashMap<String, String>();
    managerLoginInfo.put("type", LOGIN_TYPE_USER_CLIENT);
    managerLoginInfo.put("id", userId.toString());
    loginInfo.set(managerLoginInfo);
  }

  public static Integer getUserClientId() {
    Map<String, String> loginInfoMap = loginInfo.get();
    if (loginInfoMap == null) {
      return null;
    }
    return LOGIN_TYPE_USER_CLIENT.equalsIgnoreCase(loginInfoMap.get("type")) ? Integer.parseInt(loginInfoMap.get("id")) : null;

  }


}
