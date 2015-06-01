package com.huangbop.mixi.fragment;

import com.huangbop.mixi.R;
import com.huangbop.mixi.R.id;
import com.huangbop.mixi.R.layout;
import com.huangbop.mixi.R.menu;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentFragment extends Fragment {

	private View currentView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		currentView = inflater.inflate(R.layout.slidingpane_content_layout, 
				container, false);
		
		return currentView;
	}
}
