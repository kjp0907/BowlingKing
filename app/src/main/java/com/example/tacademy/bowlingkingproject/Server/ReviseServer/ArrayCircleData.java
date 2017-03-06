package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ArrayCircleData {
    int circleId; //2
    String circleName; //"별별동호회"
    String circleDetail; //"여기는 별별 동호회~"
    String circleCordi; // "회장닉넴"
    int MemberNum; //123

    @Override
    public String toString() {
        return "ArrayCircleData{" +
                "circleId=" + circleId +
                ", circleName='" + circleName + '\'' +
                ", circleDetail='" + circleDetail + '\'' +
                ", circleCordi='" + circleCordi + '\'' +
                ", MemberNum=" + MemberNum +
                '}';
    }

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getCircleDetail() {
        return circleDetail;
    }

    public void setCircleDetail(String circleDetail) {
        this.circleDetail = circleDetail;
    }

    public String getCircleCordi() {
        return circleCordi;
    }

    public void setCircleCordi(String circleCordi) {
        this.circleCordi = circleCordi;
    }

    public int getMemberNum() {
        return MemberNum;
    }

    public void setMemberNum(int memberNum) {
        MemberNum = memberNum;
    }
}
