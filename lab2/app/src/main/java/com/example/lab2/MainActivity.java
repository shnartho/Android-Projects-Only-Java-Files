package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.BottomBarId);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                if(item.getItemId()==R.id.leftId){
                    fragment = new ActivityLeft();
                }

                if(item.getItemId()==R.id.centerId){
                    fragment = new ActivityCenter();
                }

                if(item.getItemId()==R.id.rightId){
                    Intent iadf = new Intent(MainActivity.this,ActivityRight.class);

                    // fragment = new ActivityRight();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.FrameViewId,fragment).commit();

                return false;
            }
        });

    }
}