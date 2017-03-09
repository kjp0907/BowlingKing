package com.example.tacademy.bowlingkingproject.Server;

import com.example.tacademy.bowlingkingproject.Server.ReviseServer.PictureTest.ResPictureTest;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqCircles;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqCirclesTwentyThree;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqCirclesTwentyTwo;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqScores;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqScoresEleven;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqUsers;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqUsersFour;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqUsersThree;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ReqWhisperSixteen;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResAllRecord;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResAnotherDetail;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCenters;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCircles;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesListSearch;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesSearch;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesTwenty;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesTwentyFour;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesTwentyOne;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesTwentyThree;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesTwentyTwo;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResDetail;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResScores;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResScoresEleven;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResScoresTwelve;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsers;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsersFive;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsersFour;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsersSix;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResUsersThree;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResWhisper;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResWhisperSixteen;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 회원관련 모든 API 구현
 1. 카카오톡 로그인 및 최초 회원등록_
 2. 로컬 회원 최초 가입_
 3. 로컬 회원 로그인_
 4. 로컬 회원 정보 변경_
 5. 회원 탈퇴하기_
 6. 회원 로그아웃_
 7. 회원 상세 정보 보기_
 8. 회원 본인 모든 기록 보기_
 9. 회원 본인 점수 등록_
 10. 회원 본인 점수 수정_
 11. 회원 본인 점수 삭제_
 */

public interface MemberImpFactory
{
    // 로컬 회원 최초 가입 --------------------------------------------------------------------------
    @POST("users")
    Call<ResAll> join(@Body ReqAll reqAll);
    // 세션 사용 -----------------------------------------------------------------------------------
    @POST("/auth/local/login")
    Call<ResAll> login(@Body ReqAll reqAll);
    // 세션 아웃 -----------------------------------------------------------------------------------
    @GET("/auth/logout")
    Call<ResAll> logout();
    // 회원 정보 요청 --------------------------------------------------------------------------------
    // /users/:uid
    @GET("/users/{uid}")
    Call<ResAll> showMe(@Path("uid") String uid);
    // GET 요청  -----------------------------------------------------------------------------------
    // /scores/me/ranklist?condition_id=&center_id=&circle_id=&current_page=
    @GET("/scores/me/ranklist")
    Call<ResAll> ranklist(@QueryMap Map<String, String> options);
    // GET 요청2  -----------------------------------------------------------------------------------
    @GET("/scores/me/ranklist")
    Call<ResAll> ranklist2(@Query("condition_id") String condition_id,
                           @Query("center_id") String center_id,
                           @Query("circle_id") String circle_id,
                           @Query("current_page") String current_page);
    // ---------------------------------------------------------------------------------------------

//     조건별 랭킹보기 /scores?condi=&id=&page=&rows=
    @GET("/scores")
    Call<ResAll> ranklist_two(@Query("condi") String condi,
                           @Query("id") String id,
                           @Query("page") String page,
                           @Query("rows") String rows);


//////////////////////////////////2017.02.28.01:03/////////////////////////////////
//    1. 로컬 회원 로그인_
    @POST("/auth/local/login")
    Call<ResUsers> oneLocalLogin(@Body ReqUsers reqUsers);
//    2. 카카오톡 로그인 및 최초 회원등록_XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    //@POST("/auth/kakaotalk/login")
    //Call<ResUsers> twoKakaoLoginAndFirstSignUp(@Body ReqUsers reqUsers);
//    3. 로컬 회원 최초 가입_
    @POST("/users")
    Call<ResUsersThree> threeLocalFirstSignUp(@Body ReqUsersThree reqUsersThree);
//    4. 로컬 회원 정보 변경_
    @PUT("/users/me")
    Call<ResUsersFour> fourLocalChange(@Body ReqUsersFour reqUsersFour);
//    5. 회원 탈퇴하기_
    @DELETE("/users/me")
    Call<ResUsersFive> fiveByeBye();
//    6. 회원 로그아웃_
    @GET("/auth/logout")
    Call<ResUsersSix> sixLocalLogout();
//    7. 회원 상세 정보 보기_
    @GET("/users/{uindex}")
    Call<ResDetail> sevenDetail(@Path("uindex") int uindex);
//    8. 다른 회원 목록 조회_??????????? ?uname으로 새로 만든????????????????
    @GET("/users")
    Call<ResAnotherDetail> eightDetail(@Query("uname") String uname);
//    9. 회원 본인 모든 기록 보기_????????????/me가 걸리는??????????
    @GET("/scores/me")
    Call<ResAllRecord> nineAllRecord(@Query("page") int page, @Query("rows") int rows);
//    10 회원 본인 점수 등록_
    @POST("/scores")
    Call<ResScores> tenSelfScoreRecord(@Body ReqScores reqScores);
//    11. 회원 본인 점수 수정_??????????PUT이면서 동적 첨쓴거?????????
    @PUT("/scores/{score_id}")
    Call<ResScoresEleven> elevenSelfScoreRevise(@Path("score_id") int score_id, @Body ReqScoresEleven reqScoresEleven);
//    12. 회원 본인 점수 삭제_???????????위에 POST는 Body가 있는데 동적이라 첨이고, 밑의 DELETE는 Header로 오는데 동적이라 처음씀???????
    //더 설명하자면 위의 11번 API에서 Body 부분이 이게 아닐까 생각 중.. (@Path("score_id") @Body ReqScores reqScores);
    @DELETE("/scores/{score_id}")
    Call<ResScoresTwelve> twelveSelfScoreDelete(@Path("score_id") int score_id);
//    13. 볼링장 조회_?????????????위도 경도가 정수는 아닐꺼같아서 float로 썼는데 맞는지????????????????
    @GET("/centers")
    Call<ResCenters> thirteenAlleySearch(@Query("lati") double lati, @Query("longi") double longi);
//    14. 조건별 랭킹 보기_MMMMMMMMMMMMMMMMMMMMMMM민서씨가 하고 있는 중SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
//    15. 쪽지 조건별 목록 보기_
    @GET("/users/me/messages/{user}")
    Call<ResWhisper> fifteenWhisperCondition(@Path("user") int user, @Query("page") int page, @Query("rows") int rows);
//    16. 쪽지 보내기_
    @POST("/users/me/messages/{user}")
    Call<ResWhisperSixteen> sixteenWhisperSend(@Path("user") int user, @Body ReqWhisperSixteen reqWhisperSixteen);
//    17. 동호회 생성_
    @POST("/circles")
    Call<ResCircles> seventeenCircleCreate(@Body ReqCircles reqCircles);
//    18. 동호회 조회_
    @GET("/circles/{cid}")
    Call<ResCirclesSearch> eighteenCircleSearch(@Path("cid") int cid);
//    19. 동호회 목록 조회_??????????????이건 API 전문에 친절하게 String으로 쓰라해서 썼지만 다른 API 전문에는 없었음?????????
    @GET("/circles")
    Call<ResCirclesListSearch> nineteenCircleListSearch(@Query("name") String name);
//    20. 동호회 가입_??????????????위의 API 11번과 같은 이유로 의아or궁금????????????
    @POST("/circles/{cid}/members/me")
    Call<ResCirclesTwenty> twentyCircleSignUp(@Path("cid") int cid);
//    21. 동호회 탈퇴_
    @DELETE("/circles/{cid}/members/me")
    Call<ResCirclesTwentyOne> twentyOneCircleByeBye(@Path("cid") int cid);
//    22. 동호회 변경_??????????????위의 API 11번과 같은 이유로 의아or궁금??????????
    @PUT("/circles/{cid}")
    Call<ResCirclesTwentyTwo> twentyTwoCircleChange(@Path("cid") int cid, @Body ReqCirclesTwentyTwo reqCirclesTwentyTwo);
//    23. 게시글 등록_
    @POST("/circles/{cid}/articles")
    Call<ResCirclesTwentyThree> twentyThreeCircleInsert(@Path("cid") int cid, @Body ReqCirclesTwentyThree reqCirclesTwentyThree);
//    24. 게시글 목록 조회_
    @GET("/circles/{cid}/articles")
    Call<ResCirclesTwentyFour> twentyFourCircleSearch(@Path("cid") int cid, @Query("page") int page, @Query("rows") int rows);

    ////////3,4,10,11번은 업로드 쎼쎼쎼쎼트, 3,4,11번은 사진 없이 성공했고, 10번 완료후 사진있이 3,4,10,11다시 테스트해야됨///////
    @Multipart
    @POST("/scores")
    Call<ResPictureTest> pictureTest(@PartMap Map<String, RequestBody> params);
}


















