package com.lskj.gx.lib_basic_base;

/**
 * 创建时间:  2020/8/26
 * 编写人: tzw
 * 功能描述:
 */
public class BaseUserManager<T extends BaseUser> {
  private volatile static BaseUserManager instance;

  public static synchronized BaseUserManager getInstance() {
    if (instance == null) {
      synchronized (BaseUserManager.class) {
        instance = new BaseUserManager();
      }
    }
    return instance;
  }

  protected T user;

  public T getUser() {
    if (user == null) {
      user = (T) new BaseUser("匿名用户id", "匿名用户name", null, null, null);
    }
    return user;
  }

  public void setUser(T user) {
    this.user = user;
  }
}
