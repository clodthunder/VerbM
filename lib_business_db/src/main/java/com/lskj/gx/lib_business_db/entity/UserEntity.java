package com.lskj.gx.lib_business_db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 创建时间:  2020/9/8
 * 编写人: tzw
 * 功能描述: 操作数据库的
 */
@Entity(tableName = "t_user") public class UserEntity implements Parcelable {
  @NonNull @PrimaryKey String userId;
  //登录名称
  @ColumnInfo String userName;
  @NonNull
  //登录账号
  @ColumnInfo String account;
  //登录密码 请存储加密后的用户凭证
  @NonNull @ColumnInfo String pwd;
  //登录凭证可以存token
  @NonNull @ColumnInfo String cert;
  //用户手机号
  @ColumnInfo String phone;
  //用户邮箱  可以
  @ColumnInfo String email;
  //联系地址
  @ColumnInfo String address;
  //是否选中
  @ColumnInfo(defaultValue = "0") int isCheck;

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

  public int getIsCheck() {
    return isCheck;
  }

  public void setIsCheck(int isCheck) {
    this.isCheck = isCheck;
  }

  @Override public String toString() {
    return "UserEntity{"
        + "userId='"
        + userId
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
        + ", phone='"
        + phone
        + '\''
        + ", email='"
        + email
        + '\''
        + ", address='"
        + address
        + '\''
        + ", isCheck="
        + isCheck
        + '}';
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
    dest.writeString(this.phone);
    dest.writeString(this.email);
    dest.writeString(this.address);
    dest.writeInt(this.isCheck);
  }

  public UserEntity() {
  }

  protected UserEntity(Parcel in) {
    this.userId = in.readString();
    this.userName = in.readString();
    this.account = in.readString();
    this.pwd = in.readString();
    this.cert = in.readString();
    this.phone = in.readString();
    this.email = in.readString();
    this.address = in.readString();
    this.isCheck = in.readInt();
  }

  public static final Creator<UserEntity> CREATOR = new Creator<UserEntity>() {
    @Override public UserEntity createFromParcel(Parcel source) {
      return new UserEntity(source);
    }

    @Override public UserEntity[] newArray(int size) {
      return new UserEntity[size];
    }
  };
}
