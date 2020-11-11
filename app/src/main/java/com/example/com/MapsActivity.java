package com.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.google_map);
        supportMapFragment.getMapAsync(this);

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.map);

        //perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.map:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , campaignManHome.class));
                        overridePendingTransition(0,0);
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
    public void onMapReady(GoogleMap googleMap) {

        //Assign variable
        gMap = googleMap;

//        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                //creating marker
//                MarkerOptions markerOptions = new MarkerOptions();
//                //set marker position
//                markerOptions.position(latLng);
//                //set latitude and longitude on marker
//                markerOptions.title(latLng.latitude+ " : "+latLng.longitude);
//                //clear the previously clicked position
//                gMap.clear();
//                //zoom the marker
//                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
//                //add marker on the map
//                gMap.addMarker(markerOptions);
//            }
//        });

        LatLng ucsc = new LatLng(6.9022, 79.8612);
        gMap.addMarker(new MarkerOptions().position(ucsc).title("Blood Drive 1").snippet("Status: Ongoing Time: 8am-5pm Contact Deatails: Thamal -0782224214"));
        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ucsc,16));
    }



}