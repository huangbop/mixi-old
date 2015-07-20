package com.huangbop.mixi.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.huangbop.mixi.R;
import com.huangbop.mixi.base.BaseActivity;
import com.huangbop.mixi.fragment.OrderFragment;
import com.huangbop.mixi.fragment.ProductFragment;
import com.huangbop.mixi.fragment.ProfileFragment;
import com.umeng.update.UmengUpdateAgent;


import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity {

  private long preTime = 0;
  private Context context;

  @InjectView(R.id.mainContent)
  FrameLayout mainContent;

  @InjectView(R.id.tabsGroup)
  RadioGroup tabsGroup;

  static final int nr_fragment = 3;

  FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
    @Override
    public Fragment getItem(int position) {
      Fragment fragment = null;

      switch (position) {
        case 0:
          fragment = new ProductFragment();
          break;

        case 1:
          fragment = new OrderFragment();
          break;

        case 2:
          fragment = new ProfileFragment();
          break;

        default:
          fragment = new ProductFragment();
          break;
      }

      return fragment;
    }

    @Override
    public int getCount() {
      return nr_fragment;
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);

    // Auto update
    UmengUpdateAgent.update(this);

    context = this;

    tabsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index = 0;
        switch (checkedId) {
          case R.id.tabHome:
            index = 0;
            break;
          case R.id.tabOrder:
            index = 1;
            break;
          case R.id.tabProfile:
            index = 2;
            break;
          default:
            index = 0;
            break;
        }

        Fragment fragment = (Fragment)fragments.instantiateItem(mainContent, index);
        fragments.setPrimaryItem(mainContent, 0, fragment);
        fragments.finishUpdate(mainContent);
      }
    });


  }

  @Override
  protected void onStart() {
    super.onStart();
    tabsGroup.check(R.id.tabHome);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {

    if (keyCode == KeyEvent.KEYCODE_BACK) {
      long currentTime = System.currentTimeMillis();

      if ((currentTime - preTime) > 2000) {
        toastShort(context, "再按一次退出咪西");
        preTime = currentTime;
      } else {
        finish();
      }

      return true;
    }

    return super.onKeyDown(keyCode, event);
  }

}
