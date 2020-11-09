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


public class Activity3 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    public void toActivity4(View v) {
        startActivity(new Intent(this, Activity4.class));
    }

    public void toMapsActivity(View v) {
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void toActivity5(View v) {
        startActivity(new Intent(this, Activity5.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Button btn = (Button) findViewById(R.id.btnShow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Activity3.this, v);
                popup.setOnMenuItemClickListener(Activity3.this);
                popup.inflate(R.menu.popup_menu);
                popup.show();
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
                                ,Activity5.class));
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
                Intent myintent1 = new Intent(Activity3.this, EditProfileActivity.class);
                startActivity(myintent1);
                return false;

            case R.id.notifications:
                // do your code
                return true;

            case R.id.log_out:
                Intent myintent2 = new Intent(Activity3.this, MainActivity.class);
                startActivity(myintent2);
                return false;

            default:
                return false;
        }
    }

}