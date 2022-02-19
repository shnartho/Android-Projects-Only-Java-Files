package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public Button buttoon1;
    public Button buttoon2;
    public Button buttoon3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttoon1 = (Button) findViewById(R.id.btn1);
        buttoon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, button1.class);
                startActivity(intent1);
            }
        });
        buttoon2 = (Button) findViewById(R.id.btn2);
        buttoon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, button2.class);
                startActivity(intent2);
            }
        });
        buttoon3 = (Button) findViewById(R.id.btn3);
        buttoon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, button3.class);
                startActivity(intent3);
            }
        });

    }
}