package com.example.tacademy.bowlingkingproject;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.google.android.gms.location.LocationListener;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.kakaolink.KakaoLink;
import com.kakao.util.KakaoParameterException;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//setContentView(R.layout.activity_main);

public class MainActivity extends AppCompatActivity{
    SessionCallback callback;
    KakaoLink kakaoLink; //전역변수는 위나 밑이나 위치 상관없음

    private LocationManager locationManager;
    LocationManager locManager; // 위치 정보 프로바이더
    LocationListener locationListener; // 위치 정보가 업데이트시 동작



    class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            Log.i("KAKA","onSessionOpened() call");
            redirectSignupActivity();
        }
        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Log.i("KAKA","onSessionOpened() call:"+exception.getMessage());
                Logger.e(exception);
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        //Intent intent = new Intent(this, Cam                                                                        eraJpActivity.class);
//        Intent intent = new Intent(this, CallSearchActivity.class); //CallSearchActivity          CenterActivity
//        startActivity(intent);
//        Intent intent = new Intent(this, CallSearchActivity.class);
//        startActivity(intent);
//


        //링커 생성 //메세지 보내겠다고 변수 누르면 그때 발동되는 빌드
        try { // try catch는 드래그 잡은 사아태로.. 코드 -> surround with
            kakaoLink = KakaoLink.getKakaoLink(this.getApplicationContext());
        } catch (KakaoParameterException e) {
            e.printStackTrace();
        }
        //해시키 구하기
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {}
        catch (NoSuchAlgorithmException e) {}



        //카카오 로그인에 대한 세션 체킹을 위한 아답터 생성
        callback = new SessionCallback();
        //세션 객체에 등록
        Session.getCurrentSession().addCallback(callback);
        //세션 채킹
        Session.getCurrentSession().checkAndImplicitOpen();




    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("KAKA","requestCode:"+requestCode);
        Log.i("KAKA","resultCode:"+resultCode);
        //데이터가 null이면 뻑이나므로
        if(data!=null)
            Log.i("KAKA","Intent:"+data.toString()); //데이터가 전달됬으면 인텐트로 전달되니까
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //간단하게 로그인 하는 엑티비티로 이동
    protected void redirectSignupActivity() {
        Log.i("KAKA", "redirectSignupActivity()");
//        final Intent intent = new Intent(this, SampleSignupActivity.class);
//        startActivity(intent);
//        finish();
    }


    public void joinOnJoin(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);

    }

    public void onClickedLogin(View view ){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
