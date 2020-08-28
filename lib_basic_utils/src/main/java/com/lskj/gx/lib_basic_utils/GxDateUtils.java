package com.lskj.gx.lib_basic_utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建时间:  2020/8/27
 * 编写人: tzw
 * 功能描述: 日期工具类 包含日期格式化 日期计算等
 */
public class GxDateUtils {

  public static String format(Date date) {
    return format(date, null);
  }

  /**
   * Date2String
   */
  public static String format(Date date, GxEnumDateFormat dateFormat) {
    if (date == null) {
      return null;
    }
    if (dateFormat == null) {
      dateFormat = GxEnumDateFormat.DATE_FORMAT_YMD_HMS;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getName());
    return sdf.format(date);
  }

}
