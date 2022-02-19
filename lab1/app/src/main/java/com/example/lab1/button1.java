package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class button1 extends AppCompatActivity {


    public void next(View view){
        ImageView img1 = (ImageView) findViewById(R.id.img1);
        img1.setImageResource(R.drawable.img2);
    }



    private RadioGroup radioGroup;
    private Button button;
    private RadioButton gender;
    private TextView resulttextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);


        radioGroup = (RadioGroup) findViewById(R.id.radioid);
        button = (Button) findViewById(R.id.showbutton);
        resulttextview = (TextView) findViewById(R.id.resultid);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int selected = radioGroup.getCheckedRadioButtonId();
                gender = (RadioButton) findViewById(selected);
                String value = gender.getText().toString();
                resulttextview.setText("You have selected: "+value);
            }
        });
    }
}