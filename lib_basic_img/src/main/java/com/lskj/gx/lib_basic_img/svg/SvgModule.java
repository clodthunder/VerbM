package com.lskj.gx.lib_basic_img.svg;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述:
 */

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.LibraryGlideModule;
import com.caverock.androidsvg.SVG;
import java.io.InputStream;

/** Module for the SVG sample app. */
@GlideModule public class SvgModule extends LibraryGlideModule {
  @Override public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
    registry.register(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder())
        .append(InputStream.class, SVG.class, new SvgDecoder());
  }
}