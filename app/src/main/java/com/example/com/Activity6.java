package com.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity6 extends AppCompatActivity {

    public void toActivity8(View v) {
        startActivity(new Intent(this, Activity8.class));
    }

    public void toActivity9(View v) {
        startActivity(new Intent(this, Activity9.class));
    }

    public void toActivity5(View v) {
        startActivity(new Intent(this, Activity5.class));
    }

    public void toDonationsActivity(View v) {
        startActivity(new Intent(this, DonationsActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

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
                        startActivity(new Intent(getApplicationContext()
                                ,Activity5.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}