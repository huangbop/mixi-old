package com.huangbop.mixi.data;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2015/6/19.
 */
public class Product extends BmobObject {
  String name;
  Integer price;
  BmobFile image;

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

}
