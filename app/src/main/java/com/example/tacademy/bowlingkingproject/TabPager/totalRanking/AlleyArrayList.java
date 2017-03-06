package com.example.tacademy.bowlingkingproject.TabPager.totalRanking;

/**
 * Created by Tacademy on 2017-02-22.
 */

public class AlleyArrayList {

    String aa_rank;
    String aa_score;
    String aa__nickname;

    public String getAa_rank() {
        return aa_rank;
    }

    public void setAa_rank(String aa_rank) {
        this.aa_rank = aa_rank;
    }

    public String getAa_score() {
        return aa_score;
    }

    public void setAa_score(String aa_score) {
        this.aa_score = aa_score;
    }

    public String getAa__nickname() {
        return aa__nickname;
    }

    public void setAa__nickname(String aa__nickname) {
        this.aa__nickname = aa__nickname;
    }

    public AlleyArrayList(String aa_rank, String aa_score, String aa__nickname) {

        this.aa_rank = aa_rank;
        this.aa_score = aa_score;
        this.aa__nickname = aa__nickname;
    }
}
