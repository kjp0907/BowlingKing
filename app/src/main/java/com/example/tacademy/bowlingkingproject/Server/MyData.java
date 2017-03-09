package com.example.tacademy.bowlingkingproject.Server;

/**
 * Created by Tacademy on 2017-02-27.
 */

public class MyData {
    String isData;
    String score_id;
    String bestScore;
    String playDate;
    String centerName;
    String pic;
    String myRank;
    String myNick;

    public String getMyNick() {
        return myNick;
    }

    public void setMyNick(String myNick) {
        this.myNick = myNick;
    }

    public MyData(String isData, String score_id, String bestScore, String playDate, String centerName, String pic, String myRank, String myNick) {

        this.isData = isData;
        this.score_id = score_id;
        this.bestScore = bestScore;
        this.playDate = playDate;
        this.centerName = centerName;
        this.pic = pic;
        this.myRank = myRank;
        this.myNick = myNick;
    }

    public String getBestScore() {
        return bestScore;
    }

    public void setBestScore(String bestScore) {
        this.bestScore = bestScore;
    }

    public String getScore_id() {
        return score_id;
    }

    public void setScore_id(String score_id) {
        this.score_id = score_id;
    }

    public String getIsData() {
        return isData;
    }

    public void setIsData(String isData) {
        this.isData = isData;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getMyRank() {
        return myRank;
    }

    public void setMyRank(String myRank) {
        this.myRank = myRank;
    }
}
