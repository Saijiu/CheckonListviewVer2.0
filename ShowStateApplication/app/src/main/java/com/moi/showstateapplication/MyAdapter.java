package com.moi.showstateapplication;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by moi on 2015/3/26.
 *
 */


public class MyAdapter extends ArrayAdapter<Item> {

    int resouceId;

    public MyAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        resouceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resouceId, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item);
        TextView textView = (TextView)view.findViewById(R.id.tv_item);
        imageView.setImageResource(item.getImageId());
        textView.setText(item.getText());
        if (position == Postion.getInstance().getPostion()) {
            view.setBackgroundColor(view.getResources().getColor(R.color.gray));
            textView.setTextColor(view.getResources().getColor(R.color.white));
            textView.setText(textView.getText().toString() + "              Choose uncheck");
            imageView.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.SRC_IN);
        }
        return view;
    }
}