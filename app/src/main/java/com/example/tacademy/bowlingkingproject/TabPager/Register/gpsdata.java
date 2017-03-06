package com.example.tacademy.bowlingkingproject.TabPager.Register;

/**
 * Created by Tacademy on 2017-02-19.
 */

public class gpsdata {

    double latitude,longitude;

    @Override
    public String toString() {
        return "gpsdata{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public gpsdata() {
    }

    public gpsdata(double latitude, double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
