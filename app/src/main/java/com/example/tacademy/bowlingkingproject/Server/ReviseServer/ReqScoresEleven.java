package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ReqScoresEleven {
    int center_id;
    int score_num;
    String score_pic;
    String play_date;

    public ReqScoresEleven(int center_id, int score_num, String score_pic, String play_date) {
        this.center_id = center_id;
        this.score_num = score_num;
        this.score_pic = score_pic;
        this.play_date = play_date;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public int getScore_num() {
        return score_num;
    }

    public void setScore_num(int score_num) {
        this.score_num = score_num;
    }

    public String getScore_pic() {
        return score_pic;
    }

    public void setScore_pic(String score_pic) {
        this.score_pic = score_pic;
    }

    public String getPlay_date() {
        return play_date;
    }

    public void setPlay_date(String play_date) {
        this.play_date = play_date;
    }
}
