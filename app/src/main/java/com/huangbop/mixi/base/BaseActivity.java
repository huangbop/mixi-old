package com.huangbop.mixi.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/6/5.
 */
public class BaseActivity extends Activity {

  private Toast toast;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
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
