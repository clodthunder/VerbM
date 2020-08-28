package com.lskj.gx.lib_basic_base.manager;

import android.app.Activity;
import android.app.Application;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import timber.log.Timber;

/**
 * 创建时间:  2020/8/26
 * 编写人: tzw
 * 功能描述: 用于管理所有的activity
 */
public class AppManager {
  protected final String TAG = this.getClass().getSimpleName();
  /**
   * true 为不需要加入到 Activity 容器进行统一管理,默认为 false
   */
  private static volatile AppManager sAppManager;
  private Application mApplication;
  /**
   * 管理所有存活的 Activity, 容器中的顺序仅仅是 Activity 的创建顺序, 并不能保证和 Activity 任务栈顺序一致
   */
  private List<Activity> mActivityList;
  /**
   * 当前在前台的 Activity
   */
  private Activity mCurrentActivity;

  private AppManager() {
  }

  public static AppManager getAppManager() {
    if (sAppManager == null) {
      synchronized (AppManager.class) {
        if (sAppManager == null) {
          sAppManager = new AppManager();
        }
      }
    }
    return sAppManager;
  }

  public AppManager init(Application application) {
    this.mApplication = application;
    return sAppManager;
  }

  /**
   * 释放资源
   */
  public void release() {
    mActivityList.clear();
    mActivityList = null;
    mCurrentActivity = null;
    mApplication = null;
  }

  /**
   * 返回一个存储所有未销毁的 {@link Activity} 的集合
   */
  public List<Activity> getActivityList() {
    if (mActivityList == null) {
      mActivityList = new LinkedList<>();
    }
    return mActivityList;
  }

  /**
   * 添加 {@link Activity} 到集合
   */
  public void addActivity(Activity activity) {
    synchronized (AppManager.class) {
      List<Activity> activities = getActivityList();
      if (!activities.contains(activity)) {
        activities.add(activity);
      }
    }
  }

  /**
   * 删除集合里的指定的 {@link Activity} 实例
   *
   * @param {@link Activity}
   */
  public void removeActivity(Activity activity) {
    if (mActivityList == null) {
      Timber.e(TAG, "mActivityList == null when removeActivity(Activity)");
      return;
    }
    synchronized (AppManager.class) {
      if (mActivityList.contains(activity)) {
        mActivityList.remove(activity);
      }
    }
  }

  /**
   * 删除集合里的指定位置的 {@link Activity}
   */
  public Activity removeActivity(int location) {
    if (mActivityList == null) {
      Timber.e(TAG, "mActivityList == null when removeActivity(int)");
      return null;
    }
    synchronized (AppManager.class) {
      if (location > 0 && location < mActivityList.size()) {
        return mActivityList.remove(location);
      }
    }
    return null;
  }

  /**
   * 关闭指定的 {@link Activity} class 的所有的实例
   */
  public void killActivity(Class<?> activityClass) {
    if (mActivityList == null) {
      Timber.e(TAG, "mActivityList == null when killActivity(Class)");
      return;
    }
    synchronized (AppManager.class) {
      Iterator<Activity> iterator = getActivityList().iterator();
      while (iterator.hasNext()) {
        Activity next = iterator.next();

        if (next.getClass().equals(activityClass)) {
          iterator.remove();
          next.finish();
        }
      }
    }
  }

  /**
   * 指定的 {@link Activity} 实例是否存活
   *
   * @param {@link Activity}
   */
  public boolean activityInstanceIsLive(Activity activity) {
    if (mActivityList == null) {
      Timber.e(TAG, "mActivityList == null when activityInstanceIsLive(Activity)");
      return false;
    }
    return mActivityList.contains(activity);
  }

  /**
   * 指定的 {@link Activity} class 是否存活(同一个 {@link Activity} class 可能有多个实例)
   */
  public boolean activityClassIsLive(Class<?> activityClass) {
    if (mActivityList == null) {
      Timber.e(TAG, "mActivityList == null when activityClassIsLive(Class)");
      return false;
    }
    for (Activity activity : mActivityList) {
      if (activity.getClass().equals(activityClass)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 获取指定 {@link Activity} class 的实例,没有则返回 null(同一个 {@link Activity} class 有多个实例,则返回最早创建的实例)
   */
  public Activity findActivity(Class<?> activityClass) {
    if (mActivityList == null) {
      Timber.e(TAG, "mActivityList == null when findActivity(Class)");
      return null;
    }
    for (Activity activity : mActivityList) {
      if (activity.getClass().equals(activityClass)) {
        return activity;
      }
    }
    return null;
  }

  /**
   * 关闭所有 {@link Activity}
   */
  public void killAll() {
    synchronized (AppManager.class) {
      Iterator<Activity> iterator = getActivityList().iterator();
      while (iterator.hasNext()) {
        Activity next = iterator.next();
        iterator.remove();
        next.finish();
      }
    }
  }

  /**
   * 关闭所有 {@link Activity},排除指定的 {@link Activity}
   *
   * @param excludeActivityClasses activity class
   */
  public void killAll(Class<?>... excludeActivityClasses) {
    List<Class<?>> excludeList = Arrays.asList(excludeActivityClasses);
    synchronized (AppManager.class) {
      Iterator<Activity> iterator = getActivityList().iterator();
      while (iterator.hasNext()) {
        Activity next = iterator.next();

        if (excludeList.contains(next.getClass())) continue;

        iterator.remove();
        next.finish();
      }
    }
  }

  /**
   * 关闭所有 {@link Activity},排除指定的 {@link Activity}
   *
   * @param excludeActivityName {@link Activity} 的完整全路径
   */
  public void killAll(String... excludeActivityName) {
    List<String> excludeList = Arrays.asList(excludeActivityName);
    synchronized (AppManager.class) {
      Iterator<Activity> iterator = getActivityList().iterator();
      while (iterator.hasNext()) {
        Activity next = iterator.next();

        if (excludeList.contains(next.getClass().getName())) continue;

        iterator.remove();
        next.finish();
      }
    }
  }

  public void appExit() {
    try {
      killAll();
      android.os.Process.killProcess(android.os.Process.myPid());
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
