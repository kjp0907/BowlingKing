package com.example.tacademy.bowlingkingproject.model.user;

import java.io.Serializable;

//회원 가입시 사용되는 테이블 모델
//dB기반이라 테이블 가져와서 때려놓고 해야되는데 없으니까
public class UserInfoVo implements Serializable { //네임의 정보를 보내기 위하여 implements serializable
    //기본 정보
    String joinUserId; //dB 테이블의 컬럼명이랑 동일해야됨
    String joinUserPassword;
    String joinUserEmail; // 여기까지는 가시적으로 받는 정보
    String joinUserNickName;
    //백단 정보
    String token; // push 때려야 되니까
    String uuId;
    String os_version; //os 버전
    String device; //제품명
    // 이 정보를 은닉해야 되니까

    //code 제너레이트 constructor 디폴트로 한개, 전체다 한개
    public UserInfoVo() {
    }
    //이건 전체다 컨스트럭터

    public UserInfoVo(String joinUserId, String joinUserPassword, String joinUserEmail, String joinUserNickName, String token, String uuId, String os_version, String device) {
        this.joinUserId = joinUserId;
        this.joinUserPassword = joinUserPassword;
        this.joinUserEmail = joinUserEmail;
        this.joinUserNickName = joinUserNickName;
        this.token = token;
        this.uuId = uuId;
        this.os_version = os_version;
        this.device = device;
    }


    //코드 제너레이터 getter setter 전체다

    public String getJoinUserId() {
        return joinUserId;
    }

    public void setJoinUserId(String joinUserName) {
        this.joinUserId = joinUserName;
    }

    public String getJoinUserPassword() {
        return joinUserPassword;
    }

    public void setJoinUserPassword(String joinUserPassword) {
        this.joinUserPassword = joinUserPassword;
    }

    public String getJoinUserEmail() {
        return joinUserEmail;
    }

    public void setJoinUserEmail(String joinUserEmail) {
        this.joinUserEmail = joinUserEmail;
    }

    public String getJoinUserNickName() {
        return joinUserNickName;
    }

    public void setJoinUserNickName(String joinUserNickName) {
        this.joinUserNickName = joinUserNickName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }


    //코드 제너레이터 스트링

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "joinUserName='" + joinUserId + '\'' +
                ", joinUserPassword='" + joinUserPassword + '\'' +
                ", joinUserEmail='" + joinUserEmail + '\'' +
                ", joinUserNickName='" + joinUserNickName + '\'' +
                ", token='" + token + '\'' +
                ", uuId='" + uuId + '\'' +
                ", os_version='" + os_version + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}