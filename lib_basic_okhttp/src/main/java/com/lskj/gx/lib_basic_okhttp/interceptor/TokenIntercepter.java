package com.lskj.gx.lib_basic_okhttp.interceptor;

import android.util.Log;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: token 自动刷新
 */
public class TokenIntercepter implements Interceptor {
  private static final String TAG = "TokenInterceptor";

  @Override public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = chain.proceed(request);
    Log.d(TAG, "response.code=" + response.code());

    //根据和服务端的约定判断token过期
    if (isTokenExpired(response)) {
      Log.d(TAG, "自动刷新Token,然后重新请求数据");
      //同步请求方式，获取最新的Token
      String newToken = getNewToken();
      //使用新的Token，创建新的请求
      Request newRequest = chain.request().newBuilder().header("Authorization", "Basic " + newToken).build();
      //重新请求
      return chain.proceed(newRequest);
    }
    return response;
  }

  /**
   * 根据Response，判断Token是否失效
   */
  private boolean isTokenExpired(Response response) {
    if (response.code() == 301) {
      return true;
    }
    return false;
  }

  /**
   * 同步请求方式，获取最新的Token
   */
  private String getNewToken() throws IOException {
    // 通过获取token的接口，同步请求接口
    String newToken = "";
    return newToken;
  }
}
