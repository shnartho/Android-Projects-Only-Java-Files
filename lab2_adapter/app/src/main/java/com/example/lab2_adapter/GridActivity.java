package com.example.lab2_adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_adapter.custom.GridImageAdapter;

public class GridActivity extends AppCompatActivity {
    String[] list = {"Pos 1", "Pos 2", "Pos 3"};
    String[] texts = {"T1", "T2", "T3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridView view = (GridView) findViewById(R.id.grid_view);
        view.setAdapter(new GridImageAdapter(this));

        String arg1 = getIntent().getStringExtra("ARG1");
        Integer arg2 = getIntent().getIntExtra("ARG2",0);
        Toast.makeText(getApplicationContext(),arg1+arg2,Toast.LENGTH_SHORT).show();


        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected : " + texts[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Selected Nothing : ", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        a.addAll(list);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);
    }
}