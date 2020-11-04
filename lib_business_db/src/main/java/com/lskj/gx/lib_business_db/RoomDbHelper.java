package com.lskj.gx.lib_business_db;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.lskj.gx.lib_basic_base.BaseConstant;
import com.lskj.gx.lib_basic_utils.AppContext;

/**
 * 创建时间:  2020/9/8
 * 编写人: tzw
 * 功能描述:
 */
public class RoomDbHelper {

  private static RoomDbManger roomDbManager;

  public static RoomDbManger getInstance() {
    if (roomDbManager == null) {
      synchronized (RoomDbManger.class) {
        if (roomDbManager == null) {
          roomDbManager = Room.databaseBuilder(AppContext.getContext(), RoomDbManger.class, BaseConstant.DB_NAME)
              //.fallbackToDestructiveMigration()//丢弃原有数据
              .allowMainThreadQueries().addMigrations(MIGRATION_1_2)//正常的数据库版本升级
              .build();
        }
      }
    }
    return roomDbManager;
  }

  static final Migration MIGRATION_1_2 = new Migration(1, 2) {
    @Override public void migrate(SupportSQLiteDatabase database) {
      //此处对于数据库中的所有更新都需要写下面的代码
      database.execSQL("ALTER TABLE t_user ADD COLUMN isCheck INTEGER NOT NULL default 0 ;");
    }
  };
}
