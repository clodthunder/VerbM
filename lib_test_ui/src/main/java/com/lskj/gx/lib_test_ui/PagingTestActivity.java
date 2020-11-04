package com.lskj.gx.lib_test_ui;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lskj.gx.lib_business_db.RoomDbHelper;
import com.lskj.gx.lib_business_db.RoomDbManger;
import com.lskj.gx.lib_business_db.dao.UserDao;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import com.lskj.gx.lib_test_ui.adapter.PagingTestAdapter;
import com.lskj.gx.lib_test_ui.diff.UserComparator;
import com.lskj.gx.lib_test_ui.viewmodel.PagingModel;

/**
 * 创建时间:  2020/9/7
 * 编写人: tzw
 * 功能描述:
 */
@Route(path = "/test_ui/paging_activity") public class PagingTestActivity extends AppCompatActivity {
  private Unbinder unbinder;
  @BindView(R2.id.rcv_list) RecyclerView rcvList;
  @BindView(R2.id.tl_home_bar) Toolbar toolBar;
  @BindView(R2.id.bc_ui_tv_title) AppCompatTextView tvBarTitle;
  @BindView(R2.id.rl_refresh_layout) SwipeRefreshLayout srLayout;
  private PagingTestAdapter mAdapter;
  private PagingModel mPagingModel;
  private RoomDbManger mRoomDbManger;
  private UserDao mUserDao;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_ui_activity_paging_test);
    unbinder = ButterKnife.bind(this);
    tvBarTitle.setText("Paging Test");

    mAdapter = new PagingTestAdapter(new UserComparator());
    rcvList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    rcvList.setAdapter(mAdapter);

    mRoomDbManger = RoomDbHelper.getInstance();
    mUserDao = mRoomDbManger.getUserDao();
    mPagingModel = new ViewModelProvider(this).get(PagingModel.class);

    mPagingModel.loadLiveData(mUserDao).observe(this, new Observer<PagedList<UserEntity>>() {
      @Override public void onChanged(PagedList<UserEntity> userVos) {
        srLayout.setRefreshing(false);
        mAdapter.submitList(userVos);
      }
    });
    mPagingModel.getBoundaryData().observe(this, new Observer<Boolean>() {
      @Override public void onChanged(Boolean aBoolean) {
        if (!aBoolean) {
          srLayout.setRefreshing(false);
        }
      }
    });
    srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        srLayout.setRefreshing(true);
        //mAdapter.submitList(null);
        //刷新dataSource
        //((DataSource) mPagingModel.getDataSource()).invalidate();
      }
    });
  }

  @OnClick({ R2.id.bc_ui_iv_back, R2.id.btn_diff_test, R2.id.btn_edit_user }) public void onClick(View v) {
    if (v.getId() == R.id.bc_ui_iv_back) {
      finish();
    } else if (v.getId() == R.id.btn_diff_test) {
      runOnUiThread(new Runnable() {
        @Override public void run() {
          //mAdapter.submitList(mPagingModel.testDiff());
        }
      });
    } else if (v.getId() == R.id.btn_edit_user) {
      ARouter.getInstance().build("/test_ui/db_test_activity").navigation();
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    //if (mRoomDbManger != null && mRoomDbManger.isOpen()) {
    //  mRoomDbManger.close();
    //}
    if (unbinder != null) {
      unbinder.unbind();
    }
  }
}
