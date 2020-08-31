package com.lskj.gx.lib_business_entity.dto;

import android.os.Parcel;
import com.lskj.gx.lib_basic_base.BaseDto;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述:
 */
public class UserDto extends BaseDto<UserDto> {
  /**
   * 用户名称
   */
  private String account;
  private String password;

  public UserDto(String account, String password) {
    this.account = account;
    this.password = password;
  }

  public UserDto(Parcel in, String account, String password) {
    super(in);
    this.account = account;
    this.password = password;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.account);
    dest.writeString(this.password);
  }

  public UserDto(Parcel in) {
    super(in);
    this.account = in.readString();
    this.password = in.readString();
  }

  public static final Creator<UserDto> CREATOR = new Creator<UserDto>() {
    @Override public UserDto createFromParcel(Parcel source) {
      return new UserDto(source);
    }

    @Override public UserDto[] newArray(int size) {
      return new UserDto[size];
    }
  };
}
