package com.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Activity7 extends AppCompatActivity {

    public void toActivity6(View v) {
        startActivity(new Intent(this, Activity6.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);


        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Eligible", "Temporarily Ineligible", "Permenantly Ineligible"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);
    }
}