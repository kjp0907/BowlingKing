package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

public class AllRecordScoreData {
    int playScore; //92 // 볼링 경기 점수
    int scoreId; //208 // 볼링 경기 번호(인덱스)
    String playDate;//"2017/02/12 18:20:00" // 점수 등록 일시(UTC+9)
    String playPlaceName;//"한숲볼링센타" // 볼링장 이름
    int playPlaceId;//8 // 볼링장 번호
    String pic; //"https://bowlingking27.s3.ap-northeast-2.amazonaws.com/scores_pic/92.jpg" //볼링 경기 점수 사진

    @Override
    public String toString() {
        return "AllRecordScoreData{" +
                "pic='" + pic + '\'' +
                ", playPlaceId=" + playPlaceId +
                ", playPlaceName='" + playPlaceName + '\'' +
                ", playDate='" + playDate + '\'' +
                ", scoreId=" + scoreId +
                ", playScore=" + playScore +
                '}';
    }

    public int getPlayScore() {
        return playScore;
    }

    public void setPlayScore(int playScore) {
        this.playScore = playScore;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public String getPlayPlaceName() {
        return playPlaceName;
    }

    public void setPlayPlaceName(String playPlaceName) {
        this.playPlaceName = playPlaceName;
    }

    public int getPlayPlaceId() {
        return playPlaceId;
    }

    public void setPlayPlaceId(int playPlaceId) {
        this.playPlaceId = playPlaceId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}