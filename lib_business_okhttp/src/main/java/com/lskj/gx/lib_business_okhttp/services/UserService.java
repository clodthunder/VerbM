package com.lskj.gx.lib_business_okhttp.services;

import com.lskj.gx.lib_basic_base.BaseRes;
import com.lskj.gx.lib_business_entity.dto.UserDto;
import com.lskj.gx.lib_business_entity.vo.LoginVo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: 用户接口相关的service
 */
public interface UserService {

  /**
   * 用户登录
   * {"userName":"用户名","password":"密码"}
   */
  @POST(value = "authz/login") Call<BaseRes<LoginVo>> login(@Body UserDto user);
}
