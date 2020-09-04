package com.lskj.gx.lib_hk_video;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 创建时间:  2020/9/4
 * 编写人: tzw
 * 功能描述:
 */
@Route(path = "/hk_video/test_ui_activity") public class TestUIActivity extends AppCompatActivity {
  private Unbinder unbinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hk_activity_test_ui);
    unbinder = ButterKnife.bind(this);
  }

  @OnClick({ R2.id.btn_preview_on_time, R2.id.btn_play_back, R2.id.btn_audio_talk }) public void onClick(View view) {
    Intent mIntent = null;
    //跳转demo实时预览界面
    if (view.getId() == R.id.btn_preview_on_time) {
      mIntent = new Intent(this, PreviewActivity.class);
      startActivity(mIntent);
    } else if (view.getId() == R.id.btn_play_back) {
      mIntent = new Intent(this, PlaybackActivity.class);
      startActivity(mIntent);
    } else if (view.getId() == R.id.btn_audio_talk) {
      mIntent = new Intent(this, VoiceTalkActivity.class);
      startActivity(mIntent);
    }
  }

  @Override protected void onDestroy() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroy();
  }
}
