package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ResCirclesSearchModel {
    int code;
    String message;
    CircleData circleData;

    public ResCirclesSearchModel(){

    }

    public ResCirclesSearchModel(int code, String message, CircleData circleData) {
        this.code = code;
        this.message = message;
        this.circleData = circleData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CircleData getCircleData() {
        return circleData;
    }

    public void setCircleData(CircleData circleData) {
        this.circleData = circleData;
    }
}
