package com.huangbop.mixi.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2015/6/5.
 */
public class BaseActivity extends FragmentActivity {

  private Toast toast;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bmob.initialize(this, "551f8336bef3059233ec08d7b01cd989");
  }

  protected void toastShort(Context context, CharSequence message) {
    if (toast == null) {
      toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
    } else {
      toast.setText(message);
    }
    toast.show();
  }

  protected void toastLong(Context context, CharSequence message) {
    if (toast == null) {
      toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
    } else {
      toast.setText(message);
    }
    toast.show();
  }

}
