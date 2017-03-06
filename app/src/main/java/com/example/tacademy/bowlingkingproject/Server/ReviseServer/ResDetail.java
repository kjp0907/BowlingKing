package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class ResDetail {
    ResDetailModel result;
    ResDetailModel error;

    public ResDetailModel getResult() {
        return result;
    }

    public void setResult(ResDetailModel result) {
        this.result = result;
    }

    public ResDetailModel getError() {
        return error;
    }

    public void setError(ResDetailModel error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResDetail{" +
                "result=" + result +
                ", error=" + error +
                '}';
    }
}
