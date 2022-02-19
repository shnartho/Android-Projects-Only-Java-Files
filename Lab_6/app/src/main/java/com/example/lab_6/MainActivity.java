package com.example.lab_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements onOptionChecked {

    DynamicFragment1 f1 = new DynamicFragment1();
    DynamicFragment2 f2 = new DynamicFragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onOptionChecked(int id) {
           Fragment f;
           if (id == R.id.showF1) {
             f = f1;
           }else {
               f = f2;
           }

           FragmentManager fm = getSupportFragmentManager();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.fragment_container, f);

           ft.commit();
    }

}