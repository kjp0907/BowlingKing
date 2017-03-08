package com.example.tacademy.bowlingkingproject.TabPager.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.AllRecordScoreData;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResAllRecord;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaceBookFragment extends Fragment {
    Fragment fragment;
    private ExpandableListView listView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    //////////////////////////////////////////////////////
    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    private ExpandableListView mListView;
    View view;
    BaseExpandableAdapter baseExpandableAdapter;


    //자신의 기록 가져오기
    ArrayList<AllRecordScoreData> MyDataList;
    ListViewAdpater MyListAdpater;

    public FaceBookFragment() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_face_book, container, false);
        Button button = (Button) view.findViewById(R.id.button41);
        Button button2 = (Button) view.findViewById(R.id.button42);

        button.setBackgroundResource(R.drawable.round_left_red);
        button2.setBackgroundResource(R.drawable.round_right_white);
        button.setTextColor(getResources().getColorStateList(R.color.white));
        button2.setTextColor(getResources().getColorStateList(R.color.black));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼 누르면 배경색, 글자 색 변경
                changeOne();
                button.setBackgroundResource(R.drawable.round_left_red);
                button2.setBackgroundResource(R.drawable.round_right_white);
                button.setTextColor(getResources().getColorStateList(R.color.white));
                button2.setTextColor(getResources().getColorStateList(R.color.black));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTwo();
                button.setBackgroundResource(R.drawable.round_left_white);
                button2.setBackgroundResource(R.drawable.round_right_red);
                button2.setTextColor(getResources().getColorStateList(R.color.white));
                button.setTextColor(getResources().getColorStateList(R.color.black));
            }
        });
        changeOne();
        //////////////////////////////////////////////////////////////////////

        Display newDisplay = getActivity().getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();

        ArrayList<ExpandMyGroup> DataList = new ArrayList<ExpandMyGroup>();
        listView = (ExpandableListView) view.findViewById(R.id.elv_list);
//        ExpandMyGroup temp = new ExpandMyGroup("");
//        temp.child.add("");
//        DataList.add(temp);
//        temp = new ExpandMyGroup("");
//        temp.child.add("");
//        DataList.add(temp);
//        temp = new ExpandMyGroup("");
//        temp.child.add("");
//        DataList.add(temp);


        MyDataList = new ArrayList<AllRecordScoreData>();


        //사진& 기록 보여주기
        Call<ResAllRecord> res = NetSSL.getInstance().getMemberImpFactory().nineAllRecord(1, 3);
        res.enqueue(new Callback<ResAllRecord>() {
            @Override
            public void onResponse(Call<ResAllRecord> call, Response<ResAllRecord> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().getResult() != null) {
//                        Log.i("RF", "메인정보 가져오기 성공 :" + response.body().getResult().getScore().getData().get(1).getPic());

                        Log.i("RF", "메인정보 가져오기 성공 :" + new Gson().toJson(response.body()));
                        Log.i("RF", "zz" + response.body().getResult().getScore().getData());


                        MyDataList.addAll(response.body().getResult().getScore().getData());
                        MyListAdpater = new ListViewAdpater();
//                        MyListAdpater.notifyDataSetChanged();



                        // 20170306 동연
                        int size = response.body().getResult().getScore().getData().size();
                        String[] pictureUrls = new String[size];
                        pictureUrls[0] = response.body().getResult().getScore().getData().get(0).getPic();


                        for (int i = 0; i < size; i++) {
                            pictureUrls[i] = response.body().getResult().getScore().getData().get(i).getPic();

                        }
                        for (int i = 0; i < size; i++) {
                            DataList.add(new ExpandMyGroup(response.body().getResult().getScore().getData().get(i).getPlayPlaceName(),
                                    response.body().getResult().getScore().getData().get(i).getPlayDate(),
                                    response.body().getResult().getScore().getData().get(i).getPlayScore()
                                    //,response.body().getResult().getScore().getData().get(i).getScoreId()
                            ));

                        }
                        ExpandAdapter adapter = new ExpandAdapter(getActivity().getApplicationContext(), R.layout.selfrecord_up, R.layout.selfrecord_down, DataList, pictureUrls,MyDataList);
                        listView.setAdapter(adapter);

                    } else {
                        Log.i("RF", "메인정보 가져오기 실패1:" + response.message());
                    }
                } else {
                    Log.i("RF", "메인정보 가져오기 실패2:" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResAllRecord> call, Throwable t) {
                Log.i("RF", "메인정보 가져오기 통신오류" + t.getMessage());
            }
        });




        return view;
    }

    class ViewMyHolder {

        @BindView(R.id.myscore)
        TextView myscore;
        @BindView(R.id.mydateself)
        TextView mydateself;
        @BindView(R.id.mycenter)
        TextView mycenter;

        public ViewMyHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    class ListViewAdpater extends BaseAdapter {
        @Override
        public int getCount() {
            return MyDataList.size();
        }

        @Override
        public AllRecordScoreData getItem(int position) {
            return MyDataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewMyHolder myHolder;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.club_list_item, null);
                myHolder = new ViewMyHolder(convertView);
                convertView.setTag(myHolder);
            } else {
                myHolder = (ViewMyHolder) convertView.getTag();
            }
            Log.i("리스트뷰", "된다");
            // Log.i("dataaaaaa", "" + ress.body().getResult().getRankData().getData().get(position).toString());
            AllRecordScoreData cond = MyDataList.get(position);
            myHolder.myscore.setText(cond.getPlayScore());
            myHolder.mycenter.setText(cond.getPlayPlaceName());
            myHolder.mydateself.setText(cond.getPlayDate());

            return convertView;
        }
    }


    //////////////////////////////////////////////////
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        if(convertView == null){
//            convertView = myinf.inflate(this.groupLayout, parent, false);
//        }
//        TextView groupName = (TextView)convertView.findViewById(R.id.moreSee);
//        groupName.setText(DataList.get(groupPosition).groupName);
//        return convertView;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        if(convertView == null){
//            convertView = myinf.inflate(this.chlidLayout, parent, false);
//        }
//        ImageView childName = (ImageView)convertView.findViewById(R.id.childPicture);
//        childName.setText(DataList.get(groupPosition).child.get(childPosition));
//        return convertView;
//    }
    ///////////////////////////////////////////////////////

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

    public void changeOne() {
        mListView = (ExpandableListView) view.findViewById(R.id.elv_list);

    }

    public void changeTwo() {
        Toast.makeText(getActivity(), "아직 시연되지 않았습니다", Toast.LENGTH_SHORT).show();
        return;
    }

    ///////////////////////////////////////////////////////////////
    public void loadProfile(Context context, Class<?> cls) {

    }
//    // 프로필 사진을 배경사진으로 활용하기 위한 함수
//    public void changeimage(ImageView imageView) {
//        android.util.Log.i("RF","배경 변경 함수호출" + U.KEY.PROFILE);
//
//        Picasso.with(this)
//                .load(U.KEY.PROFILE) // 사진 URl
//                //.transform(new BlurTransformation(this, 10))
//                .into(imageView); // 사진을 띄울 ImageView
//    }


}