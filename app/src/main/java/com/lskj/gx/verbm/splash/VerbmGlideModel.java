package com.lskj.gx.verbm.splash;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述: 这个不能少 如果想用 lib_basic_img 模块的自定义module 生效的话
 */
@GlideModule public class VerbmGlideModel extends AppGlideModule {
  @Override public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
    super.registerComponents(context, glide, registry);
  }
}
