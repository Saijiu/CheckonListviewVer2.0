package com.moi.showstateapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
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

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resouceId, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv_item);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv_item);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (position == Postion.getInstance().getPostion()) {
            view.setBackgroundColor(view.getResources().getColor(R.color.gray));
            viewHolder.textView.setTextColor(view.getResources().getColor(R.color.white));
            viewHolder.textView.setText(viewHolder.textView.getText().toString() + "              Choose uncheck");
            viewHolder.imageView.setImageResource(item.getImageId());
            viewHolder.imageView.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.SRC_IN);
        } else {
            if (convertView != null) {
                convertView.setBackground(null);
                viewHolder = (ViewHolder) convertView.getTag();
                viewHolder.textView.setText(item.getText());
                viewHolder.textView.setTextColor(view.getResources().getColor(R.color.gray));
                viewHolder.imageView.clearColorFilter();
            } else {
                viewHolder.imageView.setImageResource(item.getImageId());
                viewHolder.textView.setText(item.getText());
            }
        }
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}