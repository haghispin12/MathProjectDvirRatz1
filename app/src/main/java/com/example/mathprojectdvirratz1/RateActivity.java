package com.example.mathprojectdvirratz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class RateActivity extends AppCompatActivity {

    Button save_Rate;
    SeekBar diroog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        diroog=findViewById(R.id.diroog);
        save_Rate=findViewById(R.id.save_Rate);

        save_Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inn = new Intent();
                inn.putExtra("End",  diroog.getProgress());
                setResult(RESULT_OK,inn);
                finish();
            }
        });

    }



}