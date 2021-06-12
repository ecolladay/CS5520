package edu.neu.madcourse.numad21su_emilycolladay;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class LocationClick extends AppCompatActivity {
    TextView myLat;
    TextView myLong;
    Button locator;
    private static final int REQUEST_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_main);

        myLat = findViewById(R.id.latitude);
        myLong = findViewById(R.id.longitude);

        locator = findViewById(R.id.locate);

        locator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission
                        .ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            LocationClick.this, new String[]{Manifest.permission
                                    .ACCESS_FINE_LOCATION},
                            REQUEST_PERMISSION);
                } else {
                    updateLocation();
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                updateLocation();
            } else {
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void updateLocation() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
            return;
        }
        LocationServices.getFusedLocationProviderClient(LocationClick.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(LocationClick.this)
                                .removeLocationUpdates(this);
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int latestLocationIndex = locationResult.getLocations().size() - 1;
                            myLat.setText("Latitude: "
                                    + locationResult.getLocations()
                                    .get(latestLocationIndex).getLatitude());
                            myLong.setText("Longitude: "
                                    + locationResult.getLocations()
                                    .get(latestLocationIndex).getLongitude());
                        }
                    }
                }, Looper.getMainLooper());


    }

}
