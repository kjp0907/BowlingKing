package com.example.tacademy.bowlingkingproject.Server;

import android.content.Context;
import android.content.SharedPreferences;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tacademy on 2017-02-20.
 */
public class Net {
    private static Net ourInstance = new Net();
    public static Net getInstance() {
        return ourInstance;
    }
    private Net() {
    }
    ////////////////////////////////////////////////////////////////////////
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ec2-52-79-161-180.ap-northeast-2.compute.amazonaws.com:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Retrofit getRetrofit() {
        return retrofit;
    }
    ////////////////////////////////////////////////////////////////////////
    MemberImpFactory memberImpFactory;

    public MemberImpFactory getMemberImpFactory() {
        if( memberImpFactory == null ){
            memberImpFactory = retrofit.create(MemberImpFactory.class);
        }
        return memberImpFactory;
    }
    ////////////////////////////////////////////////////////////////////////

    /**
     * 앱 구동간 필요에 의해서 저장하는 저장소 기능
     */
    public static class StorageHelper {

        //저장소 메인 키
        public static final String STORAGE_KEY ="pref";
        private static StorageHelper ourInstance = new StorageHelper();
        public static StorageHelper getInstance() {
            return ourInstance;
        }
        private StorageHelper() {
        }
        // ------------------- 저장 타입별 기능 제공 ----------------------
        //static{
            // NDK로 만들어는 lib, o등등 파일을(c/c++라이브러리) 로드할대 사용
            // libXXXXXX.o
            // System.loadLibrary("xxxx.o");
        //}
        public void setString(Context context, String key, String value)
        {
            // 저장소 획득
            SharedPreferences.Editor editor
                    = context.getSharedPreferences(STORAGE_KEY, 0).edit();
            // 저장
            editor.putString(key, value);
            // 커밋
            editor.commit();
        }
        public String getString(Context context, String key)
        {
            return
            context.getSharedPreferences(STORAGE_KEY, 0).getString(key, "");
        }


        public void setBoolean(Context context, String key, boolean value)
        {
            // 저장소 획득
            SharedPreferences.Editor editor
                    = context.getSharedPreferences(STORAGE_KEY, 0).edit();
            // 저장
            editor.putBoolean(key, value);
            // 커밋
            editor.commit();
        }
        public boolean getBoolean(Context context, String key)
        {
            return
            context.getSharedPreferences(STORAGE_KEY, 0).getBoolean(key, false);
        }

        public void setInt(Context context, String key, int value)
        {
            // 저장소 획득
            SharedPreferences.Editor editor
                    = context.getSharedPreferences(STORAGE_KEY, 0).edit();
            // 저장
            editor.putInt(key, value);
            // 커밋
            editor.commit();
        }
        public int getInt(Context context, String key)
        {
            return
                    context.getSharedPreferences(STORAGE_KEY, 0).getInt(key, 0);
        }
    }
}

















