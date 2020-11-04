package com.lskj.gx.lib_test_ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lskj.gx.lib_business_db.RoomDbHelper;
import com.lskj.gx.lib_business_db.RoomDbManger;
import com.lskj.gx.lib_business_db.dao.UserDao;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import com.lskj.gx.lib_test_ui.adapter.PagingTestAdapter;
import com.lskj.gx.lib_test_ui.diff.UserComparator;
import com.lskj.gx.lib_test_ui.viewmodel.PagingModel;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 创建时间:  2020/9/8
 * 编写人: tzw
 * 功能描述:
 */
@Route(path = "/test_ui/db_test_activity") public class DbTestActivity extends AppCompatActivity {
  private final String TAG = DbTestActivity.class.getSimpleName();
  private Unbinder unbinder;
  private RoomDbManger roomDbManger;
  private UserDao userDao;

  @BindView(R2.id.tv_insert_user) AppCompatTextView tvInsertUser;
  @BindView(R2.id.tv_query_user) AppCompatTextView tvQueryUser;
  @BindView(R2.id.et_user_account) AppCompatEditText etAccount;
  @BindView(R2.id.et_user_address) AppCompatEditText etAddress;
  @BindView(R2.id.et_select_id) AppCompatEditText etSelectId;
  @BindView(R2.id.rcv_user_test) RecyclerView rcvUserTest;
  private PagingTestAdapter adapter;
  private PagingModel pagingModel;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_ui_db_test);
    unbinder = ButterKnife.bind(this);
    roomDbManger = RoomDbHelper.getInstance();
    userDao = roomDbManger.getUserDao();

    rcvUserTest.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    pagingModel = new ViewModelProvider(this).get(PagingModel.class);

    adapter = new PagingTestAdapter(new UserComparator());
    rcvUserTest.setAdapter(adapter);

    pagingModel.loadLiveData(userDao).observe(this, userVos -> {
      System.out.println(TAG + "invoke onChanged()  submitlist");
      adapter.submitList(userVos);
    });
  }

  @OnClick({
      R2.id.btn_insert, R2.id.btn_delete, R2.id.btn_update, R2.id.btn_query, R2.id.btn_select_all,
      R2.id.btn_delete_checked
  }) public void onClick(View v) {
    if (v.getId() == R.id.btn_insert) {
      Toast.makeText(this, "insert", Toast.LENGTH_SHORT).show();
      insert();
    } else if (v.getId() == R.id.btn_query) {
      Toast.makeText(this, "query", Toast.LENGTH_SHORT).show();
      //query();
      selectAll();
    } else if (v.getId() == R.id.btn_delete) {
      Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
      delete();
    } else if (v.getId() == R.id.btn_update) {
      Toast.makeText(this, "update", Toast.LENGTH_SHORT).show();
      update();
    } else if (v.getId() == R.id.btn_select_all) {
      Toast.makeText(this, "select all", Toast.LENGTH_SHORT).show();
      selectAll();
    } else if (v.getId() == R.id.btn_delete_checked) {
      deleteBeatchByChecked();
    } else if (v.getId() == R.id.btn_update_checked) {
      updateBeatchByChecked();
    }
  }

  private void selectAll() {
    LiveData<List<UserEntity>> lvDatas = userDao.queryUsers();
    lvDatas.observe(this, new Observer<List<UserEntity>>() {
      @Override public void onChanged(List<UserEntity> userEntities) {
        if (userEntities == null || userEntities.size() == 0) {
          Toast.makeText(DbTestActivity.this, "数据0", Toast.LENGTH_SHORT).show();
          return;
        }
        tvQueryUser.setText(Arrays.toString(new List[] { Arrays.asList(userEntities) }));
      }
    });
  }

  private void update() {
    String uId = etSelectId.getText().toString();
    UserEntity userEntity = userDao.queryUser(uId);
    if (userEntity == null) {
      Toast.makeText(this, "该用户不存在", Toast.LENGTH_SHORT).show();
      return;
    }
    userEntity.setAddress(etAddress.getText().toString());
    userEntity.setAccount(etAccount.getText().toString());
    userDao.updateUser(userEntity);
    System.out.println("更新用户数据成功");
  }  //批量更新 选中的数据

  private void updateBeatchByChecked() {
    //更新条件 isCheck ==1
    //userDao.updateUserByCheck(new IsCheckParam(1));
    String newAddr = etAddress.getText().toString();
    if (TextUtils.isEmpty(newAddr)) {
      Toast.makeText(this, "请输入要更新的address", Toast.LENGTH_SHORT).show();
      return;
    }
    userDao.updateAddressByChecked(newAddr);
    System.out.println("已执行批量更新checked address");
  }

  //批量更加objId 删除记录
  private void deleteBeatchByChecked() {
    //删除条件 isCheck ==1 选中的删除
    //userDao.deleteUserByCheck(new IsCheckParam(1));
    userDao.deleteByChecked();
    System.out.println("已执行批量删除checked record");
  }

  private void delete() {
    String uId = etSelectId.getText().toString();
    UserEntity userEntity = userDao.queryUser(uId);
    if (userEntity == null) {
      Toast.makeText(this, "该用户不存在", Toast.LENGTH_SHORT).show();
      return;
    }
    userDao.deleteUser(userEntity);
    System.out.println("删除操作执行完成");
  }

  private void query() {
    LiveData<UserEntity> lvUserData = userDao.queryLvUser("123456");
    if (lvUserData == null) {
      tvQueryUser.setText(null);
      Toast.makeText(this, "不存在该用户", Toast.LENGTH_SHORT).show();
      return;
    }
    lvUserData.observe(this, userEntity -> tvQueryUser.setText(userEntity.toString()));
    System.out.println("query 完成");
  }

  private void insert() {
    String userId = UUID.randomUUID().toString();
    UserEntity user = new UserEntity();
    user.setUserId(userId);
    user.setUserName("userName");
    String tempAccount = etAccount.getText().toString();
    if (TextUtils.isEmpty(tempAccount)) {
      Toast.makeText(this, "account is null", Toast.LENGTH_SHORT).show();
      return;
    }
    user.setAccount(tempAccount);
    String tempAddress = etAddress.getText().toString();
    if (TextUtils.isEmpty(tempAddress)) {
      Toast.makeText(this, "address is null", Toast.LENGTH_SHORT).show();
      return;
    }
    user.setAddress(tempAddress);
    user.setCert("token:");
    user.setEmail("email:");
    user.setPwd("pwd:");

    etSelectId.setText(user.getUserId());
    tvInsertUser.setText(user.toString());
    userDao.insertUser(user);
    System.out.println("insert 执行完成 userId");
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    //if (roomDbManger != null && roomDbManger.isOpen()) {
    //  roomDbManger.close();
    //}
    if (unbinder != null) {
      unbinder.unbind();
    }
  }
}
