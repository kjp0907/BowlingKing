package com.example.tacademy.bowlingkingproject.TabPager.frag;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.NetSSL;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.AllRecordScoreData;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.ResScoresTwelve;
import com.example.tacademy.bowlingkingproject.imageProc;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpandAdapter extends BaseExpandableListAdapter {
    private Context context;
    private int groupLayout = 0;
    private int chlidLayout = 0;
    private ArrayList<ExpandMyGroup> DataList;
    private LayoutInflater myinf = null;
    String[] pictureUrls;
    ArrayList<AllRecordScoreData> MyDataList;
    int score_id;

    public ExpandAdapter(Context context, int groupLay, int chlidLay, ArrayList<ExpandMyGroup> DataList, String[] pictureUrls, ArrayList<AllRecordScoreData> MyDataList) {
        this.DataList = DataList;
        this.groupLayout = groupLay;
        this.chlidLayout = chlidLay;
        this.context = context;
        this.myinf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageProc.getInstance().getImageLoader(context);
        this.pictureUrls = pictureUrls;
        this.MyDataList = MyDataList;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            convertView = myinf.inflate(this.groupLayout, parent, false);
        }
        score_id = MyDataList.get(groupPosition).getScoreId();
        TextView groupName = (TextView) convertView.findViewById(R.id.moreSee);
        TextView gName = (TextView) convertView.findViewById(R.id.mycenter);
        TextView gScore = (TextView) convertView.findViewById(R.id.myscore);
        TextView gMydateself = (TextView) convertView.findViewById(R.id.mydateself);
        gName.setText(DataList.get(groupPosition).getGroupName());
        gScore.setText(DataList.get(groupPosition).getScore() + "");
        gMydateself.setText(DataList.get(groupPosition).getMydateself() + "");

//        groupName.setText(DataList.get(groupPosition).groupName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = myinf.inflate(this.chlidLayout, parent, false);
        }
        ImageView childPicture = (ImageView) convertView.findViewById(R.id.childPicture);
        imageProc.getInstance().drawImage(pictureUrls[groupPosition], childPicture);
        Button scoreselfdelete = (Button) convertView.findViewById(R.id.scoreselfdelete);
        Button scoreSelfBoast = (Button) convertView.findViewById(R.id.scoreSelfBoast);
//        scoreSelfBoast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//            }
//        });
        scoreselfdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RF", "삭제하기 눌렀을 때 몇 번째니 넌? : " + groupPosition);
                Call<ResScoresTwelve> res = NetSSL.getInstance().getMemberImpFactory().twelveSelfScoreDelete( MyDataList.get(groupPosition).getScoreId());
                res.enqueue(new Callback<ResScoresTwelve>() {
                    @Override
                    public void onResponse(Call<ResScoresTwelve> call, Response<ResScoresTwelve> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null && response.body().getResult() != null) {
                                Log.i("RF", "1삭제성공:" + response.body().getResult().toString());
                            } else {
                                Log.i("RF", "2삭제실패:" + response.message());
                            }
                        } else {
                            Log.i("RF", "3통신은 됬는데 실패:" + response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<ResScoresTwelve> call, Throwable t) { //통신 자체 실패
                        Log.i("RF", " onBoardSearch  4아예 통신오류" + t.getMessage());
                    }
                });
            }
        });
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return DataList.get(0).child.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public ExpandMyGroup getGroup(int groupPosition) {
        return DataList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return DataList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
}