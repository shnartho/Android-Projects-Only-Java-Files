package com.example.lab2_adapters.custom;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.lab2_adapters.R;

public class GridImageAdapter extends BaseAdapter {
    private Context ctx;

    public Integer[] images={
            R.drawable.i_2,R.drawable.i_3,R.drawable.i_1,
            R.drawable.i_1,R.drawable.i_2,R.drawable.i_3,
            R.drawable.i_3,R.drawable.i_2,R.drawable.i_1

    };

   public GridImageAdapter(Context c){
        ctx=c;
    }
    @Override
    public int getCount(){
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
        if(convertView == null){
            i = new ImageView(ctx);
            i.setLayoutParams(new ViewGroup.LayoutParams(200,200));
            i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            i.setPadding(8,8,8,8);
        }else{
            i= (ImageView) convertView;
        }
        i.setImageResource(images[position]);
        return i;
    }

}
