package com.example.tacademy.bowlingkingproject.util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 통신 모듈(싱글톤)
 */
public class Net {
    private static Net ourInstance = new Net();

    public static Net getInstance() {
        return ourInstance;
    }


    private Net() {

    }
    //통신 큐 : 요청이 들어오는 순서대로 처리한다(응답 결과는 비동기)
    private RequestQueue requestQueue; //전체에서 유니크하게 싱글톤에다가
    public RequestQueue getRequestQueue(Context context){ //널도 리턴할 수 있으니 if문
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
}