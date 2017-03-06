package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ReqUsers {
    String user_id;
    String password;



    public ReqUsers(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
