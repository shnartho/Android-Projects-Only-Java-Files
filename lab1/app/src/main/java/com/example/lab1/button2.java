package com.example.lab1;

/*Main code is not working and crashing my app. so i put this normal code to run the app*/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class button2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);
    }
}

/*   Sir This code making a crush in my phone.


* import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class button2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate a button
        Button loginButton = (Button) findViewById(R.id.loginBtn);
        // perform click event on the button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello AbhiAndroid..!!!", Toast.LENGTH_LONG).show();  // display a toast message
            }
        });
    }


}
* */