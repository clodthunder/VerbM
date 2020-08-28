package com.lskj.gx.verbm.splash;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lskj.gx.lib_basic_base.BaseActivity;
import com.lskj.gx.lib_business_account.NavAccountFragment;
import com.lskj.gx.lib_business_home.NavHomeFragment;
import com.lskj.gx.lib_business_server.NavServerFragment;
import com.lskj.gx.lib_business_work.NavWorkFragment;
import com.lskj.gx.verbm.R;

/**
 * 创建时间:  2020/8/27
 * 编写人: tzw
 * 功能描述: 编写首页底部的 fragment 切换
 */
public class MainActivity extends BaseActivity {
  //通过arouter 获取该实例
  private NavHomeFragment navHomeFragment;
  private NavWorkFragment navWorkFragment;
  private NavServerFragment navServerFragment;
  private NavAccountFragment navAccountFragment;
  private FragmentManager fragManager;
  //当前正在显示的fragment
  private Fragment currentFragment;

  @BindView(R.id.bnv_home_navication) BottomNavigationView mNavigationView;

  @Override public int initView(@Nullable Bundle savedInstanceState) {
    return R.layout.app_navi_activity_main;
  }

  @Override public void initData(@Nullable Bundle savedInstanceState) {
    navHomeFragment = new NavHomeFragment();
    navWorkFragment = new NavWorkFragment();
    navServerFragment = new NavServerFragment();
    navAccountFragment = new NavAccountFragment();
    fragManager = getSupportFragmentManager();
    switchFragment(navHomeFragment);
    mNavigationView.setSelectedItemId(R.id.nav_menu_home);
    mNavigationView.setOnNavigationItemSelectedListener(item -> {
      if (item.getItemId() == R.id.nav_menu_home) {
        switchFragment(navHomeFragment);
      } else if (item.getItemId() == R.id.nav_menu_server) {
        switchFragment(navServerFragment);
      } else if (item.getItemId() == R.id.nav_menu_work) {
        switchFragment(navWorkFragment);
      } else if (item.getItemId() == R.id.nav_menu_account) {
        switchFragment(navAccountFragment);
      }
      return true;
    });
  }

  @Override public void initToolBar() {

  }

  /**
   *
   */
  public void switchFragment(Fragment fragment) {
    if (fragment == null) {
      return;
    }
    FragmentTransaction transaction = fragManager.beginTransaction();
    if (!fragment.isAdded()) {
      if (currentFragment != null) {
        //如果点击的是当前tab 则不操作
        if (currentFragment == fragment) {
          return;
        }
        transaction.hide(currentFragment);
      }
      transaction.add(R.id.fl_home_main, fragment, fragment.getClass().getName());
    } else {
      transaction.hide(currentFragment).show(fragment);
    }
    currentFragment = fragment;
    transaction.commit();
  }
}
