package com.example.tacademy.bowlingkingproject.TabPager.totalRanking;

/**
 * Created by Tacademy on 2017-02-20.
 */


public class ClubArrayList {
    int ca_rank;
    int ca_score;
    String club_array_nickname;





    public ClubArrayList() {
    }

    public int getCa_rank() {

        return ca_rank;
    }

    public void setCa_rank(int ca_rank) {
        this.ca_rank = ca_rank;
    }

    public int getCa_score() {
        return ca_score;
    }

    public void setCa_score(int ca_score) {
        this.ca_score = ca_score;
    }

    public String getClub_array_nickname() {
        return club_array_nickname;
    }

    public void setClub_array_nickname(String club_array_nickname) {
        this.club_array_nickname = club_array_nickname;
    }

    public ClubArrayList(int ca_rank, int ca_score, String club_array_nickname) {

        this.ca_rank = ca_rank;
        this.ca_score = ca_score;
        this.club_array_nickname = club_array_nickname;
    }
}
