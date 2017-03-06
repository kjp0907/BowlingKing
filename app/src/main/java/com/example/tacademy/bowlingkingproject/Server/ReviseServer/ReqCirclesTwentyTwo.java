package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ReqCirclesTwentyTwo {
    String circle_name;
    String circle_detail;
    String circle_cordi;

    public ReqCirclesTwentyTwo(String circle_name, String circle_detail, String circle_cordi) {
        this.circle_name = circle_name;
        this.circle_detail = circle_detail;
        this.circle_cordi = circle_cordi;
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

    public String getCircle_cordi() {
        return circle_cordi;
    }

    public void setCircle_cordi(String circle_cordi) {
        this.circle_cordi = circle_cordi;
    }
}
