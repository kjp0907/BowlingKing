package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ResDetailModel {
    int code;
    String message;
    DetailUserData userData;

    public ResDetailModel(int code, String message) {
        this.code = code;
        this.message = message;
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

    public DetailUserData getUserData() {
        return userData;
    }

    public void setUserData(DetailUserData userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "ResDetailModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", userData=" + userData +
                '}';
    }
}
