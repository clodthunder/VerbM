package com.lskj.gx.lib_basic_base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建时间:  2020/8/26
 * 编写人: tzw
 * 功能描述: 基础用户类 日志模块使用到该类 请继承该类
 */
public class BaseUser implements Parcelable {
  protected String userId;
  //登录名称
  protected String userName;
  //登录账号
  protected String account;
  //登录密码 请存储加密后的用户凭证
  protected String pwd;
  //登录凭证可以存token
  protected String cert;

  public BaseUser(String userId, String userName, String account, String pwd, String cert) {
    this.userId = userId;
    this.userName = userName;
    this.account = account;
    this.pwd = pwd;
    this.cert = cert;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getCert() {
    return cert;
  }

  public void setCert(String cert) {
    this.cert = cert;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.userId);
    dest.writeString(this.userName);
    dest.writeString(this.account);
    dest.writeString(this.pwd);
    dest.writeString(this.cert);
  }

  protected BaseUser(Parcel in) {
    this.userId = in.readString();
    this.userName = in.readString();
    this.account = in.readString();
    this.pwd = in.readString();
    this.cert = in.readString();
  }

  public static final Parcelable.Creator<BaseUser> CREATOR = new Parcelable.Creator<BaseUser>() {
    @Override public BaseUser createFromParcel(Parcel source) {
      return new BaseUser(source);
    }

    @Override public BaseUser[] newArray(int size) {
      return new BaseUser[size];
    }
  };
}
