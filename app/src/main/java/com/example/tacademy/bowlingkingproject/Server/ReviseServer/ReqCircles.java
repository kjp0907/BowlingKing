package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ReqCircles {
    String circle_name;
    String circle_detail;

    public ReqCircles(String circle_name, String circle_detail) {
        this.circle_name = circle_name;
        this.circle_detail = circle_detail;
    }

    public String getCircle_name() {
        return circle_name;
    }

    public void setCircle_name(String circle_name) {
        this.circle_name = circle_name;
    }

    public String getCircle_detail() {
        return circle_detail;
    }

    public void setCircle_detail(String circle_detail) {
        this.circle_detail = circle_detail;
    }
}
