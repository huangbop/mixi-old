package com.huangbop.mixi.adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangbop.mixi.R;
import com.huangbop.mixi.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {

  String url = "http://services.hanselandpetal.com/photos/";
  private Context context;
  private List<Flower> flowerList;

  public FlowerAdapter(Context context, int resource, List<Flower> objects) {
    super(context, resource, objects);
    this.context = context;
    this.flowerList = objects;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.item_file, parent, false);
    Flower flower = flowerList.get(position);
    TextView textView = (TextView) view.findViewById(R.id.name);
    textView.setText(flower.getName());
    ImageView imageView = (ImageView) view.findViewById(R.id.img);
    Picasso.with(getContext()).load(url + flower.getPhoto()).resize(100, 100).into(imageView);
    return view;
  }
}
