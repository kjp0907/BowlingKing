package com.example.tacademy.bowlingkingproject.Server;

/**
 * Created by Tacademy on 2017-02-23.
 */

public class UserData
{
    String userId;//” : “회원 id”,
    String userName;//” : “회원 닉네임”,
    String userPic;//” : “회원 사진”,
    String userEmail;//” : “회원 이메일”,
    String userCircle;//” : “회원의 동호회”,
    String bestScore;//” : “최고점수”,
    String countGame;//” : “기록 누적 수”

    @Override
    public String toString() {
        return "UserData{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPic='" + userPic + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userCircle='" + userCircle + '\'' +
                ", bestScore='" + bestScore + '\'' +
                ", countGame='" + countGame + '\'' +
                '}';
    }

    public String getBestScore() {
        return bestScore;
    }

    public void setBestScore(String bestScore) {
        this.bestScore = bestScore;
    }

    public String getCountGame() {
        return countGame;
    }

    public void setCountGame(String countGame) {
        this.countGame = countGame;
    }

    public String getUserCircle() {
        return userCircle;
    }

    public void setUserCircle(String userCircle) {
        this.userCircle = userCircle;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
}
