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
    ImageView imageView;
    TextView textView;

    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.listview_product, parent, false);

      imageView = (ImageView) convertView.findViewById(R.id.product_image);
      textView = (TextView) convertView.findViewById(R.id.product_name);
      convertView.setTag(new ViewHolder(imageView, textView));
    } else {
      ViewHolder viewHolder = (ViewHolder) convertView.getTag();
      imageView = viewHolder.imageView;
      textView = viewHolder.textView;
    }

    Picasso.with(context).load(productModels.get(position).getImage()).into(imageView);
    textView.setText(productModels.get(position).getTitle());

    return convertView;
  }

  private static class ViewHolder {
    public final TextView textView;
    public final ImageView imageView;

    public ViewHolder(ImageView imageView, TextView textView) {
      this.imageView = imageView;
      this.textView = textView;
    }
  }
}
