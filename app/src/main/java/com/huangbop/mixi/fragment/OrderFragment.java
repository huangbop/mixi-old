package com.huangbop.mixi.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.huangbop.mixi.R;
import com.huangbop.mixi.api.gitapi;
import com.huangbop.mixi.model.gitmodel;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

  @InjectView(R.id.button)
  Button click;
  @InjectView(R.id.tv)
  TextView tv;
  @InjectView(R.id.edit)
  EditText edit_user;
  @InjectView(R.id.pb)
  ProgressBar pbar;

  String API = "https://api.github.com";

  public OrderFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View currentView = inflater.inflate(R.layout.fragment_order, container, false);
    ButterKnife.inject(this, currentView);

    click.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String user = edit_user.getText().toString();

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API).build();
        gitapi api = restAdapter.create(gitapi.class);

        api.getFeed(user, new Callback<gitmodel>() {
          @Override
          public void success(gitmodel gitmodel, Response response) {
            Integer i = 0;
          }

          @Override
          public void failure(RetrofitError error) {
            Integer i = 0;
          }
        });

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
