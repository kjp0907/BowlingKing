package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ReqCirclesTwentyThree {
    String article_context;
    int article_notice; //공지 할건지말건지 0 : 공지x , 1: 공지 o 최근이 위로가도록

    public ReqCirclesTwentyThree(String article_context, int article_notice) {
        this.article_context = article_context;
        this.article_notice = article_notice;
    }

    public String getArticle_context() {
        return article_context;
    }

    public void setArticle_context(String article_context) {
        this.article_context = article_context;
    }

    public int getArticle_notice() {
        return article_notice;
    }

    public void setArticle_notice(int article_notice) {
        this.article_notice = article_notice;
    }
}
