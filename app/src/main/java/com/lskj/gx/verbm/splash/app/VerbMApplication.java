package com.lskj.gx.verbm.splash.app;

import androidx.multidex.MultiDexApplication;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lskj.gx.lib_basic_base.BuildConfig;
import com.lskj.gx.lib_basic_base.manager.AppManager;
import com.lskj.gx.lib_basic_utils.AppContext;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * 创建时间:  2020/8/24
 * 编写人: tzw
 * 功能描述:
 */
public class VerbMApplication extends MultiDexApplication {
  private static VerbMApplication instance;

  public static VerbMApplication getInstance() {
    if (instance == null) {
      synchronized (VerbMApplication.class) {
        if (instance == null) {
          instance = new VerbMApplication();
        }
      }
    }
    return instance;
  }

  @Override public void onCreate() {
    super.onCreate();
    //设置context
    AppContext.init(this);

    if (BuildConfig.DEBUG) {
      ARouter.openLog();
      ARouter.openDebug();
    }
    //ARouter初始化
    ARouter.init(this);

    //数据库迁移
    //存在多个module
    //RoomDbManger dbManger = Room.databaseBuilder(getApplicationContext(), RoomDbManger.class, BaseConstant.DB_NAME)
    //    .allowMainThreadQueries()
    //    .enableMultiInstanceInvalidation()
    //    .build();

    if (BuildConfig.DEBUG) {
      //初始化db监控
      SQLiteStudioService.instance().start(this);
    }
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
