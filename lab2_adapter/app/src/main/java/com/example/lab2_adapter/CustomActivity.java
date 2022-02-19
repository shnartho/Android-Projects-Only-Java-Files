package com.example.lab2_adapter;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_adapter.custom.CustomAdapter;

public class CustomActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        String[] some_array = getResources().getStringArray(R.array.Countries);
        String[] some_array2 = getResources().getStringArray(R.array.Initial);
        CustomAdapter a = new CustomAdapter(some_array2,some_array,this);
        listView= findViewById(R.id.custom);
        listView.setAdapter(a);
    }

}