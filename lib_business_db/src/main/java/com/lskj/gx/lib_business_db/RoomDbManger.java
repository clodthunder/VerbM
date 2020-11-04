package com.lskj.gx.lib_business_db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.lskj.gx.lib_business_db.dao.UserDao;
import com.lskj.gx.lib_business_db.entity.UserEntity;

/**
 * 创建时间:  2020/9/8
 * 编写人: tzw
 * 功能描述: 数据库实体类注册
 */
@Database(entities = { UserEntity.class }, version = 2) public abstract class RoomDbManger extends RoomDatabase {
  //获取用户实体类Dao
  public abstract UserDao getUserDao();

}
