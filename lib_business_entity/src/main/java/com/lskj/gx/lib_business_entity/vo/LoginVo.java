package com.lskj.gx.lib_business_entity.vo;

import android.os.Parcel;
import com.lskj.gx.lib_basic_base.BaseVo;

/**
 * 创建时间:  2020/9/7
 * 编写人: tzw
 * 功能描述:
 */
public class LoginVo extends BaseVo<LoginVo> {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.token);
  }

  public LoginVo() {
  }

  protected LoginVo(Parcel in) {
    super(in);
    this.token = in.readString();
  }

  public static final Creator<LoginVo> CREATOR = new Creator<LoginVo>() {
    @Override public LoginVo createFromParcel(Parcel source) {
      return new LoginVo(source);
    }

    @Override public LoginVo[] newArray(int size) {
      return new LoginVo[size];
    }
  };

  @Override public String toString() {
    return "LoginVo{" + "token='" + token + '\'' + '}';
  }
}
