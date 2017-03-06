package com.example.tacademy.bowlingkingproject.TabPager.Register;

/**
 * Created by Tacademy on 2017-02-19.
 */
public class gps {
    private static gps ourInstance = new gps();

    public static gps getInstance() {
        return ourInstance;
    }

    private gps() {
    }

    public gpsdata gpsdata = new gpsdata();


    /*public gpsdata currentlocation( double latitude, double longitude){

        gpsdata gpsdata = new gpsdata();

        gpsdata.setLatitude(latitude);
        gpsdata.setLongitude(longitude);

        return gpsdata;
    }*/




}
