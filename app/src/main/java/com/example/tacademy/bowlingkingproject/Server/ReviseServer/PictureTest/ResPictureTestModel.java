package com.example.tacademy.bowlingkingproject.Server.ReviseServer.PictureTest;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ResPictureTestModel {
    int code;
    String message;
    String pic;

    public ResPictureTestModel(int code, String message, String pic) {
        this.code = code;
        this.message = message;
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "ResPictureTestModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", pic='" + pic + '\'' +
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
