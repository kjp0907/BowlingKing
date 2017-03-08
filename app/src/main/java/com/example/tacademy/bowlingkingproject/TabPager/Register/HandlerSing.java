package com.example.tacademy.bowlingkingproject.TabPager.Register;

import android.os.Handler;

/**
 * Created by Tacademy on 2017-03-08.
 */
public class HandlerSing {

    android.os.Handler handler;

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
