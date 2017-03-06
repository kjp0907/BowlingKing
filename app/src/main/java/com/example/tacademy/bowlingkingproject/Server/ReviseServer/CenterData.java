package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class CenterData {
    int centerId; //1
    String centerName; //"제이앤제이볼링센터"
    String centerCityAddr; //"서울특별시 관악구"
    String centerDetailAddr; //"신림동 1422-5 르네상스쇼핑몰 4층"
    CenterLocation centerLocation;
    float distance; //18.36 // 현 위치와 볼링장 과의 거리(km)

    @Override
    public String toString() {
        return "CenterData{" +
                "centerId=" + centerId +
                ", centerName='" + centerName + '\'' +
                ", centerCityAddr='" + centerCityAddr + '\'' +
                ", centerDetailAddr='" + centerDetailAddr + '\'' +
                ", centerLocation=" + centerLocation +
                ", distance=" + distance +
                '}';
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCityAddr() {
        return centerCityAddr;
    }

    public void setCenterCityAddr(String centerCityAddr) {
        this.centerCityAddr = centerCityAddr;
    }

    public String getCenterDetailAddr() {
        return centerDetailAddr;
    }

    public void setCenterDetailAddr(String centerDetailAddr) {
        this.centerDetailAddr = centerDetailAddr;
    }

    public CenterLocation getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(CenterLocation centerLocation) {
        this.centerLocation = centerLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
