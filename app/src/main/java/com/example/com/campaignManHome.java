package com.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class campaignManHome extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_man_home);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(campaignManHome.this, v);
                popup.setOnMenuItemClickListener(campaignManHome.this);
                popup.inflate(R.menu.popup_menu);
                popup.show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewStocks();
            }
        });

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

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
                        return true;

                    case R.id.donors:
                        startActivity(new Intent(getApplicationContext()
                                , donors.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.campaigns:
                        startActivity(new Intent(getApplicationContext()
                                , campaigns.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {

            case R.id.edit_profile:
                Intent myintent1 = new Intent(campaignManHome.this, EditProfileActivity.class);
                startActivity(myintent1);
                return false;

            case R.id.notifications:
                return true;

            case R.id.log_out:
                Intent myintent2 = new Intent(campaignManHome.this, MainActivity.class);
                startActivity(myintent2);
                return false;

            default:
                return false;
        }
    }

    public void viewStocks() {
        Intent intent = new Intent(this, viewBloodStocks.class);
        startActivity(intent);
    }

}