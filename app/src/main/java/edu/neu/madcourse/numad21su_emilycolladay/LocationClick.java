package edu.neu.madcourse.numad21su_emilycolladay;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LocationClick extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
    Handler handler;
    String locationText = "";
    String locationLatitude = "";
    String locationLongitude = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_main);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                start();
            }
        }, 2000); //2 seconds

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }

    }

    @Override public void onDestroy() {
        super.onDestroy(); stop(); }


    Runnable mStatusChecker = new Runnable() {
        @Override public void run() {
            final TextView yourlat = (TextView) findViewById(R.id.latitude);
            final TextView yourlong = (TextView) findViewById(R.id.longitude);

            try { getLocation();
                if (locationText.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fetching coordinates...",
                            Toast.LENGTH_LONG).show();
                } else {
                    yourlat.setText("Latitude: " + locationLatitude.toString());
                    yourlong.setText("Longitude: " + locationLongitude.toString());
                }
            }
            finally {
                handler.postDelayed(mStatusChecker, 2000);
            }
        }
    };


    void start() {
        mStatusChecker.run();
    }

    void stop() {
        handler.removeCallbacks(mStatusChecker);
    }


    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    1000, 5, (LocationListener) this);
        } catch(SecurityException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        locationText = location.getLatitude() + "," + location.getLongitude();
        locationLatitude = location.getLatitude() + "";
        locationLongitude = location.getLongitude() + "";
    }

    @Override public void onProviderDisabled(String provider) {
        Toast.makeText(LocationClick.this, "Please Enable GPS",
                Toast.LENGTH_SHORT).show(); }
}
