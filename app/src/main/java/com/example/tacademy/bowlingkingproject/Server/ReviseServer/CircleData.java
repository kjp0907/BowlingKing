package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class CircleData {
    int circleId; //동호회 번호
    String circleName; //동호회 이름
    String circleDetail; //동호회 설명
    String circleCordi; //동호회 회장
    int MemberNum; //멤버 수
    ArrayList<CircleMembers> circleMembers;

    @Override
    public String toString() {
        return "CircleData{" +
                "circleId=" + circleId +
                ", circleName='" + circleName + '\'' +
                ", circleDetail='" + circleDetail + '\'' +
                ", circleCordi='" + circleCordi + '\'' +
                ", MemberNum=" + MemberNum +
                ", circleMembers=" + circleMembers +
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

    public ArrayList<CircleMembers> getCircleMembers() {
        return circleMembers;
    }

    public void setCircleMembers(ArrayList<CircleMembers> circleMembers) {
        this.circleMembers = circleMembers;
    }
}
