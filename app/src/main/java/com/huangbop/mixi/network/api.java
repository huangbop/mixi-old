package com.huangbop.mixi.network;


import com.huangbop.mixi.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface api {

  @GET("/feeds/flowers.json")
  public void getData(Callback<List<Flower>> response);
}
