package com.example.tacademy.bowlingkingproject.TabPager.frag;

import java.util.ArrayList;

public class ExpandMyGroup {
    public ArrayList<String> child;
    public String groupName;
    public int score;
    public String mydateself;


    public ExpandMyGroup(String groupName, String mydateself, int score) {
        this.groupName = groupName;
        this.mydateself = mydateself;
        this.score = score;
    }

    public String getMydateself() {
        return mydateself;
    }

    public void setMydateself(String mydateself) {
        this.mydateself = mydateself;
    }

    public ArrayList<String> getChild() {
        return child;
    }

    public void setChild(ArrayList<String> child) {
        this.child = child;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}