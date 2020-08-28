package com.lskj.gx.lib_basic_base;

import android.os.Bundle;
import androidx.annotation.Nullable;

/**
 * 创建时间:  2020/8/25
 * 编写人: tzw
 * 功能描述:
 */
public interface IActivity {

  int initView(@Nullable Bundle savedInstanceState);

  void initData(@Nullable Bundle savedInstanceState);

  void initToolBar();
}
