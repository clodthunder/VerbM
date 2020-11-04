package com.lskj.gx.lib_test_ui;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.lskj.gx.lib_basic_img.GxGlide;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述:
 */
@Route(path = "/test_ui/base64_test") public class Base64TestActivity extends AppCompatActivity {
  private Unbinder unbinder;
  @BindView(R2.id.aiv_base64_test) AppCompatImageView ivBase64Test;
  @BindView(R2.id.aiv_remote_svg_test) AppCompatImageView ivRemoteSvgTest;
  @BindView(R2.id.aiv_raw_svg_test) AppCompatImageView ivRawSvgTest;
  @BindView(R2.id.aiv_assets_svg_test) AppCompatImageView ivAssetsSvgTest;
  @BindView(R2.id.aiv_local_gif_test) AppCompatImageView ivLocalGifTest;
  @BindView(R2.id.aiv_remote_gif_test) AppCompatImageView ivRemoteGifTest;
  @BindView(R2.id.aiv_error_gif_test) AppCompatImageView ivErrorGifTest;
  @BindView(R2.id.iv_big_error) AppCompatImageView ivBigErrorTest;
  @BindView(R2.id.aiv_default_gif_test) AppCompatImageView ivDefaultGifTest;
  @BindView(R2.id.iv_circle) CircleImageView ivCircle;
  @BindView(R2.id.iv_error_circle) CircleImageView ivErrorCircle;
  @BindView(R2.id.iv_round) AppCompatImageView ivRound;
  @BindView(R2.id.iv_error_round) AppCompatImageView ivErrorRound;
  @BindView(R2.id.iv_round_four) AppCompatImageView ivRoundFour;
  @BindView(R2.id.iv_error_round_four) AppCompatImageView ivErrorRoundFour;
  private static final String DATA_URI =
      "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD//gA7Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZ\n"
          + "yBJSkcgSlBFRyB2ODApLCBxdWFsaXR5ID0gNzUK/9sAQwAIBgYHBgUIBwcHCQkICgwUDQwLCwwZEhMPFB0aHx4\n"
          + "dGhwcICQuJyAiLCMcHCg3KSwwMTQ0NB8nOT04MjwuMzQy/9sAQwEJCQkMCwwYDQ0YMiEcITIyMjIyMjIyMjIyM\n"
          + "jIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIy/8AAEQgAZABkAwEiAAIRAQMRAf/EAB8AAAE\n"
          + "FAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcic\n"
          + "RQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN\n"
          + "0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5\n"
          + "ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQ\n"
          + "EAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDR\n"
          + "EVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i\n"
          + "5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/aAAwDAQACEQMRAD8A+f6KKKACiiigAoooo\n"
          + "AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoorU8NabDrPirSNLuGkWC9vYbe\n"
          + "RoyAwV3CkjIIzg+hoAy6K6HxJ4VvdH1bVxbWF++kWd/Pax3kkLFCEkKDLgBc8DPvWbpuh6trLMul6Xe3xT7wtb\n"
          + "d5dv12g0AUKKmuLO6tLtrS5tpoblG2tDIhV1PoVPOauX3h7W9LtluNQ0fULSBjhZbi2eNSfYkAUAZtFX9O0LV9\n"
          + "XSR9N0q+vUi/1jW1u8gT67QcVe8K+GJ/E3iNNK85bRFV5bqeYcQRIMuxHsB09cdKAMKiu9vtC8A3+h6jN4c13U\n"
          + "ItRsI/N8nV/KjS7UH5hFjndjkKeT6dxj+B/B9z408RQ6dFIILYFTc3LfdiQsFHXqxJAUdyaAOaorU8S6bDo3ir\n"
          + "V9Lt2kaCyvZreNpCCxVHKgnAAzgegrLoAKKKKACug8Cf8lD8Nf9hW1/8ARq1z9WLC+uNM1G2v7OTy7q1lSaF9o\n"
          + "O11IKnB4OCB1oA96sNX8R6l8bPEGi6zJcv4cCXaXdq4IgjtdrFHx90E/L83U5PJrnPC0t7pnw/0i51nxjq2laT\n"
          + "czzLp1losH76Rlf5y8igH72cKxPHTjiuJv/iR4w1PSbjS7vXbiSzuZHkmjAVd5dizDIAO0kn5c7e2MUzQPiD4r\n"
          + "8L6e9ho2sS21q7FjFsRwCepG4Hb+GKAPT/Gt/Novxj8G6pDpF/qlwmkQO1rNFm6mb96pLKoP70DDHA4K1FfXv8\n"
          + "Awk3hvxNN4e8aa8yxWbzXuka5AJgIx95VkOVRgemPm4/GvK9Q8Y+IdVu7C7vtVnmu9Pz9muTgSp82774G44PTJ\n"
          + "OO1Xtb+JPjDxFpp07VNcnntGxviCJGHwc/NtUFufWgD1O41XQ/DfgPweJb7xjY2s2npKH0B4khknJzJvZuS+7s\n"
          + "TjGMDrS6ZrNlqPxU1Oe10TUVur3wxLELXVrZYZb6cAHJVDgh0TqMZ5wBXk/h74heK/Ctk1no2szW1sxJ8ookig\n"
          + "nqQHB2/hisqbXtWuNb/ALal1G5bU94kF0ZD5gYdCD2xQB6ZpXiLVfHPhTxXaeKbe3ksdL017i0mW0SE2lwpASN\n"
          + "SoGM8jB54xWj4ObwYbTwhpen+MPsd59utby+s/wCzJne8uw6lY2l4UKpyo6jJLHNeb6/8QvFfiiwSx1jWZrm1Q\n"
          + "7vK2IisexbaBu/HNYNhfXGmajbX9nJ5d1aypNC+0Ha6kFTg8HBA60AdR8ULTTrT4h6x/Z2qfb/Ou5pbj/R2i+z\n"
          + "zGV90XP3tvHzDg5rj6sX99canqNzf3knmXV1K80z7QNzsSWOBwMknpVegAooooAKKKKACiiigAooooAKKKKACi\n"
          + "iigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoo\n"
          + "ooA//2Q==";
  @BindView(R2.id.aiv_xml_svg_test) AppCompatImageView ivXmlSvgTest;

  //加载svg 图片
  @SuppressLint("CheckResult") @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_ui_img_base64_test);
    unbinder = ButterKnife.bind(this);
    Glide.with(this)
        .load(DATA_URI.toString())
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
        .into(ivBase64Test);

    GxGlide.loadSvg(this, "http://192.168.2.129:9090/images/test.svg", ivRemoteSvgTest);

    //GxGlide.loadSvg(this,
    //    Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.test_ui_android_toy_h),
    //    ivRawSvgTest);
    //GxGlide.loadRawSvg(this, R.raw.test_ui_android_toy_h, ivRawSvgTest);

    GxGlide.loadRawSvg(this, R.raw.test_ui_android_toy_h, ivRawSvgTest);

    //加载xml 类型的svg 图片 这里需要注意的是vector 和svg 的关系
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      VectorDrawable vectorDrawable = (VectorDrawable) getResources().getDrawable(R.drawable.test_ui_ic_apple);
      Drawable drawable = vectorDrawable.getCurrent();
      Glide.with(this).load(drawable).into(ivXmlSvgTest);
    }

    //Uri uri4 = Uri.parse("file:///android_asset/test.svg");
    //GxGlide.loadSvg(this, uri4, ivAssetsSvgTest);
    GxGlide.loadAssetsSvg(this, "test.svg", ivAssetsSvgTest);

    //加载error网络图片
    GxGlide.loadGif(this, "http://192.168.2.129:9090/images/test1.gif", ivErrorGifTest, 0, (gifDraw, iv) -> {
      Toast.makeText(Base64TestActivity.this, "error gif 执行完成了", Toast.LENGTH_SHORT).show();
    });
    //加载default网络图片
    GxGlide.loadGifFb(this, "http://192.168.2.129:9090/images/test1.gif", ivDefaultGifTest, (gifDraw, iv) -> {
      Toast.makeText(Base64TestActivity.this, "default gif 执行完成了", Toast.LENGTH_SHORT).show();
    });
    //加载网络图片
    GxGlide.loadGif(this, "http://192.168.2.129:9090/images/test.gif", ivRemoteGifTest, 0, (gifDraw, iv) -> {
      Toast.makeText(Base64TestActivity.this, "remote local gif 执行完成了", Toast.LENGTH_SHORT).show();
    });
    //加载本地图片
    GxGlide.loadGif(this, R.drawable.test_ui_musi, ivLocalGifTest, 0, (gifDraw, iv) -> {
      Toast.makeText(Base64TestActivity.this, "local gif 执行完成了", Toast.LENGTH_SHORT).show();
    });
    //加载big error网络图片
    GxGlide.loadGif(this, "http://192.168.2.129:9090/images/test1.gif", ivBigErrorTest, 0, (gifDraw, iv) -> {
      Toast.makeText(Base64TestActivity.this, "big error gif 执行完成了", Toast.LENGTH_SHORT).show();
    });

    String urlCir = "http://192.168.2.129:9090/images/dGVtcA.jpg";
    GxGlide.load(this, urlCir, ivCircle);
    GxGlide.loadFb(this, null, ivErrorCircle);

    GxGlide.loadRounded(this, urlCir, ivRound);
    GxGlide.loadRoundedFb(this, null, 10, ivErrorRound);

    GxGlide.loadRoundFour(this, urlCir, ivRoundFour, 10, 10, 5, 10);
    GxGlide.loadRoundFourFb(this, null, ivErrorRoundFour, 10, 10, 5, 10);
  }

  @Override protected void onDestroy() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroy();
  }
}
