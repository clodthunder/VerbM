package com.lskj.gx.lib_basic_base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: 主要接受后台返回来的数据
 */
public class BaseVo<T extends Parcelable> implements Parcelable {
  private T vo;

  public static final Creator<BaseVo> CREATOR = new Creator<BaseVo>() {
    @Override public BaseVo createFromParcel(Parcel in) {
      return new BaseVo(in);
    }

    @Override public BaseVo[] newArray(int size) {
      return new BaseVo[size];
    }
  };

  public T getVo() {
    return vo;
  }

  public void setVo(T vo) {
    this.vo = vo;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.vo, flags);
  }

  public BaseVo() {
  }

  protected BaseVo(Parcel in) {
    String voName = in.readString();
    try {
      this.vo = in.readParcelable(Class.forName(voName).getClassLoader());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
