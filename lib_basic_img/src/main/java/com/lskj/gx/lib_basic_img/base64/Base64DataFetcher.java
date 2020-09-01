package com.lskj.gx.lib_basic_img.base64;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.nio.ByteBuffer;

/**
 * 创建时间:  2020/9/1
 * 编写人: tzw
 * 功能描述: 这个是解析 标准的base64 图片 格式：data:image/jpeg;base64,/9j/4AAQSkZJ....
 * 实际测试能正常显示：发现问题129k 的图片转成base64标准字符串实在是太长了 预估500多行代码都不止，受不了
 */
public class Base64DataFetcher implements DataFetcher<ByteBuffer> {
  private final String model;

  public Base64DataFetcher(String model) {
    this.model = model;
  }

  @Override public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super ByteBuffer> callback) {
    String base64Section = getBase64SectionOfModel();
    byte[] data = Base64.decode(base64Section, Base64.DEFAULT);
    ByteBuffer byteBuffer = ByteBuffer.wrap(data);
    callback.onDataReady(byteBuffer);
  }

  private String getBase64SectionOfModel() {
    // See https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/Data_URIs.
    int startOfBase64Section = model.indexOf(',');
    return model.substring(startOfBase64Section + 1);
  }

  @Override public void cleanup() {

  }

  /**
   * 对于可以取消的网络连接库或长时间加载，实现 cancel() 方法是一个好主意
   * Base64 没有提供取消的 API ，所以我们可以把这里留空
   */
  @Override public void cancel() {

  }

  @NonNull @Override public Class<ByteBuffer> getDataClass() {
    return ByteBuffer.class;
  }

  //对于 Base64 String，你的应用最好的选择可能取决于你如何获取到这些 String。如果它们是从一个本地数据库取得的，则 DataSource.LOCAL
  // 最有意义。如果你每次通过 HTTP 取回它们，则 DataSource.REMOTE 比较合适
  @NonNull @Override public DataSource getDataSource() {
    //return DataSource.LOCAL;
    return DataSource.REMOTE;
  }
}
