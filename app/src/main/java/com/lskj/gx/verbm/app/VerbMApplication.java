package com.lskj.gx.verbm.app;

import androidx.multidex.MultiDexApplication;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lskj.gx.lib_basic_base.manager.AppManager;
import com.lskj.gx.verbm.BuildConfig;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * 创建时间:  2020/8/24
 * 编写人: tzw
 * 功能描述:
 */
public class VerbMApplication extends MultiDexApplication {

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      ARouter.openLog();
      ARouter.openDebug();
      //初始化db监控
      SQLiteStudioService.instance().start(this);
    }
    //ARouter初始化
    ARouter.init(this);
    //初始化AppManager
    AppManager.getAppManager().init(this);

  }

  @Override public void onTerminate() {
    super.onTerminate();
    if (BuildConfig.DEBUG) {
      //停止db 监控
      SQLiteStudioService.instance().stop();
    }
  }
}
