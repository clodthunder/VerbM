package com.lskj.gx.lib_basic_img;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.LibraryGlideModule;
import com.lskj.gx.lib_basic_img.base64.Base64ModelLoaderFactory;
import java.nio.ByteBuffer;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述: 注册自定义glide 解析器
 */
@GlideModule(glideName = "GlideApp") public class GxGlideModule extends LibraryGlideModule {
  public GxGlideModule() {
    super();
  }

  @Override public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
    super.registerComponents(context, glide, registry);
    //注册Base64ModelLoaderFactory
    registry.prepend(String.class, ByteBuffer.class, new Base64ModelLoaderFactory());
    //注册gif 解析
    //registry.append(Api.GifResult.class, InputStream.class, new GiphyModelLoader.Factory());
  }
}
