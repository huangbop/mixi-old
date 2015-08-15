package com.huangbop.mixi.network;


import com.huangbop.mixi.model.SnippetModel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface SnippetApi {

  @GET("/snippets/?format=json")
  public void getData(Callback<List<SnippetModel>> response);
}
