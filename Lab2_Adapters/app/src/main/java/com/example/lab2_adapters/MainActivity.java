package com.example.lab2_adapters;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSimple(View v) {
        Intent i = new Intent();
        i.setClass(this, SimpleListActivity.class);
        startActivity(i);
    }

    public void openMulti(View v) {
        Intent i = new Intent();
        i.setClass(this, MultiChoiceListActivity.class);
        startActivityForResult(i, 0);

    }

    public void openGrid(View v) {
        Intent i = new Intent();
        i.setClass(this, GridActivity.class);
        i.putExtra("ARG1","VALUE1");
        i.putExtra("ARG2","2");

        startActivity(i);
    }

    public void openCustom(View v) {
        Intent i = new Intent();
        i.setClass(this, CustomListActivity.class);
        startActivity(i);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            Toast.makeText(this, "Nothing Seledted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "selected : " + data.getStringExtra("RESULT"), Toast.LENGTH_SHORT).show();
        }
    }
}