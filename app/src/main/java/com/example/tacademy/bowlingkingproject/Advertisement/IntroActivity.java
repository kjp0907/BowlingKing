package com.example.tacademy.bowlingkingproject.Advertisement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.Message.BaseActivity;

/**
 * Created by Tacademy on 2017-02-05.
 */

public class IntroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        showProgress("Now Loading");
        handler.sendEmptyMessageDelayed(0, 1000*3);
    }

Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what == 0){
            hideProgress();
            Intent intent = new Intent(IntroActivity.this, CenterActivity.class);
            startActivity(intent);
            }
        }
    };
}
