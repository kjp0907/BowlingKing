package com.example.tacademy.bowlingkingproject.Advertisement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.SignUpActivity;
import com.example.tacademy.bowlingkingproject.TabPager.Message.BaseActivity;
import com.example.tacademy.bowlingkingproject.join.TermsActivity;

public class CenterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
    }
    //로그인 클릭시 호출
    public void onLogin(View view){
        Toast.makeText(this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show();
    }
    //회원가입 클릭시 호출
    public void joinOnJoin(View view){
        Toast.makeText(this, "회원가입 버튼 클릭", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, SignUpActivity.class);
        startActivity(intent);
    }

    //로그인 클릭시 호출
    public void onTerms(View view){
        Toast.makeText(this, "약관 버튼 클릭", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, TermsActivity.class); //이용약관 화면으로 이동
        startActivity(intent);
    }

}