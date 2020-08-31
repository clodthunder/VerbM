package com.lskj.gx.lib_business_okhttp;

import com.lskj.gx.lib_basic_okhttp.GxOkClient;
import com.lskj.gx.lib_basic_okhttp.GxRetClient;
import com.lskj.gx.lib_basic_okhttp.interceptor.ReqHeaderIntercepter;
import com.lskj.gx.lib_basic_okhttp.interceptor.TokenIntercepter;
import com.lskj.gx.lib_business_log.GxLogManager;
import com.lskj.gx.lib_business_okhttp.config.ApiConstant;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述:
 * 该类用于网络请求 所有的请求都应该走这层
 * basic okhttp 是基础请求封装
 * 业务层走这个以后如果想替换
 * 网络框架将十分方便
 */
public class GxNetManager {
  private final static String TAG = GxNetManager.class.getSimpleName();
  //网络管理
  private static GxNetManager netManager;
  //设置okhttp网络请求相关配置
  private static Retrofit retrofit;
  private static OkHttpClient okClint;
  private static Retrofit.Builder retBuilder;

  public static GxNetManager getInstance() {
    if (netManager == null) {
      synchronized (GxNetManager.class) {
        if (netManager == null) {
          netManager = new GxNetManager();
        }
      }
    }
    return netManager;
  }

  public static GxNetManager getOKClient() {
    return netManager;
  }

  /**
   * 获取retrofit client并设置一个拦截器
   * 更复杂的请求
   */
  public static Retrofit getRet(Interceptor interceptor) {
    return getRet(false, true, null, interceptor);
  }

  public static OkHttpClient getOk() {
    return getOk(false, true, null);
  }

  public static OkHttpClient getOk(boolean needRetry, boolean useCookie, CookieJar cookieJar) {
    return getOk(needRetry, useCookie, cookieJar, null);
  }

  public static OkHttpClient getOk(boolean needRetry, boolean useCookie, CookieJar cookieJar, Interceptor interceptor) {
    GxOkClient client = new GxOkClient.Builder().setNeedRetry(needRetry)
        .useCookieJar(useCookie, cookieJar)
        .setInterceptors(new HttpLoggingInterceptor(s -> {
          //设置日志
          GxLogManager.info(TAG, s, true);
        }).setLevel(HttpLoggingInterceptor.Level.BODY))//日志打印管理
        .setInterceptors(new ReqHeaderIntercepter())//header 自定义header 添加
        .setInterceptors(new TokenIntercepter())//token 自动请求
        .setInterceptors(interceptor)
        .build();
    return client.getDefaultOkClient();
  }

  public static Retrofit getRet() {
    return getRet(false, true, null);
  }

  /**
   * 不想过度封装 配置些统一用的参数
   *
   * @param needRetry 失败是否自动重试
   * @param useCookie 判断是否使用cookie默认true
   * @param cookieJar 自定义cookie策略,如果不自定义传null使用默认cookie 管理
   * @throws ClassNotFoundException
   */
  public static Retrofit getRet(boolean needRetry, boolean useCookie, CookieJar cookieJar) {
    return getRet(needRetry, useCookie, cookieJar, null);
  }

  public static Retrofit getRet(boolean needRetry, boolean useCookie, CookieJar cookieJar, Interceptor interceptor) {
    GxRetClient retClient = new GxRetClient.Builder().setBaseUrl(ApiConstant.baseUrl)
        .setConverter(GsonConverterFactory.create())
        .setOkClient(getOk(needRetry, useCookie, cookieJar, interceptor))
        .build();
    Retrofit retrofit = retClient.getRetrofit();
    return retrofit;
  }
}
