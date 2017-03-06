package com.example.tacademy.bowlingkingproject.TabPager.totalRanking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.ConData;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ResAll;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlleyRankingFragment extends Fragment {
    ListView alley_my_listview, alley_total_listview;

    ArrayList<ConData> alleyArrayLists;

    ArrayList<AlleyArrayList> alleyMyArrayLists;

    AlleyListViewAdapter total_all_adapter;
    AlleyMyListViewAdpater my_all_adapter;
    Response<ResAll> ress;

    public AlleyRankingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alley_ranking, container, false);
        alleyArrayLists = new ArrayList<ConData>();
        // [서버통신] =================================================================================
        Call<ResAll> res =  NetSSL.getInstance().getMemberImpFactory().ranklist_two("0", "-1", "1", "5");

        res.enqueue(new Callback<ResAll>() {
                        @Override
                        public void onResponse(Call<ResAll> call, Response<ResAll> response) {

                            if(response.isSuccessful())
                            {
                                alleyArrayLists.addAll(response.body().getResult().getRankData().getData());
                                total_all_adapter.notifyDataSetChanged();

                                Log.d("login", "onResponse" + new Gson().toJson(response.body().getResult().getRankData().getData()));

                            }

                            else
                            {
                                Log.i("RFRF","통신 실패");

                            }


                        }


            @Override
            public void onFailure(Call<ResAll> call, Throwable t) {
                Log.d("onFailure", "로그인2222222 실패");
            }
        });

        //================================================================================================
//
//        AlleyArrayList alleyArrayList = new AlleyArrayList
//                (new Gson().toJson(ress.body().getResult().getRankData().getData().get(0).getRankNum())
//                        ,new Gson().toJson(ress.body().getResult().getRankData().getData().get(0).gt()),"룰루랄라");
//
//
//        if (ress != null) {
//            Log.i("ress", "ress" + ress.toString());
//            AlleyArrayList alleyArrayList = new AlleyArrayList
//                    (ress.body().getResult().getRankData().getData().get(0).getRankNum().toString(),
//                            ress.body().getResult().getRankData().getData().get(0).getPlayScore().toString(),
//                            ress.body().getResult().getRankData().getData().get(0).getUserName().toString()
//                    );
//
//            alleyArrayLists.add(alleyArrayList);
//        } else {
//        }

        //alleyArrayLists = new ArrayList<ConData>();
        //AlleyArrayList alleyArrayList = new AlleyArrayList("2","2","2");



        alley_total_listview = (ListView) view.findViewById(R.id.alley_total_listview);
        total_all_adapter = new AlleyListViewAdapter();

        alley_total_listview.setAdapter(total_all_adapter);
        //alleyArrayLists.add(alleyArrayList);

        //================================================================================================

        alleyMyArrayLists = new ArrayList<AlleyArrayList>();

        AlleyArrayList alleyMyArrayList = new AlleyArrayList("1", "12", "룰루랄라");
        alleyMyArrayLists.add(alleyMyArrayList);
//
//        AlleyArrayList alleyMyArrayList1 = new AlleyArrayList("1", "12", "룰루랄라");
//        alleyMyArrayLists.add(alleyMyArrayList1);


        alley_my_listview = (ListView) view.findViewById(R.id.alley_my_listview);
        my_all_adapter = new AlleyMyListViewAdpater();

//        alley_my_listview.setAdapter(my_all_adapter);


        return view;


    }


    class ViewAlleyTotalHolder {

        @BindView(R.id.alley_ranking)
        TextView alley_ranking;

        @BindView(R.id.alley_nickname)
        TextView alley_nickname;

        @BindView(R.id.alley_score)
        TextView alley_score;

        public ViewAlleyTotalHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


    class ViewAlleyMyHolder {

        @BindView(R.id.alley_ranking)
        TextView alley_my_ranking;

        @BindView(R.id.alley_nickname)
        TextView alley_my_nickname;

        @BindView(R.id.alley_score)
        TextView alley_my_score;

        public ViewAlleyMyHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    class AlleyListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return alleyArrayLists.size();
        }

        @Override
        public ConData getItem(int position) {
            return alleyArrayLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewAlleyTotalHolder alleyholder;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.alley_list_item, null);
                alleyholder = new ViewAlleyTotalHolder(convertView);
                convertView.setTag(alleyholder);
            } else {
                alleyholder = (ViewAlleyTotalHolder) convertView.getTag();
            }

           // Log.i("dataaaaaa", "" + ress.body().getResult().getRankData().getData().get(position).toString());
            ConData cond =alleyArrayLists.get(position);
            alleyholder.alley_nickname.setText(cond.getUserName());
            alleyholder.alley_ranking.setText(cond.getRankNum());
            alleyholder.alley_score.setText(cond.getPlayScore());


            return convertView;
        }
    }

    class AlleyMyListViewAdpater extends BaseAdapter {
        @Override
        public int getCount() {
            return alleyMyArrayLists.size();
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public AlleyArrayList getItem(int position) {
            return alleyMyArrayLists.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewAlleyMyHolder alleymyholder;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.alley_list_item, null);
                alleymyholder = new ViewAlleyMyHolder(convertView);
                convertView.setTag(alleymyholder);
            } else {
                alleymyholder = (ViewAlleyMyHolder) convertView.getTag();
            }

            alleymyholder.alley_my_nickname.setText(getItem(position).getAa__nickname());
            alleymyholder.alley_my_ranking.setText(getItem(position).getAa_rank() + "");
            alleymyholder.alley_my_score.setText(getItem(position).getAa_score() + "");


            return convertView;
        }
    }

}
