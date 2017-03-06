package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class AllRecordScore {
    int totalScore; //3 // 전체 경기 수
    int totalPage; //2 // 전체 페이지 수
    int currentPage; //1 // 현재 페이지 수
    ArrayList<AllRecordScoreData> data;

    public AllRecordScore(int totalScore, int totalPage, int currentPage, ArrayList<AllRecordScoreData> data) {
        this.totalScore = totalScore;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.data = data;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<AllRecordScoreData> getData() {
        return data;
    }

    public void setData(ArrayList<AllRecordScoreData> data) {
        this.data = data;
    }
}
