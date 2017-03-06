package com.example.tacademy.bowlingkingproject.TabPager.Message;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.model.Post;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class MessageTwoParentFragment extends Fragment {


    Fragment fragment_register;
    RecyclerView recyclerView;
    FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    public MessageTwoParentFragment() {
        // Required empty public constructor
    }

    Button write_board;
   // TextView contents;
    public abstract Query getQuery(DatabaseReference databaseReference);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_two, container, false);

        // 화면 구성 세팅..
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        // 레이아웃 세팅
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        write_board = (Button) view.findViewById(R.id.write);
        //this.inflater = inflater;
        write_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Write_Board();
            }
        });

        //.setText();
        // 화면 구성 세팅..
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        // 레이아웃 세팅
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 쿼리수행
        Query query = getQuery(FirebaseDatabase.getInstance().getReference());
        // 아답터 생성
        firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<Post, PostViewHolder>(
                Post.class,
                R.layout.cell_post_layout,
                PostViewHolder.class,
                // 쿼리 결과
                query
        ){
            // 레이아웃을 담기는 그릇, 데이터가 담기를 그릇, 필요한 인덱스
            @Override
            protected void populateViewHolder(PostViewHolder viewHolder, Post model, int position) {
                // 1. position -> 데이터 획득 (참조 획득)


                final DatabaseReference databaseReference = getRef(position);
                String key = databaseReference.child("posts").push().getKey();
                Log.i("여기는 먹히려나몰겠네","먹혀요");
                // 2. viewHolder-> 이벤트 등록
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        // 상세보기로 이동
                        Log.i("터치먹히나","터치 먹혀요!");  //일단 여기 안먹힘 onClick 자체가 안먹힘..

                        Intent intent = new Intent(getContext(), PostDetailActivity.class);
                        intent.putExtra("KEY", databaseReference.getKey());
                        getContext().startActivity(intent);
                    }


                });

                viewHolder.getContent().setText(model.getContent()); // ****** 내용 띄우게 하능거..
             //   databaseReference.child("posts").child(key);

                // 2. viewHolder-> 이벤트 등록viewHolder.
              //  viewHolder.getContent().setText();

            }
        };
        recyclerView.setAdapter( firebaseRecyclerAdapter );


        return view;

    }



    public void Write_Board(){
        Intent intent =new Intent(getActivity(),NewPostActivity.class);
       getActivity().startActivity(intent);
    }

}
