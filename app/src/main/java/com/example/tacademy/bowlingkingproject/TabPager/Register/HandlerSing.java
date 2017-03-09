package com.example.tacademy.bowlingkingproject.TabPager.Register;

import android.os.Handler;

/**
 * Created by Tacademy on 2017-03-08.
 */
public class HandlerSing {

    android.os.Handler handler;
    android.os.Handler scorehandler;

    public Handler getScorehandler() {
        return scorehandler;
    }

    public void setScorehandler(Handler scorehandler) {
        this.scorehandler = scorehandler;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public static HandlerSing getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(HandlerSing ourInstance) {
        HandlerSing.ourInstance = ourInstance;
    }

    private static HandlerSing ourInstance = new HandlerSing();

    public static HandlerSing getInstance() {
        return ourInstance;
    }

    private HandlerSing() {
    }
}
