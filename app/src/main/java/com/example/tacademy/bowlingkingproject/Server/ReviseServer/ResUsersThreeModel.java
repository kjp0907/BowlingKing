package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ResUsersThreeModel {
    int code;
    String message;
    int userIndex;

    public ResUsersThreeModel(int code, String message, int userIndex) {
        this.code = code;
        this.message = message;
        this.userIndex = userIndex;
    }

    @Override
    public String toString() {
        return "ResUsersThreeModel{" +
                "userIndex=" + userIndex +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
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

    public int getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(int userIndex) {
        this.userIndex = userIndex;
    }
}
