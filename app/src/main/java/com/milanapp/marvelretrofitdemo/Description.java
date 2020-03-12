package com.milanapp.marvelretrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    TextView marvel_charecter_name,marvel_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        marvel_charecter_name = findViewById(R.id.charecter_name);
        marvel_desc = findViewById(R.id.marvel_desc);


        String name = getIntent().getExtras().getString("charecter_name");
        String bio = getIntent().getExtras().getString("bio");

        marvel_charecter_name.setText(name);
        marvel_desc.setText(bio);


    }
}
