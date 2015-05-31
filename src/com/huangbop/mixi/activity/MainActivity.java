package com.huangbop.mixi.activity;

import com.huangbop.mixi.R;
import com.huangbop.mixi.R.id;
import com.huangbop.mixi.R.layout;
import com.huangbop.mixi.R.menu;
import com.huangbop.mixi.fragment.MenuFragment;
import com.huangbop.mixi.utils.InjectView;
import com.huangbop.mixi.utils.Injector;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends Activity {
	
	@InjectView(R.id.slidingpane_layout)
	private SlidingPaneLayout slidingpanelayout;
	
	private MenuFragment menuFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Injector.get(this).inject();

		menuFragment = new MenuFragment();
		
		FragmentTransaction trans = getFragmentManager().beginTransaction();
		trans.replace(R.id.slidingpane_menu, menuFragment);
		trans.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
