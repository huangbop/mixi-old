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
    ImageView ivImage;
    TextView tvTitle;
    TextView tvDesc;
    TextView tvPrice;
    ImageView ivIsPep;
    ImageView ivIsHot;
    ImageView ivIsNew;
    double price;
    ProductModel product;

    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.listview_product, parent, false);
    }

    ivImage = ViewHolder.get(convertView, R.id.product_image);
    tvTitle = ViewHolder.get(convertView, R.id.product_name);
    tvDesc = ViewHolder.get(convertView, R.id.product_desc);
    tvPrice = ViewHolder.get(convertView, R.id.product_price);
    ivIsPep = ViewHolder.get(convertView, R.id.is_pep);
    ivIsHot = ViewHolder.get(convertView, R.id.is_hot);
    ivIsNew = ViewHolder.get(convertView, R.id.is_new);

    product = productModels.get(position);
    Picasso.with(context).load(product.getImage()).into(ivImage);
    tvTitle.setText(product.getTitle());
    tvDesc.setText(product.getDescription());
    price = product.getPrice();
    if (price % 1.0 == 0)
      tvPrice.setText(Long.toString((long)price));
    else
      tvPrice.setText(Double.toString(price));

    if (!product.isPep())
      ivIsPep.setVisibility(View.INVISIBLE);
    if (!product.isHot())
      ivIsHot.setVisibility(View.INVISIBLE);
    if (!product.isNew())
      ivIsNew.setVisibility(View.INVISIBLE);

    return convertView;
  }
}
