package com.lskj.gx.lib_test_ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lskj.gx.lib_widget.textview.GxRoundWithDelete;

/**
 * 创建时间:  2020/9/3
 * 编写人: tzw
 * 功能描述:
 */

@Route(path = "/test_ui/image_delete") public class ImageDeleteActivity extends AppCompatActivity {
  @BindView(R2.id.grwd_test) GxRoundWithDelete gxRoundWithDelete;
  private Unbinder unBinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_ui_img_delete);
    unBinder = ButterKnife.bind(this);

  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (unBinder != null) {
      unBinder.unbind();
    }
  }
}
