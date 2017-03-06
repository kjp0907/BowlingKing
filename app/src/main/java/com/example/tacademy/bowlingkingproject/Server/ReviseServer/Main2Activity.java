package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.PictureTest.ResPictureTest;
import com.example.tacademy.bowlingkingproject.TabPager.ui.CallSearchActivity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onOne(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResUsers> res = NetSSL.getInstance().getMemberImpFactory().oneLocalLogin(new ReqUsers("wngud3","lovely9239"));
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
    }
//
//    public void onTwo(View view) {
//        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
//        Call<ResUsers> res = NetSSL.getInstance().getMemberImpFactory().twoKakaoLoginAndFirstSignUp();
//        res.enqueue(new Callback<ResUsers>() {
//            @Override
//            public void onResponse(Call<ResUsers> call, Response<ResUsers> response) {
//                if (response.isSuccessful()) {
//                    if( response.body()!=null && response.body().getResult() != null ){
//                        //ArticlesData aad = response.body().getResult().getArticlesData();
//                        //ArticlesData aad = response.body().getResult().getMessage();
//                        //Log.i("RF","1성공:"+aad.toString());
////                        ResArticles resArticles = response.body();
//                        Log.i("RF" ,"1성공:" + response.body().getResult().toString());
//                    } else {
//                        Log.i("RF", "2실패:" + response.message());
//                    }
//                } else {
//                    Log.i("RF", "3통신은 됬는데 실패:" + response.message());
//                }
//            }
//            @Override
//            public void onFailure(Call<ResUsers> call, Throwable t) { //통신 자체 실패
//                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
//            }
//        });
//    }


    public void onThree(View view) {
        Call<ResUsersThree> res = NetSSL.getInstance().getMemberImpFactory().threeLocalFirstSignUp(new ReqUsersThree("mins","min3s3e2o13419","tou243R13931T@z.z-",null,"1234516789"));
        res.enqueue(new Callback<ResUsersThree>() {
            @Override
            public void onResponse(Call<ResUsersThree> call, Response<ResUsersThree> response) {
                if (response.isSuccessful()) {
                    if( response.body()!=null && response.body().getResult() != null ){
                        //ArticlesData aad = response.body().getResult().getArticlesData();
                        //ArticlesData aad = response.body().getResult().getMessage();
                        //Log.i("RF","1성공:"+aad.toString());
//                        ResArticles resArticles = response.body();
                        Log.i("RF" ,"1성공:" + response.body().getResult().toString());
                        Log.i("RF","1-1성공:" +response.body().getResult().getMessage());
                    } else {
                        Log.i("RF", "2실패:" + response.message());
                    }
                } else {
                    Log.i("RF", "3통신은 됬는데 실패:" + response.message());
                }
            }
            @Override
            public void onFailure(Call<ResUsersThree> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }


    public void onFour(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResUsersFour> res = NetSSL.getInstance().getMemberImpFactory().fourLocalChange(new ReqUsersFour("갸갸귝",null,null,null) );
        res.enqueue(new Callback<ResUsersFour>() {
            @Override
            public void onResponse(Call<ResUsersFour> call, Response<ResUsersFour> response) {
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
            public void onFailure(Call<ResUsersFour> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }



    public void onFive(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResUsersFive> res = NetSSL.getInstance().getMemberImpFactory().fiveByeBye();
        res.enqueue(new Callback<ResUsersFive>() {
            @Override
            public void onResponse(Call<ResUsersFive> call, Response<ResUsersFive> response) {
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
            public void onFailure(Call<ResUsersFive> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }



    public void onSix(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
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
    }



    public void onSeven(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResDetail> res = NetSSL.getInstance().getMemberImpFactory().sevenDetail(-1);
        res.enqueue(new Callback<ResDetail>() {
            @Override
            public void onResponse(Call<ResDetail> call, Response<ResDetail> response) {
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
            public void onFailure(Call<ResDetail> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }



    public void onEight(View view) {
        Call<ResAnotherDetail> res = NetSSL.getInstance().getMemberImpFactory().eightDetail("다");
        res.enqueue(new Callback<ResAnotherDetail>() {
            @Override
            public void onResponse(Call<ResAnotherDetail> call, Response<ResAnotherDetail> response) {
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
            public void onFailure(Call<ResAnotherDetail> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }


    public void onNine(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResAllRecord> res = NetSSL.getInstance().getMemberImpFactory().nineAllRecord(1,2);
        res.enqueue(new Callback<ResAllRecord>() {
            @Override
            public void onResponse(Call<ResAllRecord> call, Response<ResAllRecord> response) {
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
            public void onFailure(Call<ResAllRecord> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }


/* ****************************o 나중에
    public void onTen(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResScores> res = NetSSL.getInstance().getMemberImpFactory().tenSelfScoreRecord(new ReqScores());
        res.enqueue(new Callback<ResScores>() {
            @Override
            public void onResponse(Call<ResScores> call, Response<ResScores> response) {
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
            public void onFailure(Call<ResScores> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }

    */


    public void onEleven(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResScoresEleven> res = NetSSL.getInstance().getMemberImpFactory().elevenSelfScoreRevise(2, new ReqScoresEleven(3,100,null,null));
        res.enqueue(new Callback<ResScoresEleven>() {
            @Override
            public void onResponse(Call<ResScoresEleven> call, Response<ResScoresEleven> response) {
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
            public void onFailure(Call<ResScoresEleven> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }

    public void onTwelve(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResScoresTwelve> res = NetSSL.getInstance().getMemberImpFactory().twelveSelfScoreDelete(2);
        res.enqueue(new Callback<ResScoresTwelve>() {
            @Override
            public void onResponse(Call<ResScoresTwelve> call, Response<ResScoresTwelve> response) {
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
            public void onFailure(Call<ResScoresTwelve> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }


    public void onThirteen(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCenters> res = NetSSL.getInstance().getMemberImpFactory().thirteenAlleySearch(37.39758, 126.938445);
        res.enqueue(new Callback<ResCenters>() {
            @Override
            public void onResponse(Call<ResCenters> call, Response<ResCenters> response) {
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
            public void onFailure(Call<ResCenters> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }


    public void onFifthteen(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResWhisper> res = NetSSL.getInstance().getMemberImpFactory().fifteenWhisperCondition(-1,1,5 );
        res.enqueue(new Callback<ResWhisper>() {
            @Override
            public void onResponse(Call<ResWhisper> call, Response<ResWhisper> response) {
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
            public void onFailure(Call<ResWhisper> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }



    public void onSixteen(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResWhisperSixteen> res = NetSSL.getInstance().getMemberImpFactory().sixteenWhisperSend(4,new ReqWhisperSixteen("하이룻3"));
        res.enqueue(new Callback<ResWhisperSixteen>() {
            @Override
            public void onResponse(Call<ResWhisperSixteen> call, Response<ResWhisperSixteen> response) {
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
            public void onFailure(Call<ResWhisperSixteen> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }



    public void onSeventeen(View view) {
        Call<ResCircles> res = NetSSL.getInstance().getMemberImpFactory().seventeenCircleCreate(new ReqCircles("3까4까9","모로라라4라라라9"));
        res.enqueue(new Callback<ResCircles>() {
            @Override
            public void onResponse(Call<ResCircles> call, Response<ResCircles> response) {

//                Log.i("MYTEST", response.body().getResult().toString());
//                Log.i("MYTEST2", response.body().getError().toString());
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
            public void onFailure(Call<ResCircles> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }

    public void onEighteen(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCirclesSearch> res = NetSSL.getInstance().getMemberImpFactory().eighteenCircleSearch(2); // 30범위 내
        res.enqueue(new Callback<ResCirclesSearch>() {
            @Override
            public void onResponse(Call<ResCirclesSearch> call, Response<ResCirclesSearch> response) {
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
            public void onFailure(Call<ResCirclesSearch> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }

    public void onNineteen(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCirclesListSearch> res = NetSSL.getInstance().getMemberImpFactory().nineteenCircleListSearch("볼링");
        res.enqueue(new Callback<ResCirclesListSearch>() {
            @Override
            public void onResponse(Call<ResCirclesListSearch> call, Response<ResCirclesListSearch> response) {
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
            public void onFailure(Call<ResCirclesListSearch> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }

    public void onTwenty(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCirclesTwenty> res = NetSSL.getInstance().getMemberImpFactory().twentyCircleSignUp(20);
        res.enqueue(new Callback<ResCirclesTwenty>() {
            @Override
            public void onResponse(Call<ResCirclesTwenty> call, Response<ResCirclesTwenty> response) {
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
            public void onFailure(Call<ResCirclesTwenty> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }



    public void onTwentyOne(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCirclesTwentyOne> res = NetSSL.getInstance().getMemberImpFactory().twentyOneCircleByeBye(-1);
        res.enqueue(new Callback<ResCirclesTwentyOne>() {
            @Override
            public void onResponse(Call<ResCirclesTwentyOne> call, Response<ResCirclesTwentyOne> response) {
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
            public void onFailure(Call<ResCirclesTwentyOne> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }


    public void onTwentyTwo(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCirclesTwentyTwo> res = NetSSL.getInstance().getMemberImpFactory().twentyTwoCircleChange(-1,new ReqCirclesTwentyTwo("뽀올링","류류랴꺼","15"));
        res.enqueue(new Callback<ResCirclesTwentyTwo>() {
            @Override
            public void onResponse(Call<ResCirclesTwentyTwo> call, Response<ResCirclesTwentyTwo> response) {
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
            public void onFailure(Call<ResCirclesTwentyTwo> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }



    public void onTwentyThree(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCirclesTwentyThree> res = NetSSL.getInstance().getMemberImpFactory().twentyThreeCircleInsert(-1,new ReqCirclesTwentyThree("오늘볼링6시다.",1));
        res.enqueue(new Callback<ResCirclesTwentyThree>() {
            @Override
            public void onResponse(Call<ResCirclesTwentyThree> call, Response<ResCirclesTwentyThree> response) {
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
            public void onFailure(Call<ResCirclesTwentyThree> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }

    public void onTwentyFour(View view) {
        Toast.makeText(this, "게시글조회", Toast.LENGTH_SHORT).show();
        Call<ResCirclesTwentyFour> res = NetSSL.getInstance().getMemberImpFactory().twentyFourCircleSearch(-1,1,15); //page 1, row 20 일경우 page1 개당 20개의 리스트를 보여준다.
        res.enqueue(new Callback<ResCirclesTwentyFour>() {
            @Override
            public void onResponse(Call<ResCirclesTwentyFour> call, Response<ResCirclesTwentyFour> response) {
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
            public void onFailure(Call<ResCirclesTwentyFour> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
    }
    // pictureTest //ResPictureTest  //////////////////// 사진 테스트
    public void onPictureTest(View view){
        //center_id : 볼링장 Id
        //score_num : 볼링 점수
        //score_pic : 볼링 점수 사진
        Map<String, RequestBody> map = new HashMap<>();
        map.put("str", RequestBody.create(MediaType.parse("multipart/form-data"), "1") );
//        map.put("score_num", RequestBody.create(MediaType.parse("multipart/form-data"), "100") );

        String sdPath   = Environment.getExternalStorageDirectory().getAbsolutePath()+"/bowling.png";
        File file       = new File(sdPath); // 이미지파일주소는 확인됨
        Log.i("RF", file.getAbsolutePath()+"++"+file.canRead());
        //RequestBody fileBody = RequestBody.create(MediaType.parse("image/*"), file);
        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // photo.jpg는 xxxx.jpg로
        // photos=> 파일받는키, 파일명은 중요하지 않음 =>score.jpg
        map.put("test_pic\"; filename=\"score.jpg\"", fileBody);

        Call<ResPictureTest> res = NetSSL.getInstance().getMemberImpFactory().pictureTest(map);
        res.enqueue(new Callback<ResPictureTest>() {
            @Override
            public void onResponse(Call<ResPictureTest> call, Response<ResPictureTest> response) {
                if( response.isSuccessful() ){
                    if( response.body()!=null && response.body().getResult() != null ){
                        Log.i("RF","업로드성공:"+response.body().getResult().getMessage());
                    }else{
                        Log.i("RF","업로드실패:"+response.message());
                    }
                }else{
                    Log.i("RF","업로드실패:"+response.message());
                }
            }
            @Override
            public void onFailure(Call<ResPictureTest> call, Throwable t) {
            }
        });
    }
    //////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////
    public void onPhotoTest(View view) {
        Intent intent = new Intent(this, CallSearchActivity.class); //CallSearchActivity
        startActivity(intent);
    }

}
