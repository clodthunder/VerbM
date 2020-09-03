package com.lskj.gx.lib_basic_utils;

import android.content.Context;

/**
 * 创建时间:  2020/9/2
 * 编写人: tzw
 * 功能描述:
 */
public class ScreenUtil {
  /**
   * dp 2 px
   */
  public static int dp2px(float dpValue) {
    final float scale = AppContext.getContext().getResources().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }

  public static int px2dp(Context context, float pxValue) {
    final float scale = AppContext.getContext().getResources().getDisplayMetrics().density;
    return (int) (pxValue / scale + 0.5f);
  }

  /**
   * 将px值转换为sp值，保证文字大小不变
   * DisplayMetrics类中属性scaledDensity
   */
  public static int px2sp(Context context, float pxValue) {
    final float fontScale = AppContext.getContext().getResources().getDisplayMetrics().scaledDensity;
    return (int) (pxValue / fontScale + 0.5f);
  }

  /**
   * 将sp值转换为px值，保证文字大小不变
   * DisplayMetrics类中属性scaledDensity
   * TextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyApplication.getAppContext().getResources().getDimension(value))
   */
  public static int sp2px(Context context, float spValue) {
    final float fontScale = AppContext.getContext().getResources().getDisplayMetrics().scaledDensity;
    return (int) (spValue * fontScale + 0.5f);
  }
}