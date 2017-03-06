package com.example.tacademy.bowlingkingproject.TabPager.model;

//댓글을 담는 그릇

public class Comment {
    String uid,commentpost;


    public Comment() {
    }

    public Comment(String commentpost, String uid) {

        this.commentpost = commentpost;
        this.uid = uid;
    }

    public String getCommentpost() {

        return commentpost;
    }

    public void setCommentpost(String commentpost) {
        this.commentpost = commentpost;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
