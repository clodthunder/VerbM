package com.lskj.gx.lib_basic_base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建时间:  2020/8/25
 * 编写人: tzw
 * 功能描述:
 */
public abstract class BaseActivity extends AppCompatActivity implements IActivity {
  protected Unbinder unbinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int layoutId = initView(savedInstanceState);
    setContentView(layoutId);
    unbinder = ButterKnife.bind(this);
    initToolBar();
    initData(savedInstanceState);
  }

  @Override protected void onDestroy() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroy();
  }
}
