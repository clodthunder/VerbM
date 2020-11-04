package com.lskj.gx.lib_business_okhttp;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lskj.gx.lib_basic_base.BaseRes;
import com.lskj.gx.lib_business_entity.dto.UserDto;
import com.lskj.gx.lib_business_entity.vo.LoginVo;
import com.lskj.gx.lib_business_okhttp.services.UserService;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 创建时间:  2020/8/28
 * 编写人: tzw
 * 功能描述: 该页面 宝行okhttp 框架使用
 * get post upload file upload_batches
 */
@Route(path = "/bi_okhttp/okhttp_ui_activity") public class OkhttpUIActivity extends AppCompatActivity {
  @BindView(R2.id.tl_home_bar) Toolbar mToolbar;
  @BindView(R2.id.bc_ui_tv_title) AppCompatTextView tvTbTitle;
  @BindView(R2.id.tv_login_response) AppCompatTextView tvLoginResponse;
  @BindView(R2.id.bi_okhttp_iv_1) AppCompatImageView ivLabel1;
  @BindView(R2.id.bi_okhttp_iv_2) AppCompatImageView ivLabel2;
  @BindView(R2.id.bi_okhttp_iv_3) AppCompatImageView ivLabel3;
  @BindView(R2.id.bi_okhttp_iv_4) AppCompatImageView ivLabel4;
  @BindView(R2.id.bi_okhttp_iv_5) AppCompatImageView ivLabel5;
  @BindView(R2.id.bi_okhttp_iv_6) AppCompatImageView ivLabel6;
  @BindView(R2.id.bi_okhttp_container_1) LinearLayout llLabel1;
  @BindView(R2.id.bi_okhttp_container_2) LinearLayout llLabel2;
  @BindView(R2.id.bi_okhttp_container_3) LinearLayout llLabel3;
  @BindView(R2.id.bi_okhttp_container_4) LinearLayout llLabel4;
  @BindView(R2.id.bi_okhttp_container_5) LinearLayout llLabel5;
  @BindView(R2.id.bi_okhttp_container_6) LinearLayout llLabel6;
  private HashMap<String, Boolean> statusMap;
  private Unbinder unbinder;

  @OnClick({ R2.id.btn_login_okjson, R2.id.bc_ui_iv_back, R2.id.btn_login, R2.id.btn_login_clear })
  public void onClick(View view) {
    if (R.id.btn_login_okjson == view.getId()) {
      Toast.makeText(this, "okJson", Toast.LENGTH_SHORT).show();
    } else if (R.id.bc_ui_iv_back == view.getId()) {
      finish();
    } else if (R.id.btn_login == view.getId()) {
      login();
    } else if (R.id.btn_login_clear == view.getId()) {
      tvLoginResponse.setText("");
    }
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bi_okhttp_activity_ui);
    initView(savedInstanceState);
    initData(savedInstanceState);
  }

  private void initView(Bundle savedInstanceState) {
    unbinder = ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
  }

  private void login() {
    UserService service = GxNetManager.getRet().create(UserService.class);
    UserDto user = new UserDto("zzz", "123456");
    Call<BaseRes<LoginVo>> call = service.login(user);
    call.enqueue(new Callback<BaseRes<LoginVo>>() {
      @Override public void onResponse(Call<BaseRes<LoginVo>> call, Response<BaseRes<LoginVo>> response) {
        tvLoginResponse.setText(response.code() + "----" + response.body().getData().toString());
      }

      @Override public void onFailure(Call<BaseRes<LoginVo>> call, Throwable t) {
        tvLoginResponse.setText("onFailure ----" + t.getMessage());
      }
    });
  }

  private void initData(Bundle savedInstanceState) {
    tvTbTitle.setText("网络请求sI");
    initStatus();
  }

  //初始化展开状态
  private void initStatus() {
    statusMap = new HashMap<>(6);
    for (int i = 1; i <= 6; i++) {
      //默认全部关闭状态
      statusMap.put("label" + i, false);
    }
    ivLabel1.setOnClickListener(v -> showHideContainer(1));
    ivLabel2.setOnClickListener(v -> showHideContainer(2));
    ivLabel3.setOnClickListener(v -> showHideContainer(3));
    ivLabel4.setOnClickListener(v -> showHideContainer(4));
    ivLabel5.setOnClickListener(v -> showHideContainer(5));
    ivLabel6.setOnClickListener(v -> showHideContainer(6));
  }

  private void showHideContainer(int index) {
    String key = "label" + index;
    boolean shouldExpand;
    //当前是展开状态
    if (statusMap.get(key)) {
      statusMap.put(key, false);
      shouldExpand = false;
    } else {
      statusMap.put(key, true);
      shouldExpand = true;
    }
    //处理容器开闭状态
    switch (index) {
      case 1:
        llLabel1.setVisibility(shouldExpand ? View.VISIBLE : View.GONE);
        ivLabel1.setImageResource(shouldExpand ? R.drawable.bc_ui_comm_white_up : R.drawable.bc_ui_comm_white_down);
        break;
      case 2:
        llLabel2.setVisibility(shouldExpand ? View.VISIBLE : View.GONE);
        ivLabel2.setImageResource(shouldExpand ? R.drawable.bc_ui_comm_white_up : R.drawable.bc_ui_comm_white_down);
        break;
      case 3:
        llLabel3.setVisibility(shouldExpand ? View.VISIBLE : View.GONE);
        ivLabel3.setImageResource(shouldExpand ? R.drawable.bc_ui_comm_white_up : R.drawable.bc_ui_comm_white_down);
        break;
      case 4:
        llLabel4.setVisibility(shouldExpand ? View.VISIBLE : View.GONE);
        ivLabel4.setImageResource(shouldExpand ? R.drawable.bc_ui_comm_white_up : R.drawable.bc_ui_comm_white_down);
        break;
      case 5:
        llLabel5.setVisibility(shouldExpand ? View.VISIBLE : View.GONE);
        ivLabel5.setImageResource(shouldExpand ? R.drawable.bc_ui_comm_white_up : R.drawable.bc_ui_comm_white_down);
        break;
      case 6:
        llLabel6.setVisibility(shouldExpand ? View.VISIBLE : View.GONE);
        ivLabel6.setImageResource(shouldExpand ? R.drawable.bc_ui_comm_white_up : R.drawable.bc_ui_comm_white_down);
        break;
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (unbinder != null) {
      unbinder.unbind();
    }
  }
}
