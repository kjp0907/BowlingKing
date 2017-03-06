package com.example.tacademy.bowlingkingproject.TabPager.model;

/**
 * Created by Tacademy on 2017-02-03.
 */

public class user {


    String id;
    String password;
    String email;
    String nickname;

    public user() {
    }

    public user(String id, String password, String email, String nickname) {

        this.email = email;
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
