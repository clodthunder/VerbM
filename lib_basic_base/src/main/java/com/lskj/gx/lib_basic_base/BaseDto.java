package com.lskj.gx.lib_basic_base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: 封装的base dto
 */
public class BaseDto<T extends Parcelable> implements Parcelable {
  private T dto;

  public T getDto() {
    return dto;
  }

  public void setDto(T dto) {
    this.dto = dto;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.dto, flags);
  }

  public BaseDto() {
  }

  protected BaseDto(Parcel in) {
    String dtoName = in.readString();
    try {
      this.dto = in.readParcelable((Class.forName(dtoName)).getClassLoader());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static final Creator<BaseDto> CREATOR = new Creator<BaseDto>() {
    @Override public BaseDto createFromParcel(Parcel source) {
      return new BaseDto(source);
    }

    @Override public BaseDto[] newArray(int size) {
      return new BaseDto[size];
    }
  };
}
