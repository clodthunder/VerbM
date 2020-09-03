package com.lskj.gx.lib_basic_base;

import android.view.View;

/**
 * 创建时间:  2020/9/3
 * 编写人: tzw
 * 功能描述: 防止快速重复点击
 */
public abstract class BaseOnClickListener implements View.OnClickListener {
  // 两次点击按钮之间的点击间隔不能少于1000毫秒
  private static final int MIN_CLICK_DELAY_TIME = 1500;
  private static long lastClickTime;

  public abstract void onMultiClick(View v);

  @Override public void onClick(View v) {
    long curClickTime = System.currentTimeMillis();
    if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
      // 超过点击间隔后再将lastClickTime重置为当前点击时间
      lastClickTime = curClickTime;
      onMultiClick(v);
    }
  }
}
