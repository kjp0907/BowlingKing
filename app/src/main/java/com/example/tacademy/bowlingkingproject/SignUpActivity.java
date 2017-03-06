package com.example.tacademy.bowlingkingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.Advertisement.CenterActivity;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqUsersThree;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsersThree;
import com.example.tacademy.bowlingkingproject.TabPager.Message.BaseActivity;
import com.example.tacademy.bowlingkingproject.TabPager.model.user;
import com.example.tacademy.bowlingkingproject.TabPager.ui.CallSearchActivity;
import com.example.tacademy.bowlingkingproject.consts.E;
import com.example.tacademy.bowlingkingproject.model.user.UserInfoVo;
import com.example.tacademy.bowlingkingproject.util.Alert;
import com.example.tacademy.bowlingkingproject.util.ObjectStore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.tacademy.bowlingkingproject.R.id.joinUserEmail;
import static com.example.tacademy.bowlingkingproject.R.id.joinUserId;
import static com.example.tacademy.bowlingkingproject.R.id.joinUserNickName;
import static com.example.tacademy.bowlingkingproject.R.id.joinUserPassword;

public class SignUpActivity extends BaseActivity {

//
//    @BindView(R.id.joinUserId)
//    EditText joinUserId;
////    @BindView(R.id.joinUserPassword)
//    EditText joinUserPassword;
////    @BindView(R.id.joinUserEmail)
//    EditText joinUserEmail;
//    @BindView(R.id.joinUserNickName)
//    EditText joinUserNickName;

    EditText id_et,email_et, password_et,nickname_et;


    UserInfoVo joinInfo;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
//        ButterKnife.bind(this);
        this.getSupportActionBar().setTitle(""); //상단부 제목 부분 설정
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼 보여주기
        joinInfo = (UserInfoVo)this.getIntent().getSerializableExtra(E.KEY.USERINFO);
        id_et = (EditText) this.findViewById(joinUserId);
        password_et = (EditText) findViewById(joinUserPassword);
        email_et = (EditText) findViewById(joinUserEmail);
        nickname_et = (EditText) this.findViewById(joinUserNickName);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        //자동 로그인 처리
        String Id = StorageHelper.getInstance().getString(SignUpActivity.this,"id");
        String password = StorageHelper.getInstance().getString(SignUpActivity.this,"password");

//
//        if(Id!=null&password!=null
//                &&!Id.equals("")&&!password.equals("")){
//            joinUserId.setText(Id);
//            joinUserPassword.setText(password);
//            onLogin(null);


  //      }

    }



    //회원가입
    public void onSignUp(View view){
        if(!isValidate()) return; //참이면 진행을 안시킨다.

        String password = password_et.getText().toString();
        final String email = email_et.getText().toString();
        final String id=id_et.getText().toString();
        final String nickname =nickname_et.getText().toString();
        //1. 로딩
     //   showProgress("회원가입중 입니다.");
        //2. 아이디/비밀번호/이메일/닉네임 획득


        Log.i("여긴 될까요","됩니다");

        //3. 인증쪽에 데이터 입력
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {             //성공하면 로딩 닫기
                        hideProgress();
                        if(task.isSuccessful()){
                            Log.i("로그인클릭 성공","성공");
                            onUserSaved(id,password,email,nickname);

                        }else{
                            //실패
                             Log.i("로그인 클릭 실패","뉴뉴뉴");
                        }
                        //5.로그인 처리로 이동,,,,
                    }
                });


        Call<ResUsersThree> res = NetSSL.getInstance().getMemberImpFactory().threeLocalFirstSignUp(new ReqUsersThree(id,nickname,email,null,password));
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


        finish();







    }


    public void onLogin(View view){
        if(!isValidate()) return;

        showProgress("로긴중...");
        //2.이메일비번 획득
        //2.이메일비번 획득
        final String id =id_et.getText().toString();
        final String password =password_et.getText().toString();
        final String email =email_et.getText().toString();
        final String nickname = nickname_et.getText().toString();

        //3. 인증 쪽에 데이터 입력
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener(){
            @Override
            public void onComplete(@NonNull Task task) { //성공하든 실패하든 여기로 떨어진다.
                //4. 성공하면 로딩닫기
                hideProgress();
                if(task.isSuccessful()){
                    Log.i("CHAT", "로긴성공");
                    //서비스로 이동
                    StorageHelper.getInstance().setString(SignUpActivity.this,"id",id);
                    StorageHelper.getInstance().setString(SignUpActivity.this,"email",email);
                    StorageHelper.getInstance().setString(SignUpActivity.this,"password",password);
                    StorageHelper.getInstance().setString(SignUpActivity.this,"nickname",nickname);


                    goCenter();
                }else{
                    //실패
                    Log.i("CHAT", "로긴실패");
                }
            }
        });

    }


    public boolean isValidate(){
        if(TextUtils.isEmpty(email_et.getText().toString())){
            email_et.setError("이메일 입력하쇼!!");
            return false;

        }else {
            String email = email_et.getText().toString();
            email_et.setError(null);
        }

        if(TextUtils.isEmpty(password_et.getText().toString())){
            password_et.setError("비밀번호를 입력하세요.");
            return false;
        }else{
            if(password_et.getText().toString().length()<6){
                password_et.setError("비밀번호 6자 이상이여야합니다.");
                return false;
            }

            password_et.setError(null);
        }

        return true;
    }

    public void goCenter(){
        Intent intent = new Intent (this, CenterActivity.class);
        startActivity(intent);
    }

    public void onUserSaved(String idParam, String passwordParam,String emailParam,String nicknameParam){
        //회원정보 디비에 입력
        String id = idParam;
        String email =emailParam;
        String password = passwordParam;
        String nickname = nicknameParam;
        //회원정보 생성
        user user = new user (id,password,email,nickname);

        //디비 입력
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference.child("users").child(uid).setValue(user)
                .addOnCompleteListener(new OnCompleteListener(){
                    @Override
                    public void onComplete(@NonNull Task task) {
                        //로딩 닫기
                        hideProgress();
                        if(task.isSuccessful()){
                            //로그인
                            Log.i("CHAT","성공");
                            joinOnNextStep();


                        }else{
                            Log.i("CHAT","실패"+task.getException());
                        }
                    }
                });
    }



    //다음 단계 이동
    public void joinOnNextStep() {

        if (id_et == null | password_et == null | email_et == null | nickname_et == null) {
            Toast.makeText(this, "앱을 다시 시작합니다", Toast.LENGTH_SHORT).show();
            finish();
            return; //나중에 다시 확인
        }
        String joinUserId_str = id_et.getText().toString();
        String joinUserPassword_str = password_et.getText().toString();
        String joinUserEmail_str = email_et.getText().toString();
        String joinUserNickName_str = nickname_et.getText().toString();

        //유저가 비밀번호 안치고 그냥 넘어갈수있으므로 보안조취
        if (joinUserId_str.length() == 0) {
            Alert.getInstance().warnAlert(this, "경고", "이름을 정확하게 입력하세요", "확인",
                    new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    });
            return;
        }
        if( joinUserPassword_str.length() == 0 ) {
            Alert.getInstance().warnAlert(this, "경고", "비밀번호를 정확하게 입력하세요", "확인",
                    new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) { //code -> implement 메쏘드
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    });
            return;
        }
        if( joinUserEmail_str.length() == 0 ){
            Alert.getInstance().warnAlert(
                    this,
                    "경고",
                    "이메일을(를) 정확하게 입력하세요",
                    "확인",
                    new SweetAlertDialog.OnSweetClickListener(){
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    });
            return;
        }
        if (joinUserNickName_str.length() == 0) {
            Alert.getInstance().warnAlert(this, "경고", "닉네임을 정확하게 입력하세요", "확인",
                    new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    });
            return;
        }

        UserInfoVo joinInfo = new UserInfoVo();
        joinInfo.setJoinUserId(joinUserId_str);
        joinInfo.setJoinUserPassword(joinUserPassword_str);
        joinInfo.setJoinUserEmail(joinUserEmail_str);
        joinInfo.setJoinUserNickName(joinUserNickName_str);
        ObjectStore.getInstance().getJoinInfo().setJoinUserEmail(joinUserEmail_str);
        ObjectStore.getInstance().getJoinInfo().setJoinUserId(joinUserId_str);
        ObjectStore.getInstance().getJoinInfo().setJoinUserPassword(joinUserPassword_str);
        ObjectStore.getInstance().getJoinInfo().setJoinUserNickName(joinUserNickName_str);
        Log.i("회원가입 성공","메세지");
        Intent intent = new Intent(this, CallSearchActivity.class);
        intent.putExtra(E.KEY.USERINFO,joinInfo); //셋팅했으니 보내야됨
        startActivity(intent);

    }


    //상단 부분 백키를 눌렀을 때 이벤트 처리
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
