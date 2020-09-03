package com.lskj.gx.lib_basic_base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建时间:  2020/9/3
 * 编写人: tzw
 * 功能描述: 封装基础image 实体类
 */
public class ImageEntity implements Parcelable {
  //image id
  private String id;
  //image 所属记录id
  private String pid;
  //image路径  url uri drawable id bitmap
  private String url;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override public String toString() {
    return "ImageEntity{" + "id='" + id + '\'' + ", pid='" + pid + '\'' + ", url='" + url + '\'' + '}';
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.id);
    dest.writeString(this.pid);
    dest.writeString(this.url);
  }

  public ImageEntity() {
  }

  public ImageEntity(String id, String pid, String url) {
    this.id = id;
    this.pid = pid;
    this.url = url;
  }

  protected ImageEntity(Parcel in) {
    this.id = in.readString();
    this.pid = in.readString();
    this.url = in.readString();
  }

  public static final Parcelable.Creator<ImageEntity> CREATOR = new Parcelable.Creator<ImageEntity>() {
    @Override public ImageEntity createFromParcel(Parcel source) {
      return new ImageEntity(source);
    }

    @Override public ImageEntity[] newArray(int size) {
      return new ImageEntity[size];
    }
  };
}
