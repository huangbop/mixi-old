package com.huangbop.mixi.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangbop.mixi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeaderFragment extends Fragment {


  public HeaderFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_header, container, false);
  }


}
