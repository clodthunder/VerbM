package com.lskj.gx.lib_basic_utils;

/**
 * 创建时间:  2020/8/27
 * 编写人: tzw
 * 功能描述:
 */
public enum GxEnumDateFormat {
  DATE_FORMAT_YMD_HMS("yyyy-MM-dd HH:mm:ss", 1),
  DATE_FORMAT_YMD_HM("yyyy-MM-dd HH:mm", 2),
  DATE_FORMAT_YMD_H("yyyy-MM-dd HH", 3),
  DATE_FORMAT_YMD("yyyy-MM-dd", 4),
  DATE_FORMAT_YM("yyyy-MM", 5),
  DATE_FORMAT_Y("yyyy", 6);

  GxEnumDateFormat(String name, int index) {
    this.name = name;
    this.index = index;
  }

  private String name;
  private int index;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  @Override public String toString() {
    return "GxEnumDateFormat{" + "name='" + name + '\'' + ", index=" + index + '}';
  }
}
