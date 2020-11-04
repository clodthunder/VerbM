package com.lskj.gx.lib_test_ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 创建时间:  2020/9/4
 * 编写人: tzw
 * 功能描述: 录音测试
 */
@Route(path = "/test_ui/audio_test") public class AudioTestActivity extends AppCompatActivity {
  private Unbinder unbinder;
  @BindView(R2.id.crm_audio) Chronometer chronometer;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_ui_audio_test);
    unbinder = ButterKnife.bind(this);
  }

  @OnClick({ R2.id.test_ui_start, R2.id.test_ui_end }) public void OnClick(View v) {
    if (v.getId() == R.id.test_ui_start) {
      chronometer.setBase(SystemClock.elapsedRealtime());
      int hour = (int) ((SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000 / 60);
      chronometer.setFormat("0" + String.valueOf(hour) + ":%s");
      chronometer.start();
    } else if (v.getId() == R.id.test_ui_end) {
      chronometer.stop();
    }
  }

  @Override protected void onDestroy() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroy();
  }
}
