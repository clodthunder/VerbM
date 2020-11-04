package com.lskj.gx.lib_test_ui.diff;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import java.util.Objects;

/**
 * 创建时间:  2020/9/7
 * 编写人: tzw
 * 功能描述:
 */
public class UserComparator extends DiffUtil.ItemCallback<UserEntity> {

  @Override public boolean areItemsTheSame(@NonNull UserEntity oldItem, @NonNull UserEntity newItem) {
    // Id is unique.
    return oldItem.getUserId().equals(newItem.getUserId());
  }

  @Override public boolean areContentsTheSame(@NonNull UserEntity oldItem, @NonNull UserEntity newItem) {
    return Objects.equals(oldItem, newItem);
  }
}