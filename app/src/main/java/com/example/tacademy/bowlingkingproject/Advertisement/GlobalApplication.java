package com.example.tacademy.bowlingkingproject.Advertisement;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.StorageHelper;
import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthType;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;
import com.miguelbcr.ui.rx_paparazzo.RxPaparazzo;


public class GlobalApplication extends Application // 처음 꽉 잡게 상속 받아야 되므로 extends Application
{
    private static volatile GlobalApplication instance = null;
    public static GlobalApplication getGlobalApplicationContext() {
        if(instance == null)
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        RxPaparazzo.register(this);
        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter()); //카카오꺼 들고오니 아답터\
        StorageHelper.getInstance().setContext(getApplicationContext());
        NetSSL.getInstance().launch(getApplicationContext());
    }
    private static class KakaoSDKAdapter extends KakaoAdapter {
        /**
         * Session Config에 대해서는 default값들이 존재한다.
         * 필요한 상황에서만 override해서 사용하면 됨.
         * @return Session의 설정값.
         */
        @Override
        public ISessionConfig getSessionConfig() {
            return new ISessionConfig() {
                @Override
                public AuthType[] getAuthTypes() {
                    return new AuthType[] {AuthType.KAKAO_LOGIN_ALL};
                }

                @Override
                public boolean isUsingWebviewTimer() {
                    return false;
                }

                @Override
                public boolean isSecureMode() {
                    return false;
                }

                @Override
                public ApprovalType getApprovalType() {
                    return ApprovalType.INDIVIDUAL;
                }

                @Override
                public boolean isSaveFormData() {
                    return true;
                }
            };
        }

        @Override
        public IApplicationConfig getApplicationConfig() {
            return new IApplicationConfig() {
                @Override
                public Context getApplicationContext() {
                    return GlobalApplication.getGlobalApplicationContext(); //빨간불 없애려고
                }
            };
        }
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}