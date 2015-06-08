package com.huangbop.mixi.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.huangbop.mixi.R;
import com.huangbop.mixi.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

  @InjectView(R.id.productList)
  ListView productList;

  Context context;
  ProductAdapter productAdapter;

  ArrayList<String> products = new ArrayList<>();

  public ProductFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View currentView = inflater.inflate(R.layout.fragment_product, container, false);
    ButterKnife.inject(this, currentView);

    getProducts();

    context = getActivity();
    productAdapter = new ProductAdapter(context, products);
    productList.setAdapter(productAdapter);

    return currentView;
  }

  private void getProducts() {
    for (int i = 0; i < 100; i++) {
      products.add("xxx");
    }
  }

}
