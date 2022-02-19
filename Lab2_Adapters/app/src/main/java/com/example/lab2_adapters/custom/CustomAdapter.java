package com.example.lab2_adapters.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2_adapters.R;

class Item{
    TextView t1;
    TextView t2;
    ImageView i;
    CheckBox c;
}
public class CustomAdapter extends BaseAdapter {

    String[] titles;
    String[] subtitles;
    boolean[] checked;
    LayoutInflater inflater=null;
    Context context;
    public CustomAdapter(String[] titles, String[] subtitles, Context ctx){
        this.subtitles=subtitles;
        this.titles=titles;
        this.checked= new boolean[titles.length];
        inflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context=ctx;

    }
    @Override
    public int getCount() {
        return titles.length;
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
        Item item= new Item();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_row,null);
            item.c =(CheckBox) convertView.findViewById(R.id.row_checkbox);
            item.t1=(TextView) convertView.findViewById(R.id.row_title);
            item.t2=(TextView) convertView.findViewById(R.id.row_subtitle);
            item.i=(ImageView) convertView.findViewById(R.id.row_image);
            convertView.setTag(item);
        }else{
            item= (Item) convertView.getTag();
        }
        item.t1.setText(titles[position]);
        item.t2.setText(subtitles[position]);
        item.c.setChecked(checked[position]);
        item.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked[position] = ((CheckBox) v).isChecked();
                Toast.makeText(context, "CheckBox clicked", Toast.LENGTH_SHORT).show();

            }
        });
        return convertView;
    }
}
