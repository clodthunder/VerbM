package com.lskj.gx.lib_test_ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import com.lskj.gx.lib_test_ui.R;
import com.lskj.gx.lib_test_ui.holder.PagingTestHolder;
import java.util.Objects;

/**
 * 创建时间:  2020/9/7
 * 编写人: tzw
 * 功能描述: 自定义 pagelist to recycleView
 */
public class PagingTestAdapter extends PagedListAdapter<UserEntity, PagingTestHolder> {

  public PagingTestAdapter(@NonNull DiffUtil.ItemCallback<UserEntity> diffCallback) {
    super(diffCallback);
  }

  @NonNull @Override public PagingTestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_ui_item_paging, parent, false);
    return new PagingTestHolder(itemView, parent);
  }

  @Override public void onBindViewHolder(@NonNull PagingTestHolder holder, int position) {
    holder.bindTo(Objects.requireNonNull(getItem(position)));
  }




}
