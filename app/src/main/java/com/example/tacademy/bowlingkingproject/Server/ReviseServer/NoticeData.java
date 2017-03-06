package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class NoticeData {
    int noticeMemIndex;
    String noticeMemId;
    String noticeMemName;
    String noticeContext;
    String noticeDate;

    @Override
    public String toString() {
        return "NoticeData{" +
                "noticeMemIndex=" + noticeMemIndex +
                ", noticeMemId='" + noticeMemId + '\'' +
                ", noticeMemName='" + noticeMemName + '\'' +
                ", noticeContext='" + noticeContext + '\'' +
                ", noticeDate='" + noticeDate + '\'' +
                '}';
    }

    public int getNoticeMemIndex() {
        return noticeMemIndex;
    }

    public void setNoticeMemIndex(int noticeMemIndex) {
        this.noticeMemIndex = noticeMemIndex;
    }

    public String getNoticeMemId() {
        return noticeMemId;
    }

    public void setNoticeMemId(String noticeMemId) {
        this.noticeMemId = noticeMemId;
    }

    public String getNoticeMemName() {
        return noticeMemName;
    }

    public void setNoticeMemName(String noticeMemName) {
        this.noticeMemName = noticeMemName;
    }

    public String getNoticeContext() {
        return noticeContext;
    }

    public void setNoticeContext(String noticeContext) {
        this.noticeContext = noticeContext;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }
}
