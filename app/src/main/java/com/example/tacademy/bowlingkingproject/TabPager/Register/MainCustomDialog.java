package com.example.tacademy.bowlingkingproject.TabPager.Register;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.R;

public class MainCustomDialog extends Activity {

    private CustomDialog mCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialog);
    }

    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.bt_main:
                mCustomDialog = new CustomDialog(this,
                        "[다이얼로그 제목]", // 제목
                        "다이얼로그 내용 표시하기", // 내용
                        leftListener, // 왼쪽 버튼 이벤트
                        rightListener); // 오른쪽 버튼 이벤트
                mCustomDialog.show();
                break;
        }
    }

    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "왼쪽버튼 클릭",
                    Toast.LENGTH_SHORT).show();
            mCustomDialog.dismiss();
        }
    };

    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "오른쪽버튼 클릭",
                    Toast.LENGTH_SHORT).show();
        }
    };

}