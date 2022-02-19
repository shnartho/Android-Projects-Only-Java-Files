package com.example.lab2_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab2_adapters.custom.CustomAdapter;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        String[] some_array = getResources().getStringArray(R.array.Fruits);
        String[] some_array2 = getResources().getStringArray(R.array.Initials);
        CustomAdapter a = new CustomAdapter(some_array2,some_array,this);
        listView= findViewById(R.id.custom);
        listView.setAdapter(a);
    }

}