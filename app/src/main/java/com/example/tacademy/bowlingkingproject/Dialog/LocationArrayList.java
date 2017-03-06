package com.example.tacademy.bowlingkingproject.Dialog;

/**
 * Created by Tacademy on 2017-02-27.
 */

public class LocationArrayList {


    String alleyname;
    String distance;

    public LocationArrayList(String alleyname, String distance) {

        this.alleyname = alleyname;
        this.distance = distance;
    }

    public String getAlleyname() {
        return alleyname;
    }

    public void setAlleyname(String alleyname) {
        this.alleyname = alleyname;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
