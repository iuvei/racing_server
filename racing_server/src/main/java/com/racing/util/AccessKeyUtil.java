package com.racing.util;

public class AccessKeyUtil {


  public static String getAccessKey(String requestAccessKey) {
    String[] access = requestAccessKey.split("_");
    return access[0];
  }

  public static String createManagerAccessKey(String accessKey) {
    return accessKey + "_M";
  }

  public static boolean checkAccessKeyIsManager(String requestAccessKey) {
    String[] access = requestAccessKey.split("_");
    if (access.length == 2 && access[1].equals("M")) {
      return true;
    }
    return false;
  }

  public static String createWebUserAccessKey(String accessKey) {
    return accessKey + "_UB";
  }

  public static boolean checkAccessKeyIsWebUser(String requestAccessKey) {
    String[] access = requestAccessKey.split("_");
    if (access.length == 2 && access[1].equals("UB")) {
      return true;
    }
    return false;
  }

  public static String createClientUserAccessKey(String accessKey) {
    return accessKey + "_UC";
  }

  public static boolean checkAccessKeyIsClientUser(String requestAccessKey) {
    String[] access = requestAccessKey.split("_");
    if (access.length == 2 && access[1].equals("UC")) {
      return true;
    }
    return false;
  }

}
