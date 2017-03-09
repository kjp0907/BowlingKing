package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class CircleMembers {
    //int MemberIndex; //멤버 Index
    String MemberIndex;
    String MemberId; //멤버 Id
    String MemberName; //멤버 닉네임
    String MemberBest;
    String MemberPic;
    //int MemberBest;


    public String getMemberPic() {
        return MemberPic;
    }

    public void setMemberPic(String memberPic) {
        MemberPic = memberPic;
    }

    @Override

    public String toString() {
        return "CircleMembers{" +
                "MemberIndex='" + MemberIndex + '\'' +
                ", MemberId='" + MemberId + '\'' +
                ", MemberName='" + MemberName + '\'' +
                ", MemberBest='" + MemberBest + '\'' +
                ", MemberPic='" + MemberPic + '\'' +
                '}';
    }

    public String getMemberIndex() {
        return MemberIndex;
    }

    public void setMemberIndex(String memberIndex) {
        MemberIndex = memberIndex;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public String getMemberBest() {
        return MemberBest;
    }

    public void setMemberBest(String memberBest) {
        MemberBest = memberBest;
    }
}
