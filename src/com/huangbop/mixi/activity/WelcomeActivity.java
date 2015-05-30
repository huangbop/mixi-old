package com.huangbop.mixi.activity;

import com.huangbop.mixi.R;
import com.huangbop.mixi.R.id;
import com.huangbop.mixi.R.layout;
import com.huangbop.mixi.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		

	}
	
}
