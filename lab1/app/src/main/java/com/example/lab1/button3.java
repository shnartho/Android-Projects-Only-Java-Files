package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
public class button3 extends AppCompatActivity {
    public Button buttoon4;
    private Button buttoon5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3);

        buttoon4 = (Button) findViewById(R.id.btnback);
        buttoon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(button3.this, MainActivity.class);
                startActivity(intent4);
            }
        });

        buttoon5 = findViewById(R.id.longbutton);
        registerForContextMenu(buttoon5);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}