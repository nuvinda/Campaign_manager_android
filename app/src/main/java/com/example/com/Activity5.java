package com.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity5 extends AppCompatActivity {

    public void toActivity3(View v) { startActivity(new Intent(this, Activity3.class)); }

    public void toActivity6(View v) {
        startActivity(new Intent(this, Activity6.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.donors);

        //perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.map:
                        startActivity(new Intent(getApplicationContext()
                                ,MapsActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,Activity3.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.donors:
                        return true;
                }
                return false;
            }
        });
    }
}