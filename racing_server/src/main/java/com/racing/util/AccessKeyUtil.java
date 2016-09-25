package com.racing.util;

public class AccessKeyUtil {

  public static String createManagerAccessKey(String accessKey) {
    return accessKey + "_M";
  }

  public static boolean checkAccessKeyIsManager(String accessKey) {
    String[] access = accessKey.split("_");
    if (access.length == 2 && access[1].equals("M")) {
      return true;
    }
    return false;
  }

  public static String createWebUserAccessKey(String accessKey) {
    return accessKey + "_UB";
  }

  public static boolean checkWebUserAccessKeyIsManager(String accessKey) {
    String[] access = accessKey.split("_");
    if (access.length == 2 && access[1].equals("UB")) {
      return true;
    }
    return false;
  }

  public static String createClientUserAccessKey(String accessKey) {
    return accessKey + "_UC";
  }

  public static boolean checkClientUserAccessKeyIsManager(String accessKey) {
    String[] access = accessKey.split("_");
    if (access.length == 2 && access[1].equals("UC")) {
      return true;
    }
    return false;
  }

}
