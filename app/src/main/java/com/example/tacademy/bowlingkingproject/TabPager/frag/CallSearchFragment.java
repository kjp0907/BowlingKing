package com.example.tacademy.bowlingkingproject.TabPager.frag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResDetail;
import com.example.tacademy.bowlingkingproject.imageProc;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallSearchFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    ViewPager viewPager;
    JPAdapter jpAdapter;
    TextView curDotjp;

    TextView bestScore,countGame;

//    String[] poster =
//            {
//                    "http://foundry-wp.com/wp-content/Cimy_Header_Images/0/bowling2.jpg",
//                    "https://www.google.co.kr/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjL0PqQpoTSAhUBwJQKHV6fCXsQjRwIBw&url=http%3A%2F%2Fcloudpeaklanes.com%2F&psig=AFQjCNHOZQ4sOOKOULl8QEfFav8AhTDuFw&ust=1486773698373956",
//                    "http://foundry-wp.com/wp-content/Cimy_Header_Images/0/bowling2.jpg",
//                    "https://www.google.co.kr/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjT5ZKopoTSAhVFW5QKHUTCBUYQjRwIBw&url=http%3A%2F%2Fgirardindians.org%2Fboys_bowling&psig=AFQjCNFECYwqct5ZKazC989B_b2OCeYFmw&ust=1486773822316554"
//            };


    MyAdapter myAdapter, myAdapter1, myAdapter2, myAdapter3, myAdapter4;
    // 전번 검색후 나온 결과를 받아온 객체이다.( otto bus를 통하여 세팅됨 )
    //ResSearchHp resSearchHp;
    LayoutInflater inflater;
    //////================================================================================================
    //jpadapter
    class JPAdapter extends PagerAdapter {

        Context context;
        Bitmap galImage;
        BitmapFactory.Options options;

        private final int[] galImages = new int[]{
                R.drawable.bowling1,
                R.drawable.bowling2,
                R.drawable.bowling3

        };

        JPAdapter(Context context) {
            this.context = context;
            options = new BitmapFactory.Options();
        }


        @Override
        public int getCount() {
            return galImages.length;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
            //super.destroyItem(container, position, object);
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            String url = galImages[position];
            //ImageView imageView = new ImageView(MainActivity.this);
            ImageView imageView = new ImageView(context); //승표형은 context로 했떤데 이유는 걍 빨간불 꺼져서..

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            options.inSampleSize = 3;

            galImage = BitmapFactory.decodeResource(context.getResources(), galImages[position], options);

            imageView.setImageBitmap(galImage);
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }
    }//JPAdapter


    //////================================================================================================
    public CallSearchFragment() {
        //이벤트 받을 녀석 설정( 액티비티, 플래그먼트)
        // POST로 보낸걸 Register로 받는다
        //  OTTOBus.getInstance().getBus().register(this);
    }
    public static CallSearchFragment newInstance(String param1, String param2) {
        CallSearchFragment fragment = new CallSearchFragment();
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        View view = inflater.inflate(R.layout.fragment_call_search, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPagerjp);
        curDotjp = (TextView) view.findViewById(R.id.curDotjp);
        jpAdapter = new JPAdapter(getContext());
        viewPager.setAdapter(jpAdapter);
        imageProc.getInstance().getImageLoader(getContext()); //지원이형이 찾아준 한줄


        //[최고점수, 게임수] ==================
        bestScore = (TextView)view.findViewById(R.id.bestscore);
        countGame = (TextView)view.findViewById(R.id.countgame);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                changeDot(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        pagerCurPage = 0;
        ackHandler.sendEmptyMessageDelayed(0, 1000*2);
        ///////////////////////////////////////////////////////////////
        myAdapter = new MyAdapter();
        myAdapter1 = new MyAdapter();
        myAdapter2 = new MyAdapter();
        myAdapter3 = new MyAdapter();
        myAdapter4 = new MyAdapter();


        // [서버 통신으로 최고점수, 개인기록 count 가져오기]

        Toast.makeText(getContext(), "개인기록 가져오기 ", Toast.LENGTH_SHORT).show();
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
                        ResDetail resDetail = response.body();

                        Log.i("결과 값은? : " , resDetail.getResult().getUserData().getBestScore() + " : " + resDetail.getResult().getUserData().getCountGame());

                        bestScore.setText(""+resDetail.getResult().getUserData().getBestScore());
                        countGame.setText(""+resDetail.getResult().getUserData().getCountGame());

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





        return view;
    }
    int pagerCurPage;
    Handler ackHandler = new Handler(){ //12월 28일에 했던 2초 버퍼뒤에 넘어가는 것 => 헨들러
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0 : {
                    pagerCurPage++;
                    int page = pagerCurPage % 3; // 0123 0123 0123
                    viewPager.setCurrentItem(page);
                    sendEmptyMessageDelayed(0, 1000*2);
                }
                break;
            }
        }
    };
    //하단 페이지 도트 변경
    public void changeDot(int position)
    {
        //도트 4개 넣어도 되지만 확장성이 없으니 일반화 시키기 위해 logic!!
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<3; i++)
        {
            if(i==position)
                sb.append("● ");
            else
                sb.append("○ ");
        }
        //버퍼 -> String -> 앞뒤 공백 제거(trim) -> 화면 반영
        curDotjp.setText(sb.toString().trim());
    }
    ////////////////////////////////////////////////////////////////////////////
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

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return convertView;
        }
    }
///////////////////////////////////////////////////////////////////


}