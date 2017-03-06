package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ResCirclesListSearchModel {
    int code;
    String message;
    ArrayList<ArrayCircleData> circleData;

    public ResCirclesListSearchModel(int code, String message, ArrayList<ArrayCircleData> circleData) {
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

    public ArrayList<ArrayCircleData> getCircleData() {
        return circleData;
    }

    public void setCircleData(ArrayList<ArrayCircleData> circleData) {
        this.circleData = circleData;
    }
}
