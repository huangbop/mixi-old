package com.huangbop.mixi.network;

import com.huangbop.mixi.model.ProductModel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


public interface MixiApi {

  @GET("/snippets/?format=json")
  public void getProduct (Callback<List<ProductModel>> response);
}
