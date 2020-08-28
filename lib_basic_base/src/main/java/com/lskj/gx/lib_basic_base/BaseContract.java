package com.lskj.gx.lib_basic_base;

import androidx.annotation.StringRes;

/**
 * 创建时间:  2020/8/24
 * 编写人: tzw
 * 功能描述:  MVP模式中公共的基本契约
 */
public interface BaseContract {
  // 基本的界面职责
  interface View<T extends Presenter> {
    // 公共的：显示一个字符串错误
    void showError(@StringRes int str);

    // 公共的：显示进度条
    void showLoading();

    // 支持设置一个Presenter
    void setPresenter(T presenter);
  }

  // 基本的Presenter职责
  interface Presenter {
    // 共用的开始触发
    void start();

    // 共用的销毁触发
    void destroy();
  }
}
