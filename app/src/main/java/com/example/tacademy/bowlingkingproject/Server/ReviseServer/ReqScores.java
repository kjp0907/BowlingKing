package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ReqScores {
    int center_id;
    int score_num;
    String score_pic;


    public ReqScores(int center_id, int score_num, String score_pic) {
        this.center_id = center_id;
        this.score_num = score_num;
        this.score_pic = score_pic;
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
}
