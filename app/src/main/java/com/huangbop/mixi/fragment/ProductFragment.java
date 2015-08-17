package com.huangbop.mixi.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.huangbop.mixi.R;
import com.huangbop.mixi.adapter.ProductAdapter;
import com.huangbop.mixi.data.Product;
import com.huangbop.mixi.model.ProductModel;
import com.huangbop.mixi.network.MixiApi;
import com.huangbop.mixi.network.SnippetApi;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

  @InjectView(R.id.productList)
  ListView productList;

  @InjectView(R.id.productFrame)
  PtrClassicFrameLayout productFrame;

  Context context;
  ProductAdapter productAdapter;

  RestAdapter restAdapter;
  MixiApi mixiApi;

  public ProductFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View currentView = inflater.inflate(R.layout.fragment_product, container, false);
    ButterKnife.inject(this, currentView);

    context = getActivity();

    restAdapter = new RestAdapter.Builder().setEndpoint("http://mixi.today/api/v1").build();
    mixiApi = restAdapter.create(MixiApi.class);

    // ptr
    productFrame.setLastUpdateTimeRelateObject(this);
    productFrame.setPtrHandler(new PtrHandler() {
      @Override
      public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view1) {
        return PtrDefaultHandler.checkContentCanBePulledDown(ptrFrameLayout, view, view1);
      }

      @Override
      public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        updateData();
      }
    });

    productFrame.postDelayed(new Runnable() {
      @Override
      public void run() {
        productFrame.autoRefresh();
      }
    }, 1000);

    return currentView;
  }

  private void updateData() {

    mixiApi.getProduct(new Callback<List<ProductModel>>() {
      @Override
      public void success(List<ProductModel> productModels, Response response) {
        productFrame.refreshComplete();
        int i = 0;
      }

      @Override
      public void failure(RetrofitError error) {
        productFrame.refreshComplete();
        int i = 0;
      }
    });

  }

  @Override
  public void setMenuVisibility(boolean menuVisible) {
    super.setMenuVisibility(menuVisible);
    if (this.getView() != null) {
      this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }
  }
}
