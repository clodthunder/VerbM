package com.lskj.gx.lib_test_ui.iservices;

import com.lskj.gx.lib_basic_base.BaseRes;
import com.lskj.gx.lib_business_db.entity.UserEntity;
import com.lskj.gx.lib_business_entity.vo.UserVo;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 创建时间:  2020/9/10
 * 编写人: tzw
 * 功能描述: retrofit 加载user list
 */
public interface IUserService {

  @GET("/user/getUsers")
  Call<BaseRes<ArrayList<UserVo>>> getUsers(@Query("pageIndex") int pageIndex,
      @Query("pageSize") int pageSize);
}
