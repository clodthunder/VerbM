package com.lskj.gx.lib_test_ui.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lskj.gx.lib_business_db.RoomDbHelper;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import com.lskj.gx.lib_test_ui.R;

/**
 * 创建时间:  2020/9/7
 * 编写人: tzw
 * 功能描述:
 */
public class PagingTestHolder extends RecyclerView.ViewHolder {
  private View itemView;
  private AppCompatTextView tvTitle;
  private AppCompatTextView tvSubTitle;
  private AppCompatCheckBox cbItem;

  public PagingTestHolder(@NonNull View itemView, ViewGroup parent) {
    super(itemView);
    this.itemView = itemView;
    tvTitle = itemView.findViewById(R.id.tv_item_title);
    tvSubTitle = itemView.findViewById(R.id.tv_item_sub_content);
    cbItem = itemView.findViewById(R.id.cb_item);
  }

  //这里处理界面赋值问题
  public void bindTo(UserEntity item) {
    tvTitle.setText(item.getUserId());
    tvSubTitle.setText(item.getAddress());
    cbItem.setTag(item.getUserId());
    cbItem.setChecked(item.getIsCheck() == 1);
    cbItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (cbItem.getTag().equals(item.getUserId())) {
        //更新界面checkbox 状态
        item.setIsCheck(isChecked ? 1 : 0);
        RoomDbHelper.getInstance().getUserDao().updateUser(item);
      }
    });
  }
}
