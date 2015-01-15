package com.krokowski.connectwx;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQApp;
import com.garmin.android.connectiq.IQDevice;

/**
 * Created by todd on 1/14/15.
 */
public class WeatherActivity extends Activity {

    private LocationManager locationManager;

    private IQDevice device;
    private IQApp app;

    ConnectIQ.ConnectIQListener listener = new ConnectIQ.ConnectIQListener() {
        @Override
        public void onSdkReady() {
                    
        }

        @Override
        public void onInitializeError(ConnectIQ.IQSdkErrorStatus iqSdkErrorStatus) {

        }

        @Override
        public void onSdkShutDown() {

        }
    };

    @Override
    public void onCreate(Bundle savedInstance){
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                sendToWxUpdateToGarmin(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    private void sendToWxUpdateToGarmin(Location location) {

    }
}