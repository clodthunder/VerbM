package com.lskj.gx.lib_business_entity.vo;

import com.lskj.gx.lib_basic_base.BaseVo;
import java.io.Serializable;

/**
 * 创建时间:  2020/9/7
 * 编写人: tzw
 * 功能描述:
 */
public class LoginVo extends BaseVo<LoginVo> implements Serializable {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
