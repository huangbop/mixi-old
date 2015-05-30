package com.huangbop.mixi.activity;

import com.huangbop.mixi.R;
import com.huangbop.mixi.R.id;
import com.huangbop.mixi.R.layout;
import com.huangbop.mixi.R.menu;
import com.huangbop.mixi.utils.InjectView;
import com.huangbop.mixi.utils.Injector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
	
	@InjectView(R.id.welcome_start)
	private TextView start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_welcome);
		Injector.get(this).inject();
		
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}
	
}
