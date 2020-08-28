package com.lskj.gx.lib_business_user.entity;

import android.os.Parcel;
import com.lskj.gx.lib_basic_base.BaseUser;

/**
 * 创建时间:  2020/8/26
 * 编写人: tzw
 * 功能描述: app 登录使用的用户实体类
 */
public class GxUser extends BaseUser {
  //用户手机号
  private String phone;
  //用户邮箱  可以
  private String email;
  //联系地址
  private String address;

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
    dest.writeString(this.phone);
    dest.writeString(this.email);
    dest.writeString(this.address);
  }

  public GxUser() {
  }

  protected GxUser(Parcel in) {
    super(in);
    this.phone = in.readString();
    this.email = in.readString();
    this.address = in.readString();
  }

  public static final Creator<GxUser> CREATOR = new Creator<GxUser>() {
    @Override public GxUser createFromParcel(Parcel source) {
      return new GxUser(source);
    }

    @Override public GxUser[] newArray(int size) {
      return new GxUser[size];
    }
  };

  @Override public String toString() {
    return "GxUser{"
        + "phone='"
        + phone
        + '\''
        + ", email='"
        + email
        + '\''
        + ", address='"
        + address
        + '\''
        + ", userName='"
        + userName
        + '\''
        + ", account='"
        + account
        + '\''
        + ", pwd='"
        + pwd
        + '\''
        + ", cert='"
        + cert
        + '\''
        + '}';
  }
}
