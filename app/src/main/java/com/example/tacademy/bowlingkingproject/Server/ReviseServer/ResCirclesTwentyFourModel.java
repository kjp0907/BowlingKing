package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ResCirclesTwentyFourModel {
    int code;
    String message;
    int totalPage;
    String currentPage;
    String rowsPerPage;
    NoticeData noticeData;
    ArrayList<ArticleData> articleData;

    public ResCirclesTwentyFourModel(int code, String message, int totalPage, String currentPage, String rowsPerPage, NoticeData noticeData, ArrayList<ArticleData> articleData) {
        this.code = code;
        this.message = message;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.rowsPerPage = rowsPerPage;
        this.noticeData = noticeData;
        this.articleData = articleData;
    }

    @Override
    public String toString() {
        return "ResCirclesTwentyFourModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", totalPage=" + totalPage +
                ", currentPage='" + currentPage + '\'' +
                ", rowsPerPage='" + rowsPerPage + '\'' +
                ", noticeData=" + noticeData +
                ", articleData=" + articleData +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(String rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public NoticeData getNoticeData() {
        return noticeData;
    }

    public void setNoticeData(NoticeData noticeData) {
        this.noticeData = noticeData;
    }

    public ArrayList<ArticleData> getArticleData() {
        return articleData;
    }

    public void setArticleData(ArrayList<ArticleData> articleData) {
        this.articleData = articleData;
    }
}
