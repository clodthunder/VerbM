package com.lskj.gx.lib_basic_base;

import java.io.Serializable;

/**
 * 创建时间:  2020/8/31
 * 编写人: tzw
 * 功能描述: 主要接受后台返回来的数据
 */
public class BaseVo<T extends Serializable> implements Serializable {
  private T vo;

  public T getVo() {
    return vo;
  }

  public void setVo(T vo) {
    this.vo = vo;
  }
}
