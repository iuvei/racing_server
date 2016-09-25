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

  public static String createUserAccessKey(String accessKey) {
    return accessKey + "_U";
  }

}
