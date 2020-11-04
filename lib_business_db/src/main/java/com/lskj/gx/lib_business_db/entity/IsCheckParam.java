package com.lskj.gx.lib_business_db.entity;

/**
 * 创建时间:  2020/9/9
 * 编写人: tzw
 * 功能描述: room delete 删除条件
 */
public class IsCheckParam {
  //必须包含primarykey
  private String userId;
  //是否选中
  private int isCheck;

  public IsCheckParam() {
  }

  public IsCheckParam(String userId, int isCheck) {
    this.userId = userId;
    this.isCheck = isCheck;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getIsCheck() {
    return isCheck;
  }

  public void setIsCheck(int isCheck) {
    this.isCheck = isCheck;
  }

  @Override public String toString() {
    return "IsCheckParam{" + "userId='" + userId + '\'' + ", isCheck=" + isCheck + '}';
  }
}
