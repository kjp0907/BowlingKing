package com.example.tacademy.bowlingkingproject.TabPager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqUsersFour;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsersFour;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditInforActivity extends AppCompatActivity {


    EditText editUserEmail,editUserNickName,editUserPassword;
    String UserEmail,UserNickName,UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_infor);

        editUserEmail=(EditText)findViewById(R.id.editUserEmail);
        editUserNickName=(EditText)findViewById(R.id.editUserNickName);
        editUserPassword=(EditText)findViewById(R.id.editUserPassword);



    }

    public void onEdit(View view){


        UserEmail = editUserEmail.getText().toString();
        UserNickName = editUserNickName.getText().toString();
        UserPassword = editUserPassword.getText().toString();


        Call<ResUsersFour> res = NetSSL.getInstance().getMemberImpFactory().fourLocalChange(new ReqUsersFour(UserNickName,UserEmail,UserPassword,null) );
        res.enqueue(new Callback<ResUsersFour>() {
            @Override
            public void onResponse(Call<ResUsersFour> call, Response<ResUsersFour> response) {
                if (response.isSuccessful()) {
                    if( response.body()!=null && response.body().getResult() != null ){
                        Log.i("RF" ,"정보 변경 되어쯤다:" + response.body().getResult().toString());
                        Log.i("RF","정보변경"+UserNickName);

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
        Toast.makeText(this,"정보수정 완료",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,SettingActivity.class);
        startActivity(intent);


    }
}
