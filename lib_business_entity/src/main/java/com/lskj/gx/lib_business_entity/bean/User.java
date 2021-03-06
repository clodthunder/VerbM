package com.lskj.gx.lib_business_entity.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.lskj.gx.lib_basic_base.BaseUser;

/**
 * 创建时间:  2020/8/26
 * 编写人: tzw
 */
public class User extends BaseUser {
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

  protected User(Parcel in) {
    super(in);
    this.phone = in.readString();
    this.email = in.readString();
    this.address = in.readString();
  }

  public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
    @Override public User createFromParcel(Parcel source) {
      return new User(source);
    }

    @Override public User[] newArray(int size) {
      return new User[size];
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
