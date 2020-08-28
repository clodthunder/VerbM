package com.lskj.gx.verbm.splash;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
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
@Route(path = "/manager/splash/splash_activity") public class SplashActivity extends BaseActivity {
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
            //ARouter.getInstance().build("/bi_navi/main_activity").navigation();
            Intent mIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mIntent);
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