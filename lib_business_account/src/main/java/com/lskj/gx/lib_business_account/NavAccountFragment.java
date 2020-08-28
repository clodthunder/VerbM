package com.lskj.gx.lib_business_account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建时间:  2020/8/27
 * 编写人: tzw
 * 功能描述:
 */
public class NavAccountFragment extends Fragment {
  private Unbinder unBinder;
  @BindView(R2.id.bi_account_tv_account) AppCompatTextView tvNavHome;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    //accountViewModel = ViewModelProvider.of(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.bi_account_nav_account, container, false);
    unBinder = ButterKnife.bind(this, root);

    return root;
  }

  @Override public void onDestroyView() {
    if (unBinder != null) {
      unBinder.unbind();
    }
    super.onDestroyView();
  }
}
