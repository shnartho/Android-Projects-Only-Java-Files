package com.example.lab2_adapter.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.lab2_adapter.R;

public class GridImageAdapter extends BaseAdapter {
    private Context ctx;

    public Integer[] images={
            R.drawable.taka1,R.drawable.taka2,R.drawable.taka3,
            R.drawable.taka4,R.drawable.taka5,R.drawable.taka6,
            R.drawable.taka7,R.drawable.taka8,R.drawable.taka9

    };
    public GridImageAdapter(Context c) {
        ctx = c;
    }

    @Override
    public int getCount() {
        return images.length;
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
        ImageView i;
        if(convertView == null) {
            i = new ImageView(ctx);
            i.setLayoutParams(new ViewGroup.LayoutParams(200,200));
            i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            i.setPadding(8,8,8,8);
        } else {
            i = (ImageView) convertView;
        }

        i.setImageResource(images[position]);

        return i;
    }
}
