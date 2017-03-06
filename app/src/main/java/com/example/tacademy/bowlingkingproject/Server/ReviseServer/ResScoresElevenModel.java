package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ResScoresElevenModel {
    int code;
    String message;

    public ResScoresElevenModel(int code, String message) {
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
}
