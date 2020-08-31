package com.lskj.gx.lib_business_entity.vo;

import android.os.Parcel;
import com.lskj.gx.lib_basic_base.BaseVo;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述:服务端返回的数据格式
 */
public class UserVo extends BaseVo<UserVo> {
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

  public UserVo() {
  }

  protected UserVo(Parcel in) {
    super(in);
    this.token = in.readString();
  }

  public static final Creator<UserVo> CREATOR = new Creator<UserVo>() {
    @Override public UserVo createFromParcel(Parcel source) {
      return new UserVo(source);
    }

    @Override public UserVo[] newArray(int size) {
      return new UserVo[size];
    }
  };

  @Override public String toString() {
    return "UserVo{" + "token='" + token + '\'' + '}';
  }
}
