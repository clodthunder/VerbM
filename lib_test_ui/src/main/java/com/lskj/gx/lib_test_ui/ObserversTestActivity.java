package com.lskj.gx.lib_test_ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lskj.gx.lib_basic_base.BaseActivity;

/**
 * 创建时间:  2020/11/11
 * 编写人: tzw
 * 功能描述: 观察者模式的使用
 */
@Route(path = "/test_ui/observers_test") public class ObserversTestActivity extends BaseActivity {
  @BindView(R2.id.et_input_observer) EditText etContent;
  @BindView(R2.id.tv_oberser_list) TextView tvOberserList;
  @BindView(R2.id.tv_observer_logs) TextView tvObserverLogs;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_observers_test);
  }

  @Override public int initView(@Nullable Bundle savedInstanceState) {
    return 0;
  }

  @Override public void initData(@Nullable Bundle savedInstanceState) {

  }

  @Override public void initToolBar() {

  }
}
