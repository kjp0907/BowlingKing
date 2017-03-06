package com.example.tacademy.bowlingkingproject.Server;

/**
 * Created by Tacademy on 2017-02-20.
 */

public class ResModel
{
    int code;
    String message;
    UserData userData;

    MyData myData;

    RankData rankData;

    public RankData getRankData() {
        return rankData;
    }

    public void setRankData(RankData rankData) {
        this.rankData = rankData;
    }


    public MyData getMyData() {
        return myData;
    }

    public void setMyData(MyData myData) {
        this.myData = myData;
    }

    public ResModel() {
    }

    public ResModel(int code, String message) {
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

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
