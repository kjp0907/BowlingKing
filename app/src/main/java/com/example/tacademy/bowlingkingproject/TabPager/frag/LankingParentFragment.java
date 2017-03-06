package com.example.tacademy.bowlingkingproject.TabPager.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.Message.ScoreViewHolder;
import com.example.tacademy.bowlingkingproject.TabPager.model.BowlingInfo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public abstract class LankingParentFragment extends Fragment{
    public LankingParentFragment() {
        // Required empty public constructor
    }
    Fragment fragment_register;
    RecyclerView recyclerView;
    FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;


    public abstract Query getQuery(DatabaseReference databaseReference);


    // 출처: http://es1015.tistory.com/126 [안드로이드 개발 / 폰꾸미기]
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

/*

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for(int i=0;i<tabHost.getTabWidget().getChildCount();i++){
                    tabHost.getTabWidget().getChildAt(i)
                            .setBackgroundColor(Color.parseColor("#255187"));
                }
                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab())
                        .setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });

*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lanking, container, false);



        //.setText();
        // 화면 구성 세팅..
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewLanking);
        // 레이아웃 세팅
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 쿼리수행
        Query querylanking = getQuery(FirebaseDatabase.getInstance().getReference());
        // 아답터 생성
        firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<BowlingInfo, ScoreViewHolder >(
                BowlingInfo.class,
                R.layout.cell_lanking_layout,
                ScoreViewHolder.class,
                // 쿼리 결과
                querylanking
        ){
            @Override
            protected void populateViewHolder(ScoreViewHolder locationHolder, BowlingInfo model, int position) {
                // 1. position -> 데이터 획득 (참조 획득)
                final DatabaseReference databaseReference = getRef(position);
                // 2. viewHolder-> 이벤트 등록

                String key = databaseReference.child("posts").push().getKey();

              //  viewHolder.

               // locationHolder.getLocation().setText(model.getLocation()); //
             //   locationHolder.getScore().setText(model.getScore()); //

                locationHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });



                //linearLayoutManager.scrollToPosition(0);
            }
        };
        recyclerView.setAdapter( firebaseRecyclerAdapter );

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
