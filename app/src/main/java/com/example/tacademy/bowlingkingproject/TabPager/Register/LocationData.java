package com.example.tacademy.bowlingkingproject.TabPager.Register;

/**
 * Created by Tacademy on 2017-03-06.
 */

public class LocationData {

    String centername;
    String distance;

    public LocationData(String centername, String distance) {
        this.centername = centername;
        this.distance = distance;
    }

    public String getCentername() {

        return centername;
    }

    public void setCentername(String centername) {
        this.centername = centername;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
