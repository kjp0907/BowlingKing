package com.example.tacademy.bowlingkingproject.TabPager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.MainActivity;
import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsersSix;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingActivity extends AppCompatActivity {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        logout = (Button)findViewById(R.id.logout);

    }

    public void onLogout(View view){
        Toast.makeText(this, "로그아웃", Toast.LENGTH_SHORT).show();
        Call<ResUsersSix> res = NetSSL.getInstance().getMemberImpFactory().sixLocalLogout();
        res.enqueue(new Callback<ResUsersSix>() {
            @Override
            public void onResponse(Call<ResUsersSix> call, Response<ResUsersSix> response) {
                if (response.isSuccessful()) {
                    if( response.body()!=null && response.body().getResult() != null ){
                        //ArticlesData aad = response.body().getResult().getArticlesData();
                        //ArticlesData aad = response.body().getResult().getMessage();
                        //Log.i("RF","1성공:"+aad.toString());
//                        ResArticles resArticles = response.body();
                        Log.i("RF" ,"1성공:" + response.body().getResult().toString());
                    } else {
                        Log.i("RF", "2실패:" + response.message());
                    }
                } else {
                    Log.i("RF", "3통신은 됬는데 실패:" + response.message());
                }
            }
            @Override
            public void onFailure(Call<ResUsersSix> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });

        Intent intent =new Intent (this,MainActivity.class);
        startActivity(intent);
    }
}
