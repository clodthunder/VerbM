package com.lskj.gx.lib_business_db;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.lskj.gx.lib_business_db.dao.UserDao;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import java.io.IOException;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class) public class ExampleInstrumentedTest {

  private UserDao userDao;
  private RoomDbManger dbManager;

  @Before public void createDb() {
    Context context = ApplicationProvider.getApplicationContext();
    dbManager = Room.inMemoryDatabaseBuilder(context, RoomDbManger.class).build();
    userDao = dbManager.getUserDao();
  }

  @After public void closeDb() throws IOException {
    dbManager.close();
  }

  @Test public void testInsert() {
    String userId = UUID.randomUUID().toString();
    UserEntity user = new UserEntity();
    user.setUserName("userName");
    user.setAccount("account");
    user.setAddress("address");
    user.setCert("token:");
    user.setEmail("email:");
    user.setPwd("pwd:");

    System.out.println("insert user = " + user.toString());

    user.setUserId(userId);
    userDao.insertUser(user);
    UserEntity userData = userDao.queryUser(userId);
    System.out.println("query user = " + userData.toString());
  }
}