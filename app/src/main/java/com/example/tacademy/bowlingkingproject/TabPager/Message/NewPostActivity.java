package com.example.tacademy.bowlingkingproject.TabPager.Message;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqCirclesTwentyThree;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesTwentyThree;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewPostActivity extends BaseActivity {
    EditText content;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
    Button complete;
    String contents;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
    /*    FirebaseApp.initializeApp(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();*/
        content = (EditText) this.findViewById(R.id.content);


        complete = (Button) findViewById(R.id.write_complete);



        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contents=content.getText().toString();
                onSendPost();
            }

        });



        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }


    public void onSendPost(){
/*
        //작성 글 입력
        final String content_str = content.getText().toString();
        Log.i("content 에 들어갔을까",content_str);


        // 3. 있으면 이후 작업 진행
        // 로딩시작
        showProgress("글 업로드 중");
        //글 작성 업로드
        String key = databaseReference.child("posts").push().getKey();
        Post post =new Post(content_str);
        Map<String,Object> postMap=post.toPostMap();
        //여러 가지에 업데이트 방식으로 한번에 데이터를 삽입
        Map<String, Object> updates = new HashMap<String,Object>();
        updates.put("/posts/" + key,postMap); //post 줄기에 key 하나 생성되고 그 밑에 생긴다.

        // 추가
        databaseReference.updateChildren(updates,new DatabaseReference.CompletionListener(){
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if(databaseError!=null)
                    Log.i("CHAT", "오류"+databaseError.getMessage());
            }
        });

        //로딩 닫기
        hideProgress();
        //
        파베*/

        Call<ResCirclesTwentyThree> res = NetSSL.getInstance().getMemberImpFactory().twentyThreeCircleInsert(-1,new ReqCirclesTwentyThree(contents,1));
        res.enqueue(new Callback<ResCirclesTwentyThree>() {
            @Override
            public void onResponse(Call<ResCirclesTwentyThree> call, Response<ResCirclesTwentyThree> response) {
                if (response.isSuccessful()) {
                    if( response.body()!=null && response.body().getResult() != null ){
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




        //화면 닫힘
        finish();


    }






}
