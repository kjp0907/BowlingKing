package com.example.tacademy.bowlingkingproject.join;

import android.os.Bundle;
import android.util.Log;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.Message.BaseActivity;
import com.example.tacademy.bowlingkingproject.consts.E;
import com.example.tacademy.bowlingkingproject.model.user.UserInfoVo;

public class JoinProcessActivity extends BaseActivity {
    UserInfoVo joinInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_process);
        joinInfo = (UserInfoVo) this.getIntent().getSerializableExtra(E.KEY.USERINFO);
        Log.i("프로세서까지 성공","메세지");

    }
}
