package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-02-28.
 */

public class CenterLocation {
    double x;
    double y;

    @Override
    public String toString() {
        return "CenterLocation{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
