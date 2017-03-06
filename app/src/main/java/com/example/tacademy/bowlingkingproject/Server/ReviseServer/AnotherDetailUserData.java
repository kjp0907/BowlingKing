package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class AnotherDetailUserData {
    int userIndex; //47 // 검색한 글자와 비슷한 닉네임의 회원 index
    String userId; //aphenomenon" // 회원 ID
    String userName; //다올 // 회원 닉네임 (uname을 ‘다’로 검색한 경우)

    @Override
    public String toString() {
        return "AnotherDetailUserData{" +
                "userIndex=" + userIndex +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public int getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(int userIndex) {
        this.userIndex = userIndex;
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
}
