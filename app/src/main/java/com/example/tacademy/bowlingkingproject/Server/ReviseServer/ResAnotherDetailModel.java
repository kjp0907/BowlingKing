package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ResAnotherDetailModel {
    int code;
    String message;
    ArrayList<AnotherDetailUserData> userData;

    public ResAnotherDetailModel(int code, String message, ArrayList<AnotherDetailUserData> userData) {
        this.code = code;
        this.message = message;
        this.userData = userData;
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

    public ArrayList<AnotherDetailUserData> getUserData() {
        return userData;
    }

    public void setUserData(ArrayList<AnotherDetailUserData> userData) {
        this.userData = userData;
    }
}
