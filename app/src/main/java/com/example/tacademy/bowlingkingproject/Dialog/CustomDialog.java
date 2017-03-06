package com.example.tacademy.bowlingkingproject.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;

public class CustomDialog extends Dialog {
    private TextView mTitleView;
    private TextView mContentOneView;
    private TextView mContentTwoView;
    private Button mLeftButton;
    private Button mRightButton;
    private Button mCenterButton;
    private String mTitle;
    private String mContentone;
    private String mContenttwo;

    private View.OnClickListener mLeftClickListener;
    private View.OnClickListener mRightClickListener;
    private View.OnClickListener mCenterClickListener;

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
        mCenterButton = (Button) findViewById(R.id.btn_center);

        // 제목과 내용을 생성자에서 셋팅한다.
        mTitleView.setText(mTitle);
        mContentOneView.setText(mContentone);
        mContentTwoView.setText(mContenttwo);

        // 클릭 이벤트 셋팅
        if (mLeftClickListener != null && mRightClickListener != null && mCenterClickListener != null ) {
            mLeftButton.setOnClickListener(mLeftClickListener);
            mRightButton.setOnClickListener(mRightClickListener);
            mCenterButton.setOnClickListener(mCenterClickListener);
        } else if (mLeftClickListener != null
                && mRightClickListener != null
                && mCenterClickListener == null
                ) {
            mLeftButton.setOnClickListener(mLeftClickListener);
            mRightButton.setOnClickListener(mRightClickListener);
        }  else if (mLeftClickListener != null
            && mRightClickListener == null
            && mCenterClickListener != null
            ) {
        mLeftButton.setOnClickListener(mLeftClickListener);
        mCenterButton.setOnClickListener(mCenterClickListener);

    }
    else {

        }
    }

//    // 클릭버튼이 하나일때 생성자 함수로 클릭이벤트를 받는다.
//    public CustomDialog(Context context, String title,
//                        View.OnClickListener singleListener) {
//        super(context, android.R.style.Theme_Translucent_NoTitleBar);
//        this.mTitle = title;
//        this.mLeftClickListener = singleListener;
//    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public CustomDialog(Context context, String title,
                        String contentOne, String contentTwo, View.OnClickListener leftListener,
                        View.OnClickListener rightListener, View.OnClickListener centerListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mContentone = contentOne;
        this.mContenttwo = contentTwo;

        this.mLeftClickListener = leftListener;
        this.mRightClickListener = rightListener;
        this.mCenterClickListener = centerListener;
    }
}
