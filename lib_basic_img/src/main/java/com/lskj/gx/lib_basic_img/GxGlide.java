package com.lskj.gx.lib_basic_img;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.lskj.gx.lib_basic_base.AppContext;
import com.lskj.gx.lib_basic_img.svg.SvgSoftwareLayerSetter;
import com.lskj.gx.lib_basic_img.trans.RoundForCorners;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述: 封装Glide 加载图片
 */
public class GxGlide {
  /**
   * 加载常规图片
   */
  public static void load(Context context, Object model, ImageView iv) {
    load(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, iv);
  }

  /**
   * 加载 四方形图片并任意指定 四个角的角度
   *
   * @param ltAngle 左上角
   * @param lbAngle 左下教
   * @param rtAngle 右上角
   * @param rbAngle 右下角
   */
  public static void loadRoundFourFb(Context context, Object model, ImageView iv, int ltAngle, int lbAngle, int rtAngle,
      int rbAngle) {
    loadRoundFourFb(context, model, iv, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error,
        R.drawable.bc_img_fallback, ltAngle, lbAngle, rtAngle, rbAngle);
  }

  public static void loadRoundFour(Context context, Object model, ImageView iv, int ltAngle, int lbAngle, int rtAngle,
      int rbAngle) {
    loadRoundFour(context, model, iv, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, ltAngle, lbAngle,
        rtAngle, rbAngle);
  }

  /**
   * 加载 四方形图片并任意指定 四个角的角度
   *
   * @param ltAngle 左上角
   * @param lbAngle 左下教
   * @param rtAngle 右上角
   * @param rbAngle 右下角
   */
  public static void loadRoundFourFb(Context context, Object model, ImageView iv, @DrawableRes int placeHolder,
      @DrawableRes int error, @DrawableRes int fallback, int ltAngle, int lbAngle, int rtAngle, int rbAngle) {
    Glide.with(context)
        .asDrawable()
        .load(model)
        .placeholder(placeHolder)
        .error(error)
        .fallback(fallback)
        .apply(RequestOptions.bitmapTransform(new RoundForCorners(ltAngle, rtAngle, lbAngle, rbAngle)))
        .into(iv);
  }

  public static void loadRoundFour(Context context, Object model, ImageView iv, @DrawableRes int placeHolder,
      @DrawableRes int error, int ltAngle, int lbAngle, int rtAngle, int rbAngle) {
    Glide.with(context)
        .asDrawable()
        .load(model)
        .placeholder(placeHolder)
        .error(error)
        .apply(RequestOptions.bitmapTransform(new RoundForCorners(ltAngle, rtAngle, lbAngle, rbAngle)))
        .into(iv);
  }

  /**
   * 加载方形圆角图片
   */
  public static void loadRounded(Context context, Object model, ImageView iv) {
    loadRounded(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, 10, iv);
  }

  public static void loadRounded(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      int angle, ImageView iv) {
    Glide.with(context)
        .asDrawable()
        .load(model)
        .placeholder(placeholder)
        .error(error)
        .apply(RequestOptions.bitmapTransform(new RoundedCorners(angle)))
        .into(iv);
  }

  public static void loadRoundedFb(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      @DrawableRes int fallback, int angle, ImageView iv) {
    Glide.with(context)
        .asDrawable()
        .load(model)
        .placeholder(placeholder)
        .error(error)
        .apply(RequestOptions.bitmapTransform(new RoundedCorners(angle)))
        .into(iv);
  }

  /**
   * 常规加载圆形图片
   */
  public static void loadCircle(Context context, Object model, ImageView iv) {
    loadCircle(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, iv);
  }

  /**
   * 常规加载圆形图片
   */
  public static void loadCircleFb(Context context, Object model, ImageView iv) {
    loadCircleFb(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error,
        R.drawable.bc_img_fallback, iv);
  }

  public static void loadCircle(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      ImageView iv) {
    Glide.with(context)
        .asDrawable()
        .load(model)
        .placeholder(placeholder)
        .error(error)
        .apply(RequestOptions.bitmapTransform(new CircleCrop()))
        .into(iv);
  }

  public static void loadCircleFb(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      @DrawableRes int fallback, ImageView iv) {
    Glide.with(context)
        .asDrawable()
        .load(model)
        .placeholder(placeholder)
        .error(error)
        .fallback(fallback)
        .apply(RequestOptions.bitmapTransform(new CircleCrop()))
        .into(iv);
  }

  public static void loadFb(Context context, Object model, ImageView iv) {
    load(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, R.drawable.bc_img_fallback,
        iv);
  }

  public static void loadDrawable(Context context, Object model, ImageView iv) {
    loadDrawable(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, iv);
  }

  public static void loadDrawableFb(Context context, Object model, ImageView iv) {
    loadDrawable(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error,
        R.drawable.bc_img_fallback, iv);
  }

  public static void loadBitMap(Context context, Object model, ImageView iv) {
    loadBitMap(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, iv);
  }

  public static void loadCenterInside(Context context, Object model, ImageView iv) {
    loadCenterInside(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, iv);
  }

  public static void loadCenterInside(Context context, Object model, @DrawableRes int fallback, ImageView iv) {
    loadCenterInsideFb(context, model, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, fallback, iv);
  }

  /**
   * 加载常规图片带有默认显示图片
   */
  public static void load(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      ImageView iv) {
    Glide.with(context).load(model).placeholder(placeholder).error(error).into(iv);
  }

  public static void load(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      @DrawableRes int fallback, ImageView iv) {
    Glide.with(context).load(model).placeholder(placeholder).error(error).fallback(fallback).into(iv);
  }

  public static void loadDrawable(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      ImageView iv) {
    Glide.with(context).asDrawable().load(model).placeholder(placeholder).error(error).into(iv);
  }

  public static void loadDrawable(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      @DrawableRes int fallback, ImageView iv) {
    Glide.with(context).asDrawable().load(model).placeholder(placeholder).error(error).fallback(fallback).into(iv);
  }

  public static void loadBitMap(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      ImageView iv) {
    Glide.with(context).asBitmap().load(model).placeholder(placeholder).error(error).into(iv);
  }

  public static void loadCenterInside(Context context, Object model, @DrawableRes int placeholder,
      @DrawableRes int error, ImageView iv) {
    Glide.with(context).load(model).centerInside().placeholder(placeholder).error(error).into(iv);
  }

  public static void loadCenterInsideFb(Context context, Object model, @DrawableRes int placeholder,
      @DrawableRes int error, @DrawableRes int fallback, ImageView iv) {
    Glide.with(context).load(model).centerInside().placeholder(placeholder).error(error).fallback(fallback).into(iv);
  }

  public static void loadCenterCrop(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      ImageView iv) {
    Glide.with(context).load(model).centerCrop().placeholder(placeholder).error(error).into(iv);
  }

  public static void loadCenterCrop(Context context, Object model, @DrawableRes int placeholder, @DrawableRes int error,
      @DrawableRes int fallback, ImageView iv) {
    Glide.with(context).load(model).centerCrop().placeholder(placeholder).error(error).fallback(fallback).into(iv);
  }

  /**
   * 加载svg 图片
   */
  public static void loadSvg(Context context, String url, final ImageView iv) {
    RequestBuilder<PictureDrawable> requestBuilder = Glide.with(context)
        .as(PictureDrawable.class)
        .transition(withCrossFade())
        .listener(new SvgSoftwareLayerSetter());
    requestBuilder.load(Uri.parse(url)).into(iv);
  }

  public static void loadRawSvg(Context context, @RawRes int rawId, ImageView iv) {
    Uri uri = Uri.parse(
        ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + AppContext.getContext().getPackageName() + "/" + rawId);
    RequestBuilder<PictureDrawable> requestBuilder = Glide.with(context)
        .as(PictureDrawable.class)
        .transition(withCrossFade())
        .listener(new SvgSoftwareLayerSetter());
    requestBuilder.load(uri).into(iv);
  }

  public static void loadAssetsSvg(Context context, String fileName, ImageView iv) {
    Uri uri = Uri.parse("file:///android_asset" + File.separator + fileName);
    RequestBuilder<PictureDrawable> requestBuilder = Glide.with(context)
        .as(PictureDrawable.class)
        .transition(withCrossFade())
        .listener(new SvgSoftwareLayerSetter());
    requestBuilder.load(uri).into(iv);
  }

  public static void loadSvg(Context context, Uri uri, final ImageView iv) {
    RequestBuilder<PictureDrawable> requestBuilder = Glide.with(context)
        .as(PictureDrawable.class)
        .transition(withCrossFade())
        .listener(new SvgSoftwareLayerSetter());
    requestBuilder.load(uri).into(iv);
  }

  /**
   * 加载gif 图片
   */
  public static void loadGif(Context context, Object model, final ImageView iv, int looperCount) {
    loadGif(context, model, iv, looperCount, null);
  }

  /**
   * 加载gif图片 默认无限循环 无监听
   */
  public static void loadGif(Context context, Object model, final ImageView iv) {
    loadGif(context, model, iv, 0, null);
  }

  /**
   * 当iv图片尺寸不同时 最好自己指定 对应的holder、error 尺寸 不要使用默认的holder、error
   */
  public static void loadGif(Context context, Object model, final ImageView iv, @DrawableRes int holder,
      @DrawableRes int error) {
    loadGif(context, model, iv, holder, error, 0, null);
  }

  /**
   * @param context context
   * @param model url
   * @param iv imageView
   * @param model 传入的url
   * @param holder 加载中显示
   * @param error 加载失败显示
   * @param fallback 仅仅会在传入的model 是 null 时显示
   */
  public static void loadGifFb(Context context, Object model, final ImageView iv, @DrawableRes int holder,
      @DrawableRes int error, @DrawableRes int fallback) {
    loadGif(context, model, iv, holder, error, fallback, 0, DiskCacheStrategy.DATA, null);
  }

  public static void loadGifFb(Context context, Object model, ImageView iv, GifStatusListener listener) {
    loadGifFb(context, null, iv, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error,
        R.drawable.bc_img_fallback, listener);
  }

  public static void loadGifFb(Context context, Object model, final ImageView iv, @DrawableRes int holder,
      @DrawableRes int error, @DrawableRes int fallback, GifStatusListener listener) {
    loadGifFb(context, model, iv, holder, error, fallback, 0, DiskCacheStrategy.DATA, listener);
  }

  public static void loadGifFb(Context context, Object model, final ImageView iv, @DrawableRes int holder,
      @DrawableRes int error, @DrawableRes int fallback, int loopCount, GifStatusListener listener) {
    loadGifFb(context, model, iv, holder, error, fallback, loopCount, DiskCacheStrategy.DATA, listener);
  }

  /**
   * 加载git图片 类型图片使用默认的 holder error 带有监听
   */
  public static void loadGif(Context context, Object model, final ImageView iv, int looperCount,
      GifStatusListener listener) {
    loadGif(context, model, iv, R.drawable.bc_img_place_holder, R.drawable.bc_img_loading_error, 0, looperCount,
        DiskCacheStrategy.DATA, listener);
  }

  /**
   * 可以设置磁盘的缓存类型
   */
  public static void loadGif(Context context, Object model, final ImageView iv, @DrawableRes int placeHolder,
      @DrawableRes int error, int looperCount, GifStatusListener listener) {
    loadGif(context, model, iv, placeHolder, error, 0, looperCount, DiskCacheStrategy.DATA, listener);
  }

  /**
   * 加载gif 类型的图片
   *
   * @param context 上下文
   * @param model url drawable file uri
   * @param iv imageView
   * @param placeHolder 占位符
   * @param error 加载错误显示
   * @param fallback model 传入 null 显示mo'ren
   * @param looperCount 播放循环次数
   * @param listener gif 状态监听
   */
  public static void loadGifFb(Context context, Object model, final ImageView iv, @DrawableRes int placeHolder,
      @DrawableRes int error, @DrawableRes int fallback, int looperCount, DiskCacheStrategy diskCacheStrategy,
      GifStatusListener listener) {
    Glide.with(context)
        .asGif()
        .placeholder(placeHolder)
        .error(error)
        .fallback(fallback)
        .load(model)
        .centerCrop()
        .diskCacheStrategy(diskCacheStrategy)
        .listener(new RequestListener<GifDrawable>() {
          @Override public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target,
              boolean isFirstResource) {
            return false;
          }

          @Override public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
              DataSource dataSource, boolean isFirstResource) {
            try {
              Field gifStateField = GifDrawable.class.getDeclaredField("state");
              gifStateField.setAccessible(true);
              Class gifStateClass = Class.forName("com.bumptech.glide.load.resource.gif.GifDrawable$GifState");
              Field gifFrameLoaderField = gifStateClass.getDeclaredField("frameLoader");
              gifFrameLoaderField.setAccessible(true);
              Class gifFrameLoaderClass = Class.forName("com.bumptech.glide.load.resource.gif.GifFrameLoader");
              Field gifDecoderField = gifFrameLoaderClass.getDeclaredField("gifDecoder");
              gifDecoderField.setAccessible(true);
              Class gifDecoderClass = Class.forName("com.bumptech.glide.gifdecoder.GifDecoder");
              Object gifDecoder = gifDecoderField.get(gifFrameLoaderField.get(gifStateField.get(resource)));
              Method getDelayMethod = gifDecoderClass.getDeclaredMethod("getDelay", int.class);
              getDelayMethod.setAccessible(true);
              //如果
              if (looperCount > 0) {
                //设置只播放一次
                resource.setLoopCount(looperCount);
              }
              //获得总帧数
              int count = resource.getFrameCount();
              int delay = 0;
              for (int i = 0; i < count; i++) {
                //计算每一帧所需要的时间进行累加
                delay += (int) getDelayMethod.invoke(gifDecoder, i);
              }
              //设置监听
              if (listener != null) {
                //回调gif加载完成
                iv.postDelayed(() -> {
                  listener.onGifCompelete(resource, iv);
                }, delay);
              }
            } catch (NoSuchFieldException e) {
              e.printStackTrace();
            } catch (ClassNotFoundException e) {
              e.printStackTrace();
            } catch (IllegalAccessException e) {
              e.printStackTrace();
            } catch (NoSuchMethodException e) {
              e.printStackTrace();
            } catch (InvocationTargetException e) {
              e.printStackTrace();
            }
            return false;
          }
        })
        .into(iv);
  }

  /**
   * 加载gif 类型的图片
   *
   * @param context 上下文
   * @param model url drawable file uri
   * @param iv imageView
   * @param placeHolder 占位符
   * @param error 加载错误显示
   * @param fallback model 传入 null 显示mo'ren
   * @param looperCount 播放循环次数
   * @param listener gif 状态监听
   */
  public static void loadGif(Context context, Object model, final ImageView iv, @DrawableRes int placeHolder,
      @DrawableRes int error, @DrawableRes int fallback, int looperCount, DiskCacheStrategy diskCacheStrategy,
      GifStatusListener listener) {
    Glide.with(context)
        .asGif()
        .placeholder(placeHolder)
        .error(error)
        .load(model)
        .centerCrop()
        .diskCacheStrategy(diskCacheStrategy)
        .listener(new RequestListener<GifDrawable>() {
          @Override public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target,
              boolean isFirstResource) {
            return false;
          }

          @Override public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
              DataSource dataSource, boolean isFirstResource) {
            try {
              Field gifStateField = GifDrawable.class.getDeclaredField("state");
              gifStateField.setAccessible(true);
              Class gifStateClass = Class.forName("com.bumptech.glide.load.resource.gif.GifDrawable$GifState");
              Field gifFrameLoaderField = gifStateClass.getDeclaredField("frameLoader");
              gifFrameLoaderField.setAccessible(true);
              Class gifFrameLoaderClass = Class.forName("com.bumptech.glide.load.resource.gif.GifFrameLoader");
              Field gifDecoderField = gifFrameLoaderClass.getDeclaredField("gifDecoder");
              gifDecoderField.setAccessible(true);
              Class gifDecoderClass = Class.forName("com.bumptech.glide.gifdecoder.GifDecoder");
              Object gifDecoder = gifDecoderField.get(gifFrameLoaderField.get(gifStateField.get(resource)));
              Method getDelayMethod = gifDecoderClass.getDeclaredMethod("getDelay", int.class);
              getDelayMethod.setAccessible(true);
              //如果
              if (looperCount > 0) {
                //设置只播放一次
                resource.setLoopCount(looperCount);
              }
              //获得总帧数
              int count = resource.getFrameCount();
              int delay = 0;
              for (int i = 0; i < count; i++) {
                //计算每一帧所需要的时间进行累加
                delay += (int) getDelayMethod.invoke(gifDecoder, i);
              }
              //设置监听
              if (listener != null) {
                //回调gif加载完成
                iv.postDelayed(() -> {
                  listener.onGifCompelete(resource, iv);
                }, delay);
              }
            } catch (NoSuchFieldException e) {
              e.printStackTrace();
            } catch (ClassNotFoundException e) {
              e.printStackTrace();
            } catch (IllegalAccessException e) {
              e.printStackTrace();
            } catch (NoSuchMethodException e) {
              e.printStackTrace();
            } catch (InvocationTargetException e) {
              e.printStackTrace();
            }
            return false;
          }
        })
        .into(iv);
  }

  /**
   * 开始播放
   */
  public static void startGif(GifDrawable gifDraw, ImageView iv) {
    if (gifDraw == null || iv == null) {
      return;
    }
    if (gifDraw != iv.getDrawable()) {
      return;
    }
    if (!gifDraw.isRunning()) {
      gifDraw.start();
    }
  }

  /**
   * 暂停播放
   */
  public static void pauseGif(GifDrawable gifDraw, ImageView iv) {
    if (gifDraw == null || iv == null) {
      return;
    }
    if (gifDraw != iv.getDrawable()) {
      return;
    }
    if (gifDraw.isRunning()) {
      gifDraw.stop();
    }
  }

  /**
   * Gif 加载完成状态监听
   */
  public interface GifStatusListener {
    //gif 加载播放完成触发
    void onGifCompelete(GifDrawable gifDraw, ImageView iv);
  }
}
