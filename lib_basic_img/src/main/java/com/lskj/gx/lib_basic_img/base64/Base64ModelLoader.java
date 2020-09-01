package com.lskj.gx.lib_basic_img.base64;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.nio.ByteBuffer;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述: 该类glide 加载base64的图片  其本质是string而string中包含有URL、Uri、File
 */
public final class Base64ModelLoader implements ModelLoader<String, ByteBuffer> {

  @Nullable @Override
  public LoadData<ByteBuffer> buildLoadData(@NonNull String model, int width, int height, @NonNull Options options) {
    return new LoadData<>(new ObjectKey(model), new Base64DataFetcher(model));
  }

  //ModelLoader 高效地检查每个模型以避免加载不支持的类型
  @Override public boolean handles(@NonNull String model) {
    //这里可以增加html 图片后缀检测 非正确图片检测
    return model.startsWith("data:");
  }
}
