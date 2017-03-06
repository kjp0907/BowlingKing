package com.example.tacademy.bowlingkingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqUsers;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsers;
import com.example.tacademy.bowlingkingproject.TabPager.ui.CallSearchActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText loginid, loginpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginid = (EditText) findViewById(R.id.loginid);
        loginpassword = (EditText) findViewById(R.id.loginpassword);

        //자동로그인 처리

        //자동 로그인 처리
        String Id = StorageHelper.getInstance().getString(LoginActivity.this,"id");
        String password = StorageHelper.getInstance().getString(LoginActivity.this,"password");

    }

    public void onClickedLoginbtn(View view){

        final String id=loginid.getText().toString();
        String password = loginpassword.getText().toString();


        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResUsers> res = NetSSL.getInstance().getMemberImpFactory().oneLocalLogin(new ReqUsers(id,password));
        res.enqueue(new Callback<ResUsers>() {
            @Override
            public void onResponse(Call<ResUsers> call, Response<ResUsers> response) {
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
            public void onFailure(Call<ResUsers> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });

        Toast.makeText(this, "로그인 완료", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, CallSearchActivity.class);
        startActivity(intent);

    }



}
