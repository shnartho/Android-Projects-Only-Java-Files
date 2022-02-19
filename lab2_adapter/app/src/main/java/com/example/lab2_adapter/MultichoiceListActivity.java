package com.example.lab2_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidException;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MultichoiceListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] items = {
            "item 1",
            "item 2",
            "item 3",
            "item 4",
            "item 5",
            "item 6",
            "item 7",
            "item 8",
            "item 9",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multichoice_list);
        setResult(0);

        ArrayAdapter<String> arr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice);
        arr.addAll(items);

        ListView lv = findViewById(R.id.multichoice_list_view);
        lv.setAdapter(arr);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String info = "Checked: ";
        SparseBooleanArray checked = ((ListView)findViewById(R.id.multichoice_list_view)).getCheckedItemPositions();

        for(int j=0; j<checked.size(); ++j){
            if(checked.get(j)){
                info = info + ", "+ items[j];
            }
        }
        getIntent().putExtra("RESULT",  info);
        setResult(i,getIntent());

        Toast.makeText(this, "info", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture){}


}