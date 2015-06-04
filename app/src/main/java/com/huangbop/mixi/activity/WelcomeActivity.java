package com.huangbop.mixi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.huangbop.mixi.R;
import com.huangbop.mixi.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
      }
    }, 2000);
  }

}
