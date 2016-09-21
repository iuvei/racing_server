package com.racing.util;

import java.util.Random;
import java.util.UUID;

public class GenerateCodeUtil {

  /**
   * 生成对应长度的验证码(数字)
   * 
   * @param length
   * @return
   */
  public static String randomNumStr(int length) {
    String code = "";
    char[] arrChar = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    Random ran = new Random();
    for (int i = 0; i < length; i++) {
      code += arrChar[ran.nextInt(arrChar.length)];
    }
    return code;
  }

  /**
   * 生成一个UUID数据(32位)
   * 
   * @return
   */
  public static String getUUID() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString().replace("-", "").toLowerCase();
  }

  public static void main(String[] args) {
    System.out.println(GenerateCodeUtil.getUUID().length());
  }

  /**
   * 获取一个随机的int值(包括aStart 和 aEnd )
   * 
   * @param aStart
   * @param aEnd
   * @param aRandom
   * @return
   */
  public static int getRandomInt(int aStart, int aEnd, Random aRandom) {
    if (aStart > aEnd) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    long range = (long) aEnd - (long) aStart + 1;
    long fraction = (long) (range * aRandom.nextDouble());
    int randomNumber = (int) (fraction + aStart);
    return randomNumber;
  }

  /**
   * 获取指定长度的随机英文字母
   * 
   * @param length
   * @return
   */
  public static String getRandomLetters(int length) {
    String[] strs = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    Random random = new Random();
    String result = "";
    for (int i = 0; i < length; i++) {
      result = result + strs[random.nextInt(26)];
    }
    return result;
  }

  public static String randomUserName() {
    String[] strs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
        "w", "x", "y", "z"};
    Random random = new Random();
    String result = "";
    for (int i = 0; i < 9; i++) {
      result = result + strs[random.nextInt(36)];
    }
    return "XG_" + result;
  }
}
