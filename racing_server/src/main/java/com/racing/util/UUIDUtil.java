package com.racing.util;

import java.util.UUID;

public class UUIDUtil {
  public static String getUUID() {
    UUID uuid = UUID.randomUUID();
    String str = uuid.toString();
    return str.replace("-", "");
  }

  public static String getUUIDUpcase() {
    return getUUID().toUpperCase();
  }

}
