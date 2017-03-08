package com.example.tacademy.bowlingkingproject.TabPager.totalRanking;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.ConData;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ResAll;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClubRankingFragment extends Fragment {

    ListView club_my_listview, club_total_listview;
    ListViewAdater totalAdapter;
   // MyListViewAdapter myAdapter;// [ 주석 풀기 ]===========================================================================


    //ArrayList<ClubArrayList> clubArrayLists;
    ArrayList<ConData> clubArrayLists;

    Response<ResAll> ress; // 데이터 배열로 받으려면

    public ClubRankingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //arraylist  : 한번에 여러개의 변수들을 담고싶을 때
      //  clubArrayLists = new ArrayList<ClubArrayList>(); //생성자

   //     ClubArrayList clubArrayList = new ClubArrayList(1,1,"민서룽");

       // clubArrayLists.add(clubArrayList);
        //컬렉션 많이 저장한거 나열할때 쓴다.iterator()

      // Log.i("dd",clubArrayList.toString());

        View view = inflater.inflate(R.layout.fragment_club_ranking, container, false);

        clubArrayLists = new ArrayList<ConData>();




        // [ 서버 통신 ] 동호회 =========================================================


        Call<ResAll> res = NetSSL.getInstance().getMemberImpFactory().ranklist_two("1", "-1", "1", "5");
        res.enqueue(new Callback<ResAll>() {
            @Override
            public void onResponse(Call<ResAll> call, Response<ResAll> response) {

                if(response.isSuccessful())
                {
                    clubArrayLists.addAll(response.body().getResult().getRankData().getData());
                    totalAdapter.notifyDataSetChanged();
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


    //일시 설정
    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        final View v = rootView;
// Spinner element
        Spinner spinner_year = (Spinner) rootView.findViewById(R.id.spinner_year);
        Spinner spinner_month = (Spinner) rootView.findViewById(R.id.spinner_month);
        Spinner spinner_day = (Spinner) rootView.findViewById(R.id.spinner_day);

//spinner.setOnItemClickListener(this);

// Spinner Drop down elements






        // spinner 날짜설정 ===================================================================
        List<String> categories_year = new ArrayList<String>();
        categories_year.add("2016");
        categories_year.add("2017");
        categories_year.add("2018");

        List<String> categories_month = new ArrayList<String>();
        categories_month.add("1");
        categories_month.add("2");
        categories_month.add("3");
        categories_month.add("4");
        categories_month.add("5");
        categories_month.add("6");
        categories_month.add("7");
        categories_month.add("8");
        categories_month.add("9");
        categories_month.add("10");
        categories_month.add("11");
        categories_month.add("12");



        List<String> categories_day = new ArrayList<String>();
        categories_day.add("1");
        categories_day.add("2");
        categories_day.add("3");
        categories_day.add("4");
        categories_day.add("5");
        categories_day.add("6");
        categories_day.add("7");
        categories_day.add("8");
        categories_day.add("9");
        categories_day.add("10");
        categories_day.add("11");
        categories_day.add("12");
        categories_day.add("13");
        categories_day.add("15");
        categories_day.add("16");
        categories_day.add("17");
        categories_day.add("18");
        categories_day.add("19");
        categories_day.add("20");
        categories_day.add("21");
        categories_day.add("22");
        categories_day.add("23");
        categories_day.add("24");
        categories_day.add("25");
        categories_day.add("26");
        categories_day.add("27");
        categories_day.add("28");
        categories_day.add("29");
        categories_day.add("30");
        categories_day.add("31");


        ArrayAdapter<String> dataAdapter_Year = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories_year);
        dataAdapter_Year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Drop down layout style - list view with radio button
        spinner_year.setAdapter(dataAdapter_Year);



        ArrayAdapter<String> dataAdapter_Month = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories_month);
        dataAdapter_Month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Drop down layout style - list view with radio button
        spinner_month.setAdapter(dataAdapter_Month);


        ArrayAdapter<String> dataAdapter_Day = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories_day);
        dataAdapter_Day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Drop down layout style - list view with radio button
        spinner_day.setAdapter(dataAdapter_Day);

        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();


                // Showing selected spinner item  날짜 숫자로 가져오는 방법 여기 참조 !
             //   Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();


                // Showing selected spinner item  날짜 숫자로 가져오는 방법 여기 참조 !
                //   Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinner_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();


                // Showing selected spinner item  날짜 숫자로 가져오는 방법 여기 참조 !
                //   Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




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

        /*
        public ViewHolder(View view) {

            *//*club_ranking = (TextView) view.findViewById(R.id.club_ranking);
            club_nickname = (TextView) view.findViewById(R.id.club_nickname);
            club_score = (TextView) view.findViewById(R.id.club_score);*//*
        }*/
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
/*
    class MyListViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
                    return clubArrayLists.size();
        }

        @Override
        public ConData getItem(int position) {
                    return clubArrayLists[position];
        }//저장된 값의 위치 가져오는것

        @Override
        public long getItemId(int position) {
            return 0;
        }               // id 넣는건데 안쓴다.

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //홀더에 값을 대입한다.
            ViewMyHolder holder;

            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.club_list_item, null);
                holder = new ViewMyHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder = (ViewMyHolder) convertView.getTag();
            }

            holder.club_my_nickname.setText(getItem(position).getClub_array_nickname());
            holder.club_my_ranking.setText(getItem(position).getCa_rank()+"");
            holder.club_my_score.setText(getItem(position).getCa_score()+"");

            return convertView;
        }
    }
*/
}
