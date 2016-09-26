package com.racing.constant;

public class UserConstant {

  /**
   * 用户申请积分状态
   * 待处理/批准/拒绝/取消
   */
  public static final String POINTS_APP_STATUS_UNTREATED = "UNTREATED";
  public static final String POINTS_APP_STATUS_AUDIT = "AUDIT";
  public static final String POINTS_APP_STATUS_REJECT = "REJECT";
  public static final String POINTS_APP_STATUS_CANCEL = "CANCEL";

  /**
   * 用户积分变化记录状态
   * 总盘加积分，总盘减积分，给用户上分，给用户下分，报盘，开奖
   */
  public static final String ACCOUNT_RECORD_TYPE_MANAGER_ADD = "MANAGER_ADD";
  public static final String ACCOUNT_RECORD_TYPE_MANAGER_SUBTRACT = "MANAGER_SUBTRACT";
  public static final String ACCOUNT_RECORD_TYPE_USER_ADD = "USER_ADD";
  public static final String ACCOUNT_RECORD_TYPE_USER_SUBTRACT = "USER_SUBTRACT";
  public static final String ACCOUNT_RECORD_TYPE_OFFER = "OFFER";
  public static final String ACCOUNT_RECORD_TYPE_LOTTERY = "LOTTERY";
}
