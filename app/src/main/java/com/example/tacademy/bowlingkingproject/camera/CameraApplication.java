package com.example.tacademy.bowlingkingproject.camera;

import android.app.Application;

import com.miguelbcr.ui.rx_paparazzo.RxPaparazzo;

public class CameraApplication extends Application {

        @Override
        public void onCreate() {
            super.onCreate();
            RxPaparazzo.register(this);
        }
    }