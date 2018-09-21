package com.mist.edu.deaf2riend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class flashalert extends AppCompatActivity {

    ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashalert);


        home=(ImageView) findViewById(R.id.imageView);
        home.setClickable(true);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(flashalert.this,activate.class);
                startActivity(i);
            }
        });
    }}
