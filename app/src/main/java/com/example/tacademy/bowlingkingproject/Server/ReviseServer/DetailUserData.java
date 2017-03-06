package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class DetailUserData {
    String userId; //choiroom27
    String userName; //방긋방긋
    String userEmail; //choi_pink@naver.com
    String userPic; //null
    String userCircle; //볼사모
    int countGame; //3
    int bestScore; //227

    @Override
    public String toString() {
        return "DetailUserData{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPic='" + userPic + '\'' +
                ", userCircle='" + userCircle + '\'' +
                ", countGame=" + countGame +
                ", bestScore=" + bestScore +
                '}';
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserCircle() {
        return userCircle;
    }

    public void setUserCircle(String userCircle) {
        this.userCircle = userCircle;
    }

    public int getCountGame() {
        return countGame;
    }

    public void setCountGame(int countGame) {
        this.countGame = countGame;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}
