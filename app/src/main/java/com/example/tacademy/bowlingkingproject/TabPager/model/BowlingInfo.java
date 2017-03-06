package com.example.tacademy.bowlingkingproject.TabPager.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tacademy on 2017-02-09.
 */
public class BowlingInfo {


    String location;
    String score;


    Map<String,Boolean> needs = new HashMap<>();


    public BowlingInfo(String location, String score) {
        this.location = location;
        this.score = score;
    }

    public BowlingInfo() {
    }
    public Map<String, Object> toInfoMap(){
        Map<String,Object> map = new HashMap<>();

        map.put("location",location);
        map.put("score",score);

        map.put("needs",needs);

        return map;

    }




    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Map<String, Boolean> getneeds() {
        return needs;
    }

    public void setneeds(Map<String, Boolean> stars) {
        this.needs = stars;
    }
}
