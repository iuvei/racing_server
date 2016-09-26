package com.racing.constant;

public class UserPointsAppStatusConstant {

  /**
   * 用户申请积分状态
   * 待处理/批准/拒绝/取消
   */
  public static final String UNTREATED = "UNTREATED";
  public static final String AUDIT = "AUDIT";
  public static final String REJECT = "REJECT";
  public static final String CANCEL = "CANCEL";

  /**
   * 用户积分变化记录状态
   * 总盘加积分，总盘减积分，给用户上分，给用户下分，报盘，开奖
   */
  public static final String MANAGER_ADD = "MANAGER_ADD";
  public static final String MANAGER_SUBTRACT = "MANAGER_SUBTRACT";
  public static final String USER_ADD = "USER_ADD";
  public static final String USER_SUBTRACT = "USER_SUBTRACT";
  public static final String OFFER = "OFFER";
  public static final String LOTTERY = "LOTTERY";
}
