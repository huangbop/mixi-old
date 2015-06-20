package com.huangbop.mixi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangbop.mixi.R;
import com.huangbop.mixi.data.Product;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2015/6/7.
 */
public class ProductAdapter extends BaseAdapter {

  LayoutInflater inflater;
  List<Product> products;

  public ProductAdapter(Context context, List<Product> products) {
    inflater = LayoutInflater.from(context);
    this.products = products;
  }


  @Override
  public int getCount() {
    return products.size();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;

    if (convertView == null) {
      convertView = inflater.inflate(R.layout.listview_product, null);
      holder = new ViewHolder();
      holder.product_image = (ImageView) convertView.findViewById(R.id.product_image);
      holder.product_name = (TextView) convertView.findViewById(R.id.product_information);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    Product p = products.get(position);
    holder.product_name.setText(p.name);

    return convertView;
  }

  class ViewHolder {
    ImageView product_image;
    TextView product_name;
  }
}
