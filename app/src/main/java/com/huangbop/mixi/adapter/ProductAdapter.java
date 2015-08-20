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

import java.util.ArrayList;
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
    ImageView[] ivBrands = new ImageView[3];
    ArrayList<Integer> brandIDs = new ArrayList<>();

    double price;
    ProductModel product;

    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.listview_product, parent, false);
    }

    ivImage = ViewHolder.get(convertView, R.id.product_image);
    tvTitle = ViewHolder.get(convertView, R.id.product_name);
    tvDesc = ViewHolder.get(convertView, R.id.product_desc);
    tvPrice = ViewHolder.get(convertView, R.id.product_price);
    ivBrands[0] = ViewHolder.get(convertView, R.id.brand0);
    ivBrands[1] = ViewHolder.get(convertView, R.id.brand1);
    ivBrands[2] = ViewHolder.get(convertView, R.id.brand2);

    product = productModels.get(position);
    Picasso.with(context).load(product.getImage()).into(ivImage);
    tvTitle.setText(product.getTitle());
    tvDesc.setText(product.getDescription());
    price = product.getPrice();
    if (price % 1.0 == 0)
      tvPrice.setText(Long.toString((long)price));
    else
      tvPrice.setText(Double.toString(price));

    if (product.isHot())
      brandIDs.add(R.mipmap.is_hot);
    if (product.isPep())
      brandIDs.add(R.mipmap.is_pep);
    if (product.isNew())
      brandIDs.add(R.mipmap.is_new);
    for (int i = 0; i < ivBrands.length; i++)
      ivBrands[i].setImageResource(R.mipmap.white);
    for (int i = 0; i < brandIDs.size(); i++)
      ivBrands[i].setImageResource(brandIDs.get(i));

    return convertView;
  }
}
