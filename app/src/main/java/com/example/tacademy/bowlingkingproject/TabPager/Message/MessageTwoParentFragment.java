package com.example.tacademy.bowlingkingproject.TabPager.Message;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tacademy.bowlingkingproject.Dialog.DeleteDialog;
import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ArticleData;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResCirclesTwentyFour;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class MessageTwoParentFragment extends Fragment {


    Fragment fragment_register;
    FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    //게시글 불러오기
    ArrayList<ArticleData> boardlists;
    BoardListViewAdpater boardAdpater;
    ListView recyclerView;
    TextView centernames,boarddate;



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
        recyclerView=(ListView)view.findViewById(R.id.recyclerView);
        centernames=(TextView)view.findViewById(R.id.centernames);
        boarddate=(TextView)view.findViewById(R.id.boarddate);


        // 화면 구성 세팅..
        write_board=(Button)view.findViewById(R.id.write);
        // 레이아웃 세팅

        boardlists = new ArrayList<ArticleData>();


        write_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Write_Board();
            }
        });



        //게시판 리스트 보여주기==================================================================

        Call<ResCirclesTwentyFour> res = NetSSL.getInstance().getMemberImpFactory().twentyFourCircleSearch(-1,1,30); //page 1, row 20 일경우 page1 개당 20개의 리스트를 보여준다.
        res.enqueue(new Callback<ResCirclesTwentyFour>() {
            @Override
            public void onResponse(Call<ResCirclesTwentyFour> call, Response<ResCirclesTwentyFour> response) {
                if (response.isSuccessful()) {
                    if( response.body()!=null && response.body().getResult() != null ){

                        boardlists.addAll(response.body().getResult().getArticleData());
                        boardAdpater.notifyDataSetChanged();
                        centernames.setText(response.body().getResult().getCircleName());
                        Log.i("AB","날짜테스트"+response.body().getResult().getArticleData().get(0).getArticleDate().toString());


                        Log.i("RF" ,"1성공:" + response.body().getResult().toString());

                    } else {
                        Log.i("RF", "2실패:" + response.message());
                    }
                } else {
                    Log.i("RF", "3통신은 됬는데 실패:" + response.message());
                }
            }
            @Override
            public void onFailure(Call<ResCirclesTwentyFour> call, Throwable t) { //통신 자체 실패
                Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
            }
        });
        boardAdpater = new BoardListViewAdpater();
        recyclerView.setAdapter(boardAdpater);




        return view;

    }

    class BoardHolder{
//        @BindView(R.id.profile)
//        ImageView profile;

        @BindView(R.id.nickName)
        TextView nickName;

        @BindView(R.id.contents)
        TextView contents;


        @BindView(R.id.boarddate)
        TextView boarddate;

        public BoardHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }


    class BoardListViewAdpater extends BaseAdapter{
        @Override
        public int getCount() {
            return boardlists.size();
        }

        @Override
        public ArticleData getItem(int position) {
            return boardlists.get(position);
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            BoardHolder boardholder;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.cell_post_layout, null);
                boardholder = new BoardHolder(convertView);
                convertView.setTag(boardholder);
            } else {
                boardholder = (BoardHolder) convertView.getTag();
            }
            Log.i("리스트뷰","된다");
            // Log.i("dataaaaaa", "" + ress.body().getResult().getRankData().getData().get(position).toString());
            ArticleData cond =boardlists.get(position);
            boardholder.nickName.setText(cond.getMemberName());
            boardholder.contents.setText(cond.getArticleContext());

            Toast.makeText(getActivity(), cond.getArticleDate(), Toast.LENGTH_SHORT).show();
            boardholder.boarddate.setText(cond.getArticleDate());

            convertView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    final DeleteDialog deleteDialog= new DeleteDialog(getContext(),reviseListener,deleteListener);

                    deleteDialog.show();



                    return true;
                }
            });

            return convertView;
        }

    }

    View.OnClickListener reviseListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener deleteListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }
    };



    public void Write_Board(){
        Intent intent =new Intent(getActivity(),NewPostActivity.class);
       getActivity().startActivity(intent);
    }

}
