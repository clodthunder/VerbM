package com.lskj.gx.lib_business_db.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.lskj.gx.lib_business_db.entity.IsCheckParam;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import java.util.List;

/**
 * 创建时间:  2020/9/8
 * 编写人: tzw
 * 功能描述: 获取用户数据库实体
 */
@Dao public interface UserDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertUser(UserEntity user);

  @Delete void deleteUser(UserEntity user);

  //根据checked 状态批量删除
  @Query("delete from t_user where isCheck=1") void deleteByChecked();

  //根据checked 状态批量更新
  @Query("update t_user set address=:newAddr where isCheck=1") void updateAddressByChecked(String newAddr);

  //根据userId 和 isCheck 删除  有局限性 必须要求知道 primary key
  @Delete(entity = UserEntity.class) void deleteUserByCheck(IsCheckParam... params);

  //1表示选中状态 有局限性 必须要求知道 primary key
  @Update(entity = UserEntity.class) void updateUserByCheck(IsCheckParam... isChecked);

  @Update void updateUser(UserEntity user);

  @Query("select * from t_user where userId= :userId") LiveData<UserEntity> queryUserById(String userId);

  @Query("select * from t_user where userId= :userId") UserEntity queryUser(String userId);

  @Query("select * from t_user where userId=:userId") LiveData<UserEntity> queryLvUser(String userId);

  @Query("select * from t_user") LiveData<List<UserEntity>> queryUsers();

  @Query("select * from t_user limit(:pageSize) offset(:pageIndex*:pageSize) ") List<UserEntity> queryUsers2(
      int pageIndex, int pageSize);

  @Query("SELECT * FROM t_user") DataSource.Factory<Integer, UserEntity> lvDataFactory();

  @Query("select * from t_user") DataSource.Factory<Integer, UserEntity> queryUsers3();

  //@Query("select * from t_user where region in  (:regions) ")
  //public LiveData<List<UserEntity>> queryUserByRegion(List<String> regions);
}
