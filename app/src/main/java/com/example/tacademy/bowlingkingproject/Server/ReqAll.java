package com.example.tacademy.bowlingkingproject.Server;

/**
 * Created by Tacademy on 2017-02-20.
 */

public class ReqAll
{
    String user_id;     // : 회원 ID
    String user_name;   // : 회원 닉네임
    String user_email;  // : 회원 이메일
    String password;    // : 비밀번호
//
//    public ReqAll() {
//    }
//
//    public ReqAll(String user_id, String user_name, String user_email, String password) {
//        this.user_id = user_id;
//        this.user_name = user_name;
//        this.user_email = user_email;
//        this.password = password;
//    }

    public ReqAll(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
