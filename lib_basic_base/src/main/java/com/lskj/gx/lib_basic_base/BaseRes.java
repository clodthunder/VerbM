package com.lskj.gx.lib_basic_base;

import java.io.Serializable;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: baseResponse
 * code
 * message
 * data
 */
public class BaseRes<R extends Serializable> {
  private int code;
  private String message;
  private R data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public R getData() {
    return data;
  }

  public void setData(R data) {
    this.data = data;
  }

  public BaseRes() {
  }
}
