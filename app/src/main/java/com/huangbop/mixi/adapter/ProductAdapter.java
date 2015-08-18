package com.huangbop.mixi.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangbop.mixi.R;
import com.huangbop.mixi.model.ProductModel;
import com.huangbop.mixi.utilities.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

  private final Context context;
  private List<ProductModel> productModels;

  public ProductAdapter(Context context, List<ProductModel> productModels) {
    this.context = context;
    this.productModels = productModels;
  }

  @Override
  public int getCount() {
    return productModels.size();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ImageView image;
    TextView title;
    TextView description;
    TextView price;

    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.listview_product, parent, false);
    }

    image = ViewHolder.get(convertView, R.id.product_image);
    title = ViewHolder.get(convertView, R.id.product_name);
    description = ViewHolder.get(convertView, R.id.product_desc);
    price = ViewHolder.get(convertView, R.id.product_price);

    Picasso.with(context).load(productModels.get(position).getImage()).into(image);
    title.setText(productModels.get(position).getTitle());
    description.setText(productModels.get(position).getDescription());
    price.setText(Double.toString(productModels.get(position).getPrice()));

    return convertView;
  }
}
