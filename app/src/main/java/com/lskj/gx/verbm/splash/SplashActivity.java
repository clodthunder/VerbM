package com.lskj.gx.verbm.splash;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lskj.gx.lib_basic_base.BaseActivity;
import com.lskj.gx.verbm.R;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/**
 * 创建时间:  2020/8/24
 * 编写人: tzw
 * 功能描述:
 */
@Route(path = "/app/splash/splash_activity") public class SplashActivity extends BaseActivity {
  private Disposable disposable;

  @Override public int initView(@Nullable Bundle savedInstanceState) {
    return R.layout.app_activity_splash;
  }

  @Override public void initData(@Nullable Bundle savedInstanceState) {
    disposable = Observable.create((ObservableOnSubscribe<Integer>) emitter -> emitter.onNext(0))
        .delay(1500, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Integer>() {
          @Override public void accept(Integer integer) throws Exception {
            //跳转 测试 网络框架
            //ARouter.getInstance().build("/bi_okhttp/okhttp_ui_activity").navigation();
            //跳转 测试 图片加载框架 glide
            //ARouter.getInstance().build("/test_ui/base64_test").navigation();
            //测试图片
            //ARouter.getInstance().build("/test_ui/image_delete").navigation();
            //测试音频
            //ARouter.getInstance().build("/test_ui/audio_test").navigation();
            //paging test
            ARouter.getInstance().build("/test_ui/paging_activity").navigation();
            //db test
            //ARouter.getInstance().build("/test_ui/db_test_activity").navigation();
            //跳转home 页面
            //Intent mIntent = new Intent(SplashActivity.this, MainActivity.class);
            //startActivity(mIntent);
            SplashActivity.this.finish();
          }
        });
  }

  @Override public void initToolBar() {

  }

  @Override protected void onDestroy() {
    if (disposable != null && !disposable.isDisposed()) {
      disposable.dispose();
    }
    super.onDestroy();
  }
}
