package com.example.lab2_adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSimplelist(View v){
        Intent intent = new Intent();
        intent.setClass(this, SimpleListActivity.class);
        startActivity(intent);

    }

    public void openMultilist(View v) {
        Intent intent = new Intent();
        intent.setClass(this, MultichoiceListActivity.class);
        startActivityForResult(intent, 0);

    }

    public void openGrid(View v) {
        Intent intent = new Intent();
        intent.setClass(this, GridActivity.class);

        startActivity(intent);
    }


    public void openCustomlist(View v){
        Intent i = new Intent();
        i.setClass(this, CustomActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 0) {
            Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, data.getStringExtra("RESULT"), Toast.LENGTH_SHORT).show();
        }
    }
}