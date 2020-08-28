package com.lskj.gx.lib_business_user.manager;

import com.lskj.gx.lib_basic_base.BaseUserManager;
import com.lskj.gx.lib_business_user.entity.GxUser;

/**
 * 创建时间:  2020/8/26
 * 编写人: tzw
 * 功能描述: 需要扩展用户字段
 * 请在这里拓展 配合lib_db 支持多用户
 * 不用使用sharePreference
 */
public class GxUserManager extends BaseUserManager<GxUser> {
  private volatile static GxUserManager instance;

  //获取用户管理类 单例
  public synchronized static GxUserManager getInstance() {
    if (instance == null) {
      synchronized (GxUserManager.class) {
        if (instance == null) {
          instance = new GxUserManager();
        }
      }
    }
    return instance;
  }



}
