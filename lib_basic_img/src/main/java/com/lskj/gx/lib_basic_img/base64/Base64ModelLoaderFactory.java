package com.lskj.gx.lib_basic_img.base64;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.nio.ByteBuffer;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述: 注册自定义Base64ModelLoader 到glide
 */
public class Base64ModelLoaderFactory implements ModelLoaderFactory<String, ByteBuffer> {

  @NonNull @Override public ModelLoader<String, ByteBuffer> build(@NonNull MultiModelLoaderFactory multiFactory) {
    return new Base64ModelLoader();
  }

  @Override public void teardown() {

  }
}
