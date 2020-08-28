package com.lskj.gx.lib_business_log;

import com.lskj.gx.lib_basic_base.BaseUser;
import com.lskj.gx.lib_basic_base.BaseUserManager;
import com.lskj.gx.lib_basic_utils.GxDateUtils;
import java.util.Date;
import timber.log.Timber;

/**
 * 创建时间:  2020/8/26
 * 编写人: tzw
 * 功能描述:
 * 插入日志到本地数据库中
 * 使用保活service 定时将日志 传到平台上去
 * 接收后台推送 立即上传日志 传到平台上去
 */
public class GxLogManager {
  private static String TAG = GxLogManager.class.getSimpleName();

  /**
   * 记录日志信息 info级别
   */
  public static void info(String reason) {
    info(TAG, reason, false);
  }

  /**
   * 记录日志信息 error级别
   */
  public static void error(String reason) {
    error(TAG, reason, false);
  }

  public static void errorInsert(String reason) {
    error(TAG, reason, true);
  }

  /**
   * 记录日志信息 error级别
   */
  public static void error(String tag, String reason) {
    //默认传入
    error(tag, reason, true);
  }

  /**
   * 记录日志信息 error 级别
   */
  public static void error(String tag, String reason, boolean needInsertDb) {
    if ("".equals(reason)) {
      reason = "空字符串->\"\"";
    } else if ("null".equals(reason)) {
      reason = "空字符串->\"null\"";
    } else if (null == reason) {
      reason = "null";
    }
    Timber.e(tag, reason);
    //默认需要插入到数据库中去
    if (needInsertDb) {
      insertLogDb(new Date(), reason);
    }
  }

  /**
   * 记录info级别的日志
   *
   * @param reason 待记录的日志的具体内容
   */
  public static void info(String tag, String reason) {
    info(tag, reason, false);
  }

  /**
   * 记录info级别的日志
   *
   * @param reason 待记录的日志的具体内容
   * @param needInsertDb 是否需要插入数据库 上传平台
   */
  public static void info(String tag, String reason, boolean needInsertDb) {
    if ("".equals(reason)) {
      reason = "空字符串->\"\"";
    } else if ("null".equals(reason)) {
      reason = "空字符串->\"null\"";
    } else if (null == reason) {
      reason = "null";
    }
    if (!needInsertDb) {
      Timber.i(tag, reason);
      return;
    }
    insertLogDb(new Date(), reason);
  }

  /**
   * @param date 当前日期时间
   * @param reason 日志内容
   * @return 是否成功插入数据库中
   */
  public static synchronized boolean insertLogDb(Date date, String reason) {
    String dateStr = GxDateUtils.format(date);
    BaseUser user = BaseUserManager.getInstance().getUser();
    System.out.println(TAG
        + ":: insertLogDB() => "
        + "userId:"
        + user.getUserId()
        + ",userName:"
        + user.getUserName()
        + ",date:"
        + dateStr
        + "\n reason,"
        + reason);
    return true;
  }

  /**
   * 通知上传本地log日志到平台上去
   * 防止多线程同时访问
   */
  private synchronized void uploadLocalLog() {

  }
}
