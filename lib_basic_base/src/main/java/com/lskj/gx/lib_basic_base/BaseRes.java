package com.lskj.gx.lib_basic_base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: baseResponse
 * code
 * message
 * data
 */
public class BaseRes<T extends Parcelable> implements Parcelable {
  private int code;
  private String message;
  private T data;

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

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.code);
    dest.writeString(this.message);
    dest.writeParcelable(this.data, flags);
  }

  public BaseRes() {
  }

  protected BaseRes(Parcel in) {
    this.code = in.readInt();
    this.message = in.readString();
    String bString = in.readString();
    try {
      this.data = in.readParcelable(Class.forName(bString).getClassLoader());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static final Parcelable.Creator<BaseRes> CREATOR = new Parcelable.Creator<BaseRes>() {
    @Override public BaseRes createFromParcel(Parcel source) {
      return new BaseRes(source);
    }

    @Override public BaseRes[] newArray(int size) {
      return new BaseRes[size];
    }
  };

}
