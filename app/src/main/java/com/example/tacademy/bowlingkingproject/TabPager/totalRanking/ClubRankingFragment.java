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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClubRankingFragment extends Fragment {

    ListView club_total_listview;
    ListViewAdater totalAdapter;
   // MyListViewAdapter myAdapter;// [ 주석 풀기 ]===========================================================================


    //ArrayList<ClubArrayList> clubArrayLists;
    ArrayList<ConData> clubArrayLists;

    Response<ResAll> ress; // 데이터 배열로 받으려면

    //나의 랭킹 관련
    TextView myclubranking,myclubname,myclubscore;

    public ClubRankingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_club_ranking, container, false);

        clubArrayLists = new ArrayList<ConData>();


        myclubranking = (TextView)view.findViewById(R.id.myclubranking);
        myclubname = (TextView)view.findViewById(R.id.myclubname);
        myclubscore = (TextView)view.findViewById(R.id.myclubscore);


        // [ 서버 통신 ] 동호회 =========================================================


        Call<ResAll> res = NetSSL.getInstance().getMemberImpFactory().ranklist_two("1", "-1", "1", "30");
        res.enqueue(new Callback<ResAll>() {
            @Override
            public void onResponse(Call<ResAll> call, Response<ResAll> response) {

                if(response.isSuccessful())
                {
                    clubArrayLists.addAll(response.body().getResult().getRankData().getData());
                    totalAdapter.notifyDataSetChanged();
                    myclubranking.setText(response.body().getResult().getMyData().getMyRank());
                    myclubname.setText(response.body().getResult().getMyData().getMyNick());
                    myclubscore.setText(response.body().getResult().getMyData().getBestScore());
                }

                else
                {
                    Log.i("RFRF","통신 실패");

                }
                Log.i("로그인됐고","나와라");

                //  Log.i("zz",""+response.body().getResult().getRankData().getData());

                Log.i("login","dd");
//
            }


            @Override
            public void onFailure(Call<ResAll> call, Throwable t) {
                Log.d("onFailure", "로그인2222222 실패");
            }
        });

        //================================================================================================





        club_total_listview = (ListView) view.findViewById(R.id.club_total_listview);
        totalAdapter = new ListViewAdater();

        club_total_listview.setAdapter(totalAdapter);

// [ 주석 풀기] ===========================================================================
//        club_my_listview = (ListView)view.findViewById(R.id.club_my_listview);
//        myAdapter =new MyListViewAdapter();
//
//        club_total_listview.setAdapter(totalAdapter);
//        club_my_listview.setAdapter(myAdapter);
//===========================================================================



        return view;







    }



    class ViewHolder {

        @BindView(R.id.club_ranking)
        TextView club_ranking;

        @BindView(R.id.club_nickname)
        TextView club_nickname;

        @BindView(R.id.club_score)
        TextView club_score;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    class ViewMyHolder{

        @BindView(R.id.club_ranking)
        TextView club_my_ranking;

        @BindView(R.id.club_nickname)
        TextView club_my_nickname;

        @BindView(R.id.club_score)
        TextView club_my_score;

        public ViewMyHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    String []data = { "안녕", "안녕1", "안녕2"};









    class ListViewAdater extends BaseAdapter {
        @Override
        public int getCount() {
            return clubArrayLists.size();
        }

        @Override
        public ConData getItem(int position) {
            return clubArrayLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder clubholder;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.club_list_item, null);
                clubholder = new ViewHolder(convertView);
                convertView.setTag(clubholder);
            } else {
                clubholder = (ViewHolder) convertView.getTag();
            }
            Log.i("리스트뷰","된다");
            // Log.i("dataaaaaa", "" + ress.body().getResult().getRankData().getData().get(position).toString());
            ConData cond =clubArrayLists.get(position);
            clubholder.club_nickname.setText(cond.getUserName());
            clubholder.club_ranking.setText(cond.getRankNum());
            clubholder.club_score.setText(cond.getPlayScore());


            return convertView;
        }
    }

}
