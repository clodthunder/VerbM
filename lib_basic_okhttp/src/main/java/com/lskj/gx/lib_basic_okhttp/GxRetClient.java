package com.lskj.gx.lib_basic_okhttp;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: retrofit client
 */
public class GxRetClient {
  private Retrofit.Builder retBuilder;

  public GxRetClient(GxRetClient.Builder builder) {
    retBuilder = new Retrofit.Builder();
    retBuilder.baseUrl(builder.baseUrl);
    retBuilder.client(builder.okClient);
    if (builder.converter != null) {
      retBuilder.addConverterFactory(builder.converter);
    }
  }

  /**
   * 获取retrofit client
   */
  public Retrofit getRetrofit() {

    return retBuilder.build();
  }

  public static class Builder {
    private String baseUrl;
    private OkHttpClient okClient;
    private Converter.Factory converter;

    public String getBaseUrl() {
      return baseUrl;
    }

    public GxRetClient.Builder setBaseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    public OkHttpClient getOkClient() {
      return okClient;
    }

    public GxRetClient.Builder setOkClient(OkHttpClient okClient) {
      this.okClient = okClient;
      return this;
    }

    public Converter.Factory getConverter() {
      return converter;
    }

    public GxRetClient.Builder setConverter(Converter.Factory converter) {
      this.converter = converter;
      return this;
    }

    public GxRetClient build() {
      return new GxRetClient(this);
    }
  }
}
