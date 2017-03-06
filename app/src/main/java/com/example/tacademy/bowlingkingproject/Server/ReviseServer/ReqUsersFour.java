package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ReqUsersFour {
    String user_name;
    String user_email;
    String password;
    String user_pic;

    public ReqUsersFour(String user_name, String user_email, String password, String user_pic) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.password = password;
        this.user_pic = user_pic;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic;
    }
}
