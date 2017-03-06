package com.example.tacademy.bowlingkingproject.util;

/**
 * Created by Tacademy on 2017-02-14.
 */

import android.content.Context;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 *  알러트, 팝업용 유틸리티
 */
public class Alert {
    private static Alert ourInstance = new Alert();

    public static Alert getInstance() {
        return ourInstance;
    }

    private Alert() {
    }
    //이 안의 메쏘드는 하나만 존재하는 싱글톤 메쏘드가 됨
    //경고 알러트
    public SweetAlertDialog warnAlert(Context context, String title, String msg, String confirm, SweetAlertDialog.OnSweetClickListener listener) //퍼블릭으로 해야 바깥에서 쓰니까
    {
        SweetAlertDialog alert =
                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText(title)
                        .setContentText(msg)
                        .setConfirmText(confirm)

                        .setConfirmClickListener(listener);


        alert.show();
        return alert;

    }
}