package com.huangbop.mixi.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangbop.mixi.R;

public class MenuFragment extends Fragment {
	
	private View currentView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		currentView = inflater.inflate(R.layout.slidingpane_menu_layout, 
				container, false);
		
		return currentView;
	}

}
