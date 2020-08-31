package com.lskj.gx.lib_basic_okhttp.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: 请求头拦截器
 */
public class ReqHeaderIntercepter implements Interceptor {

  @NotNull @Override public Response intercept(@NotNull Chain chain) throws IOException {
    Request request = chain.request().newBuilder().addHeader("token", "").build();
    return chain.proceed(request);
  }
}
