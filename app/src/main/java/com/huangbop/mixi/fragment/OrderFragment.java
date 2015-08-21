package com.huangbop.mixi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangbop.mixi.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

  public OrderFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View currentView = inflater.inflate(R.layout.fragment_order, container, false);
    ButterKnife.inject(this, currentView);

    return currentView;
  }

  @Override
  public void setMenuVisibility(boolean menuVisible) {
    super.setMenuVisibility(menuVisible);
    if (this.getView() != null) {
      this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }
  }
}
