package com.example.tacademy.bowlingkingproject.TabPager.frag;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.Dialog.CustomDialog;
import com.example.tacademy.bowlingkingproject.Dialog.CustomDialogTwo;
import com.example.tacademy.bowlingkingproject.Dialog.LocationDialog;
import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCenters;
import com.example.tacademy.bowlingkingproject.TabPager.Register.GpsInfo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.miguelbcr.ui.rx_paparazzo.RxPaparazzo;
import com.miguelbcr.ui.rx_paparazzo.entities.size.SmallSize;
import com.squareup.picasso.Picasso;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.app.Activity.RESULT_OK;
import static android.os.Build.VERSION_CODES.M;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FaceBookFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FaceBookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebSearchFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener ,LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient client;
    private boolean isInit = false;
    private boolean mapsSupported = true;
    MapView mapview;
    double x,y; //위도 경도

    //볼링장 리스트
    ArrayList<ResCenters> centersArrayList;
    ListView centerlist;
    //CenterListAdpater center_adapter;




    TextView logView;


    LocationDialog locationDialog;


    int PERMISSION_ACCESS_FINE_LOCATION = 10;
    // 구글 API 접속 객체
    GoogleApiClient mGoogleApiClient;

    private OnFragmentInteractionListener mListener;

    @Override
    public void onMapReady(GoogleMap googleMap) {



        mMap        = googleMap;
        GpsInfo gps = new GpsInfo(getActivity());

        if (gps.isGetLocation()) { // GPS ON
            // 현재 위도, 경도
            double latitude  = gps.getLatitude();
            double longitude = gps.getLongitude();
            LatLng latLng = new LatLng(latitude, longitude);

            // 현재 위치를 표시할 마커 설정
            MarkerOptions optFirst = new MarkerOptions();
            optFirst.position(latLng);
            optFirst.title("Current Position");
            optFirst.snippet("현재 위치");

            // 현재 위치로 지도 이동 및 줌
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
            mMap.addMarker(optFirst).showInfoWindow();
        } else { //GPS OFF
            // 초기 위치 및 마커 설정
            LatLng latLng        = new LatLng(x, y);
            MarkerOptions marker = new MarkerOptions().position(latLng);

            // 초기 설정 위치로 지도 이동 및 줌
            mMap.addMarker(marker);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
        }




    }

    @Override
    public void onMapClick(LatLng point) {
        Point screenPt = mMap.getProjection().toScreenLocation(point);

        LatLng latLng = mMap.getProjection().fromScreenLocation(screenPt);
    }

    EditText score,location;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private String path;


    EditText alleysearchjp;

    ImageView cameraimageView;
    TextView scoretoastjp;

    TextView timenow;
    Button timebtn;

    private GoogleMap googleMap;



    Fragment fragment;

    int goType =0;

    Context context;
    Button location_btn,gps_btn;

    private LocationManager locationManager;

    private Button btnShowLocation;
    private TextView txtLat;
    private TextView txtLon;
//    public LocationFragment() {
//    }

    //====================현재위치 받아오기 위해 implement LocationListener
    private static final String TAG = "LocationFragment";
    private LocationManager mLocationManager;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mLocationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public void onLocationChanged(Location location) {






    }

    //=================================================================================================
    public WebSearchFragment() {
    }

    public static FaceBookFragment newInstance(String param1, String param2) {
        FaceBookFragment fragment = new FaceBookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
/////////////////////////////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web_search, container, false);

        context=getActivity();
        scoretoastjp= (TextView) view.findViewById(R.id.scoretoastjp);
        alleysearchjp = (EditText) view.findViewById(R.id.alleysearchjp);
        alleysearchjp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomDialogTwo = new CustomDialogTwo(getActivity(),
                        "볼링장 이름을 검색하세요", // 제목
                        leftListenerTwo, // 왼쪽 버튼 이벤트
                        rightListenerTwo); // 오른쪽 버튼 이벤트
                mCustomDialogTwo.show();
            }
        });
        scoretoastjp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomDialog = new CustomDialog(getActivity(),
                        "점수를 등록하세요", // 제목
                        "/'볼링왕/'님은",
                        "점 입니다", // 내용
                        leftListener, // 왼쪽 버튼 이벤트
                        rightListener, // 오른쪽 버튼 이벤트
                        centerListener);
                mCustomDialog.show();
            }
        });
        cameraimageView = (ImageView)view.findViewById(R.id.cameraimageView);
        cameraimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPhoto(v);
            }
        });

        // 리소스를 객체로 연결


        mapview         = (MapView) view.findViewById(R.id.map);
        ButterKnife.bind(this, view);

        // 구글맵 생성
        mapview.onCreate(savedInstanceState);
        mapview.onResume();
        mapview.getMapAsync(this);



        //현재 시간 text로 넣기

        // 시스템으로부터 현재시간(ms) 가져오기
        long now = System.currentTimeMillis();
        // Data 객체에 시간을 저장한다.
        Date date = new Date(now);
        // 각자 사용할 포맷을 정하고 문자열로 만든다.
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String strNow = sdfNow.format(date);

        timenow = (TextView)view.findViewById(R.id.timenow);
        timenow.setText(strNow);

        //dialog 위치검색




        // 위치검색 다이얼로그 설정 / 리스트 설정 ==================================================================

        location_btn = (Button)view.findViewById(R.id.bowling);
        // GPS 정보를 보여주기 위한 이벤트 클래스 등록

        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Toast.makeText(getContext(), "위치조회", Toast.LENGTH_SHORT).show();
                Call<ResCenters> res = NetSSL.getInstance().getMemberImpFactory().thirteenAlleySearch(x, y);
                res.enqueue(new Callback<ResCenters>() {
                    @Override
                    public void onResponse(Call<ResCenters> call, Response<ResCenters> response) {
                        if (response.isSuccessful()) {
                            if( response.body()!=null && response.body().getResult() != null ){
                                //ArticlesData aad = response.body().getResult().getArticlesData();
                                //ArticlesData aad = response.body().getResult().getMessage();
                                //Log.i("RF","1성공:"+aad.toString());
//                        ResArticles resArticles = response.body();

                                Log.i("RF", "gps 인근 리스트"+ response.body().getResult().toString());
//                                GpsList aaaaa = response.body().getResult().
//                                GpsList aaaaa = response.body().getResult().getMessage();



                             //   centersArrayList.addAll(response.body().getResult().getCenterData());



//




                                Log.i("RF" ,"1성공:" + response.body().getResult().getCenterData());

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

                 final LocationDialog dialog= new LocationDialog(context);
                    dialog.setContentView(R.layout.dialog_location);
                    dialog.setTitle("볼링장 이름을 검색하세요.");

                    dialog.show();








            }
        });








        //==================================================================


        // 구글 API 사용
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int code = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (code == ConnectionResult.SUCCESS) {
            Log.i("GPS","Google api 사용 가능");
            checkGpsUseOn();
        } else {
         //   api.getErrorDialog(this, code, 0).show();
        }



        return view;
    }





//gps
public void checkGpsUseOn()
{
    if( Build.VERSION.SDK_INT >= M ){
        int permissionCheck = ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                // 동의 되었다
                //getAddress();
                checkGpsDetectingOn(1);
            }else{
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSION_ACCESS_FINE_LOCATION);
            }
        } else {
            // 동의후 6.0이상에서는 퍼미션을 동의 했으므로 바로 실행
            //getAddress();
            checkGpsDetectingOn(2);
        }
    }else{
        // 6.0 이하 단말기는 동의가 필요 없으므로 바로 실행
        //getAddress();
        checkGpsDetectingOn(3);
    }
}

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if( requestCode == PERMISSION_ACCESS_FINE_LOCATION ){
            // 퍼미션 허가에 대해서 동의를 누르면 호출!!
            if( grantResults.length>0 ){
                if(grantResults[0] < 0 ){   // 거부
                    // GPS 요청 불가
                    // 미동의
                    checkGpsDetectingOn(5);
                }else{  // 동의
                    checkGpsDetectingOn(4);
                }
            }
        }

    }


    public void checkGpsDetectingOn(int type)
    {
        Log.i("GPS","타입 : " + type);
        if( type == 2 || type == 4 ){   // 6.0이상에서 GPS 동의자
            // GPS 획득 요청
            newTypeGps();
        }else if( type == 3){ // 6.0이하이므로 권한동의 없이 바로 GPS 요청
            // GPS 획득 요청
            newTypeGps();
        }else if( type == 5){ // 6.0이상에서 거부
            // 보류
        }
    }


    public void newTypeGps()
    {
        // 진저브레드 이상부터 지원되며 구글플레이스토어가 있어야 함.
        // 안드로이드 AVD를 이용한 에뮬레이터는 키캣이상 버전에서 작동
        Log.i("GPS", "API확인");
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(connectionCallbacks)
                .addOnConnectionFailedListener(connectionFailedListener)
                .build();
        mGoogleApiClient.connect();
    }
    GoogleApiClient.ConnectionCallbacks connectionCallbacks = new GoogleApiClient.ConnectionCallbacks(){
        @Override
        public void onConnected(@Nullable Bundle bundle) {
            Log.i("GPS", "연결되엇다");
            onConnect();
        }
        @Override
        public void onConnectionSuspended(int i) {
            Log.i("GPS", "연결 서스펜드");
        }
    };
    GoogleApiClient.OnConnectionFailedListener connectionFailedListener = new GoogleApiClient.OnConnectionFailedListener(){
        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            Log.i("GPS", "연결 실패" + connectionResult.getErrorMessage());
        }
    };
    final int INTERVAL = 5;
    final int FASTEST_INTERVAL = 10;
    LocationRequest mLocationRequest;






    public void onConnect()
    {
        //ArrayList<LatLng> latLngs=new ArrayList<LatLng>().add(new LatLng());
        //setInteval : 위치가 update되는 주기
        //setFastestInterval : 위치 획득 후 update되는 주기
        //Priority는 4가지의 설정
        //PRIORITY_HIGH_ACCURACY : 배터리소모를 고려하지 않으며 정확도를 최우선으로 고려
        //PRIORITY_LOW_POWER : 저전력을 고려하며 정확도가 떨어짐
        //PRIORITY_NO_POWER : 추가적인 배터리 소모없이 위치정보 획득
        //PRIORITY_BALANCED_POWER_ACCURACY : 전력과 정확도의 밸런스를 고려. 정확도 다소 높음setSmallestDisplacement : 최소 거리 이동시 갱신 가능.

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);



        // Gps가 꺼져있다면 LocationSettingsRequest로 설정창을 띄움
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);
        PendingResult result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        if (result != null) {
            result.setResultCallback(new com.google.android.gms.common.api.ResultCallback<LocationSettingsResult>() {
                @Override
                public void onResult(LocationSettingsResult locationSettingsResult) {
                    //listener.onResult(locationSettingsResult);
                    Log.i("GPS", "체크 결과" + locationSettingsResult.getStatus().getStatusCode());
                    Status status = locationSettingsResult.getStatus();
                    switch (status.getStatusCode()) {
                        case LocationSettingsStatusCodes.SUCCESS:
                            Log.i("GPS", "요청시작");
                            startGsp();
                            break;
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            try {
                                if (status.hasResolution()) {
                                    status.startResolutionForResult(getActivity(), 1000);
                                }
                            } catch (IntentSender.SendIntentException e) {

                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            Log.i("GPS", "이용불가");
                            break;
                    }
                }
            });
        }
    }


    public void startGsp()
    {
        LocationServices.FusedLocationApi
                .requestLocationUpdates(mGoogleApiClient, mLocationRequest, locationListener);
    }
    public void stopGps()
    {
        LocationServices.FusedLocationApi
                .removeLocationUpdates(mGoogleApiClient, locationListener);
    }


    private LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            Log.i("GPS", "위치값 왔다");
            stopGps();
            if(null != location) {
                x = location.getLatitude();
                y = location.getLongitude();
                Toast.makeText(getContext(),"lat:" + x  + "lng:"+y,Toast.LENGTH_SHORT).show();
                Log.i("GPS", "lat:"+x);
                Log.i("GPS", "lng:"+y);




            }
        }
    };





    SweetAlertDialog alert;
    public void onPhoto(View view){
        alert =
                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("사진선택")
                        .setContentText("사진을 선택할 방법을 고르시오")
                        .setConfirmText("카메라")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                onCamera();
                                //   alert.dismiss();//카메라로 이동
                            }

                        })
                        .setCancelText("포토앨범")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener(){
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                onGallery(); //갤러리로 이동
                                //             alert.dismiss();
                            }
                        });
        alert.setCancelable(true);
        alert.show();
    }

    public void onCamera() {
        //crop(편집)작업을 하기 위해 옵션 설정
        UCrop.Options options = new UCrop.Options();
        options.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        options.setMaxBitmapSize(1024*1024*2); //1K*1K*2 = 2Mbyte 언더


        RxPaparazzo.takeImage(getActivity())
                .size(new SmallSize()) //사이즈(Small size, Screen size, Original size, Custom size)
                .crop(options) //편집
                .useInternalStorage() //내부 저장(안 쓰면 외부 공용 공간에 App이름으로 생성됨)
                .usingCamera() //카메라 사용
                .subscribeOn(Schedulers.io()) //IO
                .observeOn(AndroidSchedulers.mainThread()) //쓰레드 설정
                .subscribe(response -> { //결과 처리
                    // See response.resultCode() doc
                    //실패 처리
                    if (response.resultCode() != RESULT_OK) {
                        // response.targetUI().showUserCanceled();
                        return;
                    }

                    loadImage(response.data());
                });

    }

    //    public void onCamera() {
//        //crop(편집)작업을 하기 위해 옵션 설정
//        UCrop.Options options = new UCrop.Options();
//        options.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
//        options.setMaxBitmapSize(1024*1024*2); //1K*1K*2 = 2Mbyte 언더
//
//
//        RxPaparazzo.takeImage(getActivity())
//                .size(new SmallSize()) //사이즈(Small size, Screen size, Original size, Custom size)
//                .crop(options) //편집
//                .useInternalStorage() //내부 저장(안 쓰면 외부 공용 공간에 App이름으로 생성됨)
//                .usingCamera() //카메라 사용
//                .subscribeOn(Schedulers.io()) //IO
//                .observeOn(AndroidSchedulers.mainThread()) //쓰레드 설정
//                .subscribe(response -> { //결과 처리
//                    // See response.resultCode() doc
//                    //실패 처리
//                    if (response.resultCode() != RESULT_OK) {
//                        // response.targetUI().showUserCanceled();
//                        return;
//                    }
//
//
//                    loadImage(response.data());
//                });
//
//    }
    public void onGallery() { //이미지 데이터

        //crop(편집)작업을 하기 위해 옵션 설정
        UCrop.Options options = new UCrop.Options();
        options.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        options.setMaxBitmapSize(1024*1024*2); //1K*1K*2 = 2Mbyte 언더

        RxPaparazzo.takeImage(getActivity())
                .size(new SmallSize()) //사이즈(Small size, Screen size, Original size, Custom size)
                .crop(options) //편집
//                .useInternalStorage() //내부 저장(안 쓰면 외부 공용 공간에 App이름으로 생성됨)
                .usingGallery()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    // See response.resultCode() doc
                    if (response.resultCode() != RESULT_OK) {
                        //response.targetUI().showUserCanceled();
                        return;
                    }
                    Log.i("PH",response.data());
                    loadImage(response.data());
                });
    }
    public void loadImage(String path){
        alert.dismissWithAnimation();
        Log.d("Test","url :   "+path+"");
        Log.d("Test","context :   "+context.toString()+"");
        Log.d("Test","cameraimageView :   "+cameraimageView.toString()+"");
        //이미지 뷰에 이미지를 셋팅   //path : /data/data/com.example.tacademy.photoprocessing/files/PhotoProcessing/파일명.jpg
        String url = "file://"+path;

        Picasso.with(context).setLoggingEnabled(true);
        Picasso.with(context).setIndicatorsEnabled(true);
        Picasso.with(context).invalidate(url);
        Picasso.with(context).load(url).into(cameraimageView);


        FirebaseStorage storage = FirebaseStorage.getInstance(); //시작하기
        ////////////////파일 삭제/////////////////////////////////////
        // 나무 기둥의 주소
        StorageReference delFileRef   =
//                storage.getReferenceFromUrl("gs://newjp-a4338.appspot.com/Lighthouse.jpg");
        storage.getReferenceFromUrl("gs://databasetest-b3068.appspot.com");


        delFileRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i("KK", "성공");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Uh-oh, an error occurred!
                Log.i("KK", "실패:"+exception.getMessage());
            }
        });
        ////////////////파일 업로드//업로드 방식 3가지 : 이미지 뷰, 스트링, 로컬
        //나무 기둥의 주소(파이어베이스의 <참조하기>의 코딩 복붙)
        StorageReference root = storage.getReferenceFromUrl("gs://databasetest-b3068.appspot.com"); //storage.getReferenceFromUrl 먼저 코딩 짜고 위로 찾아가서 뿌리 만들기
        //new File(path); //파일을 붙이고 위에서 또 붙이니 못 찾는것이므로
        Uri uri = Uri.fromFile(new File(path));
        //내 프로필 사진이 등록되는 최종 경로
        String uploadName = "profile/" + uri.getLastPathSegment(); //"file://"+path; url이 있으니 정보를 얻기 위하여 file을 만들어야됨
        //나무 기둥에 참조 경로인 가지 등록(파이어베이스의 <파일 업로드>의 코딩 복붙)
        StorageReference riversRef = root.child("images/"+uri.getLastPathSegment());
        //업로드
        UploadTask uploadTask = riversRef.putFile(uri);
        //이벤트 등록 및 처리
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //실패 -> 재시도를 하게끔 유도
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadUrl = taskSnapshot.getDownloadUrl();  //downLoadUrl.toString() => 프로필 정보로 업데이트
                //SharedPreferences sp = getSharedPreferences("autologin", MODE_PRIVATE);
                //SharedPreferences.Editor editor = sp.edit();
                //editor.putString("url", downloadUrl.toString());
                //editor.commit();
                Log.i("Test","프로필 사진 URl ; " + downloadUrl.toString());
                //downloadUrl.toString();
                Log.i("Test","SharedPreference에 사진 저장");
                Log.i("Test", downloadUrl.toString());
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                //진행율
                float rate = (taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount())*100.0f;
                Log.i("Test", "진행율"+rate);
            }
        });

    }


    /////////////////////////////////////////////
    private CustomDialog mCustomDialog;
    public void onClickDialogJp(View v) {
        switch (v.getId()) {
            case R.id.scoretoastjp:
                mCustomDialog = new CustomDialog(getActivity(),
                        "", // 제목
                        "", // 내용
                        "",
                        leftListener, // 왼쪽 버튼 이벤트
                        rightListener, // 오른쪽 버튼 이벤트
                        centerListener);
                mCustomDialog.show();
                break;
        }

    }
    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getActivity(), "왼쪽버튼 클릭",
                    Toast.LENGTH_SHORT).show();
            mCustomDialog.dismiss();
        }
    };
    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getActivity(), "오른쪽버튼 클릭",
                    Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener centerListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getActivity(), "스코어버튼 클릭",
                    Toast.LENGTH_SHORT).show();
        }
    };
    /////////////////////////////////////
    private CustomDialogTwo mCustomDialogTwo;
    public void onClickDialogJpTwo(View v) {
        switch (v.getId()) {
            case R.id.alleysearchjp:
                mCustomDialogTwo = new CustomDialogTwo(getActivity(),
                        "", // 제목
                        leftListenerTwo, // 왼쪽 버튼 이벤트
                        rightListenerTwo); // 오른쪽 버튼 이벤트
                mCustomDialogTwo.show();
                break;
        }

    }
    private View.OnClickListener leftListenerTwo = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getActivity(), "왼쪽버튼 클릭",
                    Toast.LENGTH_SHORT).show();
            mCustomDialogTwo.dismiss();
        }
    };
    private View.OnClickListener rightListenerTwo = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getActivity(), "오른쪽버튼 클릭",
                    Toast.LENGTH_SHORT).show();
        }
    };

    /////////////////////////////////////////////////////
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }










    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}