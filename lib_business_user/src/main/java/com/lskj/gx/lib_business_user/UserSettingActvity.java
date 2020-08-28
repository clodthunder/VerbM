package com.lskj.gx.lib_business_user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lskj.gx.lib_user.R;
import com.lskj.gx.lib_user.R2;

/**
 * 创建时间:  2020/8/24
 * 编写人: tzw
 * 功能描述:
 */
@Route(path = "/user/setting_activity") public class UserSettingActvity extends AppCompatActivity {
  private Unbinder unbinder;
  //获取app splash activity 传入的 参数
  @BindView(R2.id.tv_params_test) TextView tvParams;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //添加到arouter中
    ARouter.getInstance().inject(this);
    setContentView(R.layout.bi_user_activity_setting);
    unbinder = ButterKnife.bind(this);
    tvParams.setText(
        String.format(getResources().getString(R.string.bi_user_string_params), getIntent().getStringExtra("splash")));
  }

  @OnClick({ R2.id.btn_set_result }) public void onClick(View view) {
    if (R.id.btn_set_result == view.getId()) {
      Intent result = new Intent();
      result.putExtra("result", "result from user model");
      setResult(Activity.RESULT_OK, result);
      finish();
    }
  }

  @Override protected void onDestroy() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroy();
  }
}
