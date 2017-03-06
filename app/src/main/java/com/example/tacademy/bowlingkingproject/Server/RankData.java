package com.example.tacademy.bowlingkingproject.Server;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-02-27.
 */

public class RankData {

    String totalScore;
    String totalPage;
    String currentPage;
    ArrayList<ConData> data;

    public RankData(String totalScore, String totalPage, String currentPage, ArrayList<ConData> data) {
        this.totalScore = totalScore;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.data = data;
    }

    public String getTotalScore() {

        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<ConData> getData() {
        return data;
    }

    public void setData(ArrayList<ConData> data) {
        this.data = data;
    }
}
