package com.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    public void toActivity3(View v) {
        startActivity(new Intent(this, Activity3.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

    }
}