package com.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class campaigns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaigns);

        Button button1 = findViewById(R.id.button1);
    Button button2 = findViewById(R.id.button2);
    Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            func1();
        }
    });
        button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            func2();
        }
    });
        button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            func3();
        }
    });

    BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

    //set home selected
        bottomNavigationView.setSelectedItemId(R.id.campaigns);

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
                            ,campaignManHome.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.donors:
                    startActivity(new Intent(getApplicationContext()
                            , donors.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.campaigns:
                    return true;
            }
            return false;
        }
    });
}


    public void func1() {
        Intent intent = new Intent(this, allCampaigns.class);
        startActivity(intent);

    }

    public void func2() {
        Intent intent = new Intent(this, myCampaigns.class);
        startActivity(intent);

    }

    public void func3() {
        Intent intent = new Intent(this, addNewCampaign.class);
        startActivity(intent);

    }
}