package com.huangbop.mixi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class gitmodel {

  @Expose
  private String login;
  @Expose
  private Integer id;
  @SerializedName("avatar_url")
  @Expose
  private String avatarUrl;

}
