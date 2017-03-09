package com.example.tacademy.bowlingkingproject.Dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.Register.HandlerSing;

public class CustomScoreDialog extends Dialog {
    private TextView mTitleView;
    private TextView mContentOneView;
    private TextView mContentTwoView;
    private Button mLeftButton;
    private Button mRightButton;
    private EditText mCenterButton;
    private String mTitle;
    private String mContentone;
    private String mContenttwo;

    private View.OnClickListener mLeftClickListener;
    private View.OnClickListener mRightClickListener;
    private View.OnClickListener mCenterClickListener;

    String score;

    EditText btn_center;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);



        setContentView(R.layout.alert_one_layout);

        mTitleView = (TextView) findViewById(R.id.dialog_text_title);
        mContentOneView = (TextView) findViewById(R.id.dialog_text_content_one);
        mContentTwoView = (TextView) findViewById(R.id.dialog_text_content_two);
        mLeftButton = (Button) findViewById(R.id.btn_left);
        mRightButton = (Button) findViewById(R.id.btn_right);
        btn_center = (EditText) findViewById(R.id.btn_center);



        // 제목과 내용을 생성자에서 셋팅한다.


//        // 클릭 이벤트 셋팅
//        if (mLeftClickListener != null && mRightClickListener != null && mCenterClickListener != null) {
//            mLeftButton.setOnClickListener(mLeftClickListener);
//            mRightButton.setOnClickListener(mRightClickListener);
//            mCenterButton.setOnClickListener(mCenterClickListener);
//        } else if (mLeftClickListener != null
//                && mRightClickListener != null
//                && mCenterClickListener == null
//                ) {
//            mLeftButton.setOnClickListener(mLeftClickListener);
//            mRightButton.setOnClickListener(mRightClickListener);
//        } else if (mLeftClickListener != null
//                && mRightClickListener == null
//                && mCenterClickListener != null
//                ) {
//            mLeftButton.setOnClickListener(mLeftClickListener);
//            mCenterButton.setOnClickListener(mCenterClickListener);
//
//        } else {
//
//        }

        //입력된 점수 text -> webFragment 로 보내기


        findViewById(R.id.btn_right).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                score = btn_center.getText().toString();
                Message msg = HandlerSing.getInstance().getHandler().obtainMessage();
                msg.what=1;
                msg.obj=score;
                Log.i("AB","Dialog"+score);
                HandlerSing.getInstance().getHandler().sendMessage(msg);
                dismiss();
            }
        });

        findViewById(R.id.btn_left).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });




    }

    Handler handler;

////    // 클릭버튼이 하나일때 생성자 함수로 클릭이벤트를 받는다.
//    public CustomDialog(Context context, String title,
//                        View.OnClickListener singleListener) {
//        super(context, android.R.style.Theme_Translucent_NoTitleBar);
//        this.mTitle = title;
//        this.mLeftClickListener = singleListener;
//    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다

    public CustomScoreDialog(Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);

    }
}