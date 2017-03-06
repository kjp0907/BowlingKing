package com.example.tacademy.bowlingkingproject.Server;

/**
 * Created by Tacademy on 2017-02-27.
 */

public class ConData {

    String rankNum;
    String playScore;
    String playDate;
    String userIndex;
    String userName;
    String centerId;
    String centerName;
    String circleId;
    String circleName;
    String pic;


    public ConData(String rankNum, String playScore, String playDate, String userIndex, String userName, String centerId, String centerName, String circleId, String circleName, String pic) {
        this.rankNum = rankNum;
        this.playScore = playScore;
        this.playDate = playDate;
        this.userIndex = userIndex;
        this.userName = userName;
        this.centerId = centerId;
        this.centerName = centerName;
        this.circleId = circleId;
        this.circleName = circleName;
        this.pic = pic;
    }

    public String getRankNum() {
        return rankNum;
    }

    public void setRankNum(String rankNum) {
        this.rankNum = rankNum;
    }

    public String getPlayScore() {
        return playScore;
    }

    public void setPlayScore(String playScore) {
        this.playScore = playScore;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public String getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(String userIndex) {
        this.userIndex = userIndex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
