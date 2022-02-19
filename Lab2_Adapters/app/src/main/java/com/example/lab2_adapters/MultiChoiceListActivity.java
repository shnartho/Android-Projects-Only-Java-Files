package com.example.lab2_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MultiChoiceListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_choice_list);
        String[] some_array = getResources().getStringArray(R.array.Fruits);
        ArrayAdapter<String> array = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, some_array);
        listView = (ListView) findViewById(R.id.multi_list);
        listView.setAdapter(array);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s ="Bought: ";
                SparseBooleanArray checked = ((ListView)findViewById(R.id.multi_list)).getCheckedItemPositions();
                for (int k = 0; k < checked.size(); ++k) {
                    if(checked.get(k)){
                        s =s+ some_array[k]+", ";
                    }
                }
                getIntent().putExtra("RESULT",s);
                setResult(1,getIntent());
                Toast.makeText(MultiChoiceListActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

