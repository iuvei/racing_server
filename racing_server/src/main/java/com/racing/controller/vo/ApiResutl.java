package com.racing.controller.vo;

public class ApiResutl {

  private static final String SUCCESS = "SUCCESS";

  private static final String ERROR = "ERROR";

  private static final String NO_LOGIN = "NO_LOGIN";

  private String result;

  private Object data;

  private String message;

  public static ApiResutl createSuccessReuslt(Object data) {
    ApiResutl result = new ApiResutl();
    result.setData(data);
    result.setResult(SUCCESS);
    return result;
  }

  public static ApiResutl createSuccessReuslt() {
    ApiResutl result = new ApiResutl();
    result.setResult(SUCCESS);
    return result;
  }

  public static ApiResutl createNoLoginReuslt() {
    ApiResutl result = new ApiResutl();
    result.setResult(NO_LOGIN);
    return result;
  }

  public static ApiResutl createSuccessReuslt(String message) {
    ApiResutl result = new ApiResutl();
    result.setResult(SUCCESS);
    result.setMessage(message);
    return result;
  }

  public static ApiResutl createErrorReuslt(String message) {
    ApiResutl result = new ApiResutl();
    result.setMessage(message);
    result.setResult(ERROR);
    return result;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static String getNoLogin() {
    return NO_LOGIN;
  }

}
