package com.lskj.gx.lib_test_ui;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.lskj.gx.lib_basic_img.svg.SvgSoftwareLayerSetter;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述:
 */
@Route(path = "/test_ui/base64_test") public class Base64Test extends AppCompatActivity {
  private Unbinder unbinder;
  @BindView(R2.id.aiv_base64_test) AppCompatImageView ivBase64Test;
  @BindView(R2.id.aiv_svg_test) AppCompatImageView ivSvgTest;
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
  //加载svg 图片
  private RequestBuilder<PictureDrawable> requestBuilder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.img_base64_test);
    unbinder = ButterKnife.bind(this);
    Glide.with(this)
        .load(DATA_URI.toString())
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
        .into(ivBase64Test);
    requestBuilder =
        Glide.with(this).as(PictureDrawable.class).transition(withCrossFade()).listener(new SvgSoftwareLayerSetter());
    //Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.android_toy_h);
    String testSvn = "http://192.168.2.129:9090/images/test.svg";
    requestBuilder.load(Uri.parse(testSvn)).into(ivSvgTest);
  }

  @Override protected void onDestroy() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroy();
  }
}
