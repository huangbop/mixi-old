package com.huangbop.mixi.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.huangbop.mixi.R;
import com.huangbop.mixi.model.Flower;
import com.huangbop.mixi.network.api;
import com.huangbop.mixi.adapter.FlowerAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ProfileFragment extends Fragment {

  List<Flower> flowerList;
  @InjectView(R.id.list)
  ListView list;

  public ProfileFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View currentView = inflater.inflate(R.layout.fragment_profile, container, false);
    ButterKnife.inject(this, currentView);

    final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://services.hanselandpetal.com").build();
    api flowerapi = restAdapter.create(api.class);
    flowerapi.getData(new Callback<List<Flower>>() {
      @Override
      public void success(List<Flower> flowers, Response response) {
        flowerList = flowers;
        FlowerAdapter adpt = new FlowerAdapter(getActivity(), R.layout.item_file, flowerList);
        list.setAdapter(adpt);
      }

      @Override
      public void failure(RetrofitError error) {
        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
      }
    });

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
