package com.lskj.gx.lib_business_entity.vo;

import android.os.Parcel;
import com.lskj.gx.lib_basic_base.BaseVo;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述:服务端返回的数据格式
 */
public class UserVo extends BaseVo<UserVo> {
  private String userId;
  //登录名称
  private String userName;
  //登录账号
  private String account;
  //登录密码 请存储加密后的用户凭证
  private String pwd;
  //登录凭证可以存token
  private String cert;
  //用户手机号
  private String phone;
  //用户邮箱  可以
  private String email;
  //联系地址
  private String address;
  //判断是否勾选中
  private boolean isChecked;

  public boolean isChecked() {
    return isChecked;
  }

  public void setChecked(boolean checked) {
    isChecked = checked;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.userId);
    dest.writeString(this.userName);
    dest.writeString(this.account);
    dest.writeString(this.pwd);
    dest.writeString(this.cert);
    dest.writeString(this.phone);
    dest.writeString(this.email);
    dest.writeString(this.address);
    dest.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
  }

  public UserVo() {
  }

  protected UserVo(Parcel in) {
    super(in);
    this.userId = in.readString();
    this.userName = in.readString();
    this.account = in.readString();
    this.pwd = in.readString();
    this.cert = in.readString();
    this.phone = in.readString();
    this.email = in.readString();
    this.address = in.readString();
    this.isChecked = in.readByte() != 0;
  }

  public static final Creator<UserVo> CREATOR = new Creator<UserVo>() {
    @Override public UserVo createFromParcel(Parcel source) {
      return new UserVo(source);
    }

    @Override public UserVo[] newArray(int size) {
      return new UserVo[size];
    }
  };
}
