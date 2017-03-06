package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ResCentersModel {
    int code;
    String message;
    ArrayList<CenterData> centerData;

    public ResCentersModel(int code, String message, ArrayList<CenterData> centerData) {
        this.code = code;
        this.message = message;
        this.centerData = centerData;
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

    public ArrayList<CenterData> getCenterData() {
        return centerData;
    }

    public void setCenterData(ArrayList<CenterData> centerData) {
        this.centerData = centerData;
    }
}
