package com.huangbop.mixi.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.huangbop.mixi.R;
import com.huangbop.mixi.adapter.ProductAdapter;
import com.huangbop.mixi.data.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

  @InjectView(R.id.productList)
  ListView productList;

  Context context;
  ProductAdapter productAdapter;

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

    BmobQuery<Product> query = new BmobQuery<>();
    query.findObjects(context, new FindListener<Product>() {
      @Override
      public void onSuccess(List<Product> products) {
        Toast.makeText(context, "query OK" + products.size(), Toast.LENGTH_SHORT).show();

        productAdapter = new ProductAdapter(context, products);
        productList.setAdapter(productAdapter);
      }

      @Override
      public void onError(int i, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
      }
    });

    return currentView;
  }

}
