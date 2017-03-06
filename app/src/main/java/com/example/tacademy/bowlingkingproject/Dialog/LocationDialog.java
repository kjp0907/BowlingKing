package com.example.tacademy.bowlingkingproject.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tacademy on 2017-02-27.
 */

public class LocationDialog extends Dialog {

    private ListView location_list;
    Button cancel,loca_ok;
    RadioButton radioButton;
    ListViewAdapter locationAdapter;

    ArrayList<LocationArrayList> locationArrayLists; //위치 선택 arraylist





    private View.OnClickListener mLeftClickListener;
    private View.OnClickListener mRightClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_location);
//locationlistitem


        // locationarrayList 셋팅
        //arraylist  : 한번에 여러개의 변수들을 담고싶을 때
        locationArrayLists = new ArrayList<LocationArrayList>(); //생성자
        LocationArrayList locationlist = new LocationArrayList("jp 볼링장","1 km");
        LocationArrayList locationlist1 = new LocationArrayList("king 볼링장","2 km");
        LocationArrayList locationlist2 = new LocationArrayList("ms 볼링장","3 km");


        locationArrayLists.add(locationlist);
        locationArrayLists.add(locationlist1);
        locationArrayLists.add(locationlist2);

        //컬렉션 많이 저장한거 나열할때 쓴다.iterator()

        Log.i("dd",locationlist.toString());


        location_list = (ListView) findViewById(R.id.locationlistitem);


        locationAdapter = new ListViewAdapter();


        location_list.setAdapter(locationAdapter);




        // 클릭 이벤트 셋팅
        if (mLeftClickListener != null && mRightClickListener != null) {
            cancel.setOnClickListener(mLeftClickListener);
            loca_ok.setOnClickListener(mRightClickListener);
        } else if (mLeftClickListener != null
                && mRightClickListener == null) {
            cancel.setOnClickListener(mLeftClickListener);
        } else {

        }

    }

    class LocationHolder {

        @BindView(R.id.alleyname)
        TextView alleyname;
        @BindView(R.id.distance)
        TextView distance;

        public LocationHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }


    class ListViewAdapter extends BaseAdapter{
        public ListViewAdapter() {

        }


        @Override
        public int getCount() {
            return locationArrayLists.size();
        }

        @Override
        public LocationArrayList getItem(int position) {
            return locationArrayLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LocationHolder locationHolder;

            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.locationlistitem, null);
                locationHolder = new LocationHolder(convertView);
                convertView.setTag(locationHolder);
            }else{
                locationHolder = (LocationHolder) convertView.getTag();
            }

            locationHolder.alleyname.setText(getItem(position).getAlleyname());
            locationHolder.distance.setText(getItem(position).getDistance()+"");

            return convertView;        }

    }



    public LocationDialog(Context context) {
        super(context);
    }

    public LocationDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public LocationDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
