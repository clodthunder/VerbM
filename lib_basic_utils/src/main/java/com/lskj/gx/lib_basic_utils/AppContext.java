package com.lskj.gx.lib_basic_utils;

import android.app.Application;
import android.content.Context;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: 这个用于业务层、basic 层获取ApplicationContext 实例
 */
public class AppContext {
  /**
   * 业务层、基础层 获取Application实例
   */
  private static Context context;
  private static Application application;

  public static Context getContext() {
    return context;
  }

  public static void init(Application app) {
    if (context == null) {
      context = app.getApplicationContext();
    }
    application = app;
  }

  public static Application getInstance() {
    return application;
  }
}
