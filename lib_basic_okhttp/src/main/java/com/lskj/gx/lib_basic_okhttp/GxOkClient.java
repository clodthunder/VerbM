package com.lskj.gx.lib_basic_okhttp;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.lskj.gx.lib_basic_base.AppContext;
import java.util.concurrent.TimeUnit;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * 创建时间:  2020/8/28
 * 编写人: tzw
 * 功能描述: 公共的okhttpClient组件
 */
public class GxOkClient {
  //请求失败是否需要自动重新请求 默认不需要
  private OkHttpClient.Builder okBuilder;

  public GxOkClient(Builder builder) {
    okBuilder = new OkHttpClient.Builder();
    okBuilder.cookieJar(builder.cookieJar);
    okBuilder.connectTimeout(builder.connTimeout, TimeUnit.MILLISECONDS);
    okBuilder.readTimeout(builder.readTimeOut, TimeUnit.MILLISECONDS);
    okBuilder.writeTimeout(builder.writeTimeOut, TimeUnit.MILLISECONDS);
    okBuilder.retryOnConnectionFailure(builder.needRetry);
    if (builder.interceptor != null) {
      okBuilder.addInterceptor(builder.interceptor);
    }
  }

  /**
   * 获取通用的 OkHttpClient
   */
  public OkHttpClient getDefaultOkClient() {
    if (okBuilder == null) {
      throw new RuntimeException("GxOkClient okBuilder is null");
    }
    return okBuilder.build();
  }

  /**
   * 建造者模式赋值 通用参数
   */
  public static class Builder {
    //cookie策略
    private CookieJar cookieJar;
    private long connTimeout;
    private long readTimeOut;
    private long writeTimeOut;
    //是否需要重试
    private boolean needRetry;
    //拦截器
    private Interceptor interceptor;

    public Interceptor getInterceptors() {
      return interceptor;
    }

    public GxOkClient.Builder setInterceptors(Interceptor interceptor) {
      this.interceptor = interceptor;
      return this;
    }

    public boolean isNeedRetry() {
      return needRetry;
    }

    public GxOkClient.Builder setNeedRetry(boolean needRetry) {
      this.needRetry = needRetry;
      return this;
    }

    public CookieJar getCookieJar() {
      return cookieJar;
    }

    /**
     * 判断是否使用cookie
     * 如果不适用cookie则 false
     * true 是使用cookie
     */
    public GxOkClient.Builder useCookieJar(boolean useCookie, CookieJar cJar) {
      if (!useCookie) {
        cJar = CookieJar.NO_COOKIES;
      } else {
        //如果cJar 传入的是null 则默认使用
        if (cJar == null) {
          cJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(AppContext.getContext()));
        }
      }
      this.cookieJar = cJar;
      return this;
    }

    public long getWriteTimeOut() {
      return writeTimeOut;
    }

    public GxOkClient.Builder setWriteTimeOut(long writeTimeOut) {
      if (writeTimeOut < GxOkConfig.DEFAULT_WRITE_OUT) {
        this.writeTimeOut = GxOkConfig.DEFAULT_WRITE_OUT;
      }
      this.writeTimeOut = writeTimeOut;
      return this;
    }

    public long getReadTimeOut() {
      return readTimeOut;
    }

    public GxOkClient.Builder setReadTimeOut(long readTimeOut) {
      if (readTimeOut < GxOkConfig.DEFAULT_Read_TIME_OUT) {
        readTimeOut = GxOkConfig.DEFAULT_Read_TIME_OUT;
      }
      this.readTimeOut = readTimeOut;
      return this;
    }

    public long getConnTimeout() {
      return connTimeout;
    }

    public GxOkClient.Builder setConnTimeout(long connTimeout) {
      if (connTimeout < GxOkConfig.DEFAULT_CONNE_TIME_OUT) {
        connTimeout = GxOkConfig.DEFAULT_CONNE_TIME_OUT;
      }
      this.connTimeout = connTimeout;
      return this;
    }

    public GxOkClient build() {
      return new GxOkClient(this);
    }
  }
}
