package com.example.tacademy.bowlingkingproject.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.Server.ReviseServer.CenterData;
import com.example.tacademy.bowlingkingproject.TabPager.Register.HandlerSing;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tacademy on 2017-02-27.
 */

public class LocationDialog extends Dialog {

    private ListView location_list;
    Button cancel,loca_ok;
    ListViewAdapter locationAdapter;

    ArrayList<LocationArrayList> locationArrayLists; //위치 선택 arraylist
    RadioButton radioButton;
    String[] location =new String[2];


    private int mSelectedRadioPosition;
    private RadioButton mLastSelectedRadioButton;

    Handler handler;

    private View.OnClickListener mLeftClickListener;
    private View.OnClickListener mRightClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_location);
//locationlistitem

        //컬렉션 많이 저장한거 나열할때 쓴다.iterator()

        //    Log.i("dd",locationlist.toString());


        location_list = (ListView) findViewById(R.id.locationlistitem);

        findViewById(R.id.oklocation).setOnClickListener(new View.OnClickListener(){


                @Override
                public void onClick(View v) {
                    Message msg = HandlerSing.getInstance().getHandler().obtainMessage();
                    msg.what=0;
                    msg.obj=location;
                    msg.arg1=centerId;
                    Log.i("AB","Dialog"+location[1]);
                    HandlerSing.getInstance().getHandler().sendMessage(msg);
                    dismiss();

            }


        });
        findViewById(R.id.cancel_location).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });



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

        @BindView(R.id.locationradio)
        RadioButton locationradio;

        public LocationHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    final ArrayList<RadioButton> rb = new ArrayList<RadioButton>();
    class ListViewAdapter extends BaseAdapter implements Checkable{

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
                LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = getLayoutInflater().inflate(R.layout.locationlistitem, null);
                locationHolder = new LocationHolder(convertView);
                convertView.setTag(locationHolder);
                rb.add(locationHolder.locationradio);
            }else{
                locationHolder = (LocationHolder) convertView.getTag();
            }

            LocationArrayList item = locationArrayLists.get(position);
            locationHolder.alleyname.setText( item.getAlleyname().toString() );
            locationHolder.distance.setText( item.getDistance().toString() );


            locationHolder.locationradio.setOnCheckedChangeListener(new Check(locationHolder));


            if(mSelectedRadioPosition == position) {
                locationHolder.locationradio.setChecked(true);
            } else {
                locationHolder.locationradio.setChecked(false);
            }

            return convertView;
        }


        final String NS = "http://schemas.android.com/apk/res/com.huewu.example.checkable";
        final String ATTR = "checkable";
        int checkableId;
        Checkable checkable;




        @Override
        public void setChecked(boolean checked) {
            checkable = (Checkable) findViewById(checkableId);

            if(checkable == null)

                return;

            checkable.setChecked(checked);

        }

        @Override
        public boolean isChecked() {
            checkable = (Checkable) findViewById(checkableId);
            if(checkable == null)

                return false;

            return checkable.isChecked();




        }

        @Override
        public void toggle() {
            checkable = (Checkable) findViewById(checkableId);

            if(checkable == null)

                return;

            checkable.toggle();




        }
    }
    class Check implements CompoundButton.OnCheckedChangeListener
    {

        LocationHolder holder;
        public Check(LocationHolder holder){
            this.holder = holder;
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                for(int i=0; i<rb.size()-1 ;i++){

                    if( !buttonView.equals(rb.get(i))) {
                        rb.get(i).setChecked(false);
                    }
                    else
                    {
                        centerId=centerDatas.get(i).getCenterId();
                        Log.i("AB/C","centerId  :  "+centerId);
                    }

                }

                location[1]= holder.alleyname.getText().toString();



                Log.i("AB/C",location[1]);


            }
        }
    }

    public LocationDialog(Context context) {
        super(context);
    }






    ArrayList<CenterData> centerDatas;
   int centerId;
    int center_id1,center_id2,center_id3;
    public LocationDialog(Context context, ArrayList<CenterData> centerDatas) {



        super(context);


        this.centerDatas=centerDatas;

        if(centerDatas.size()>0){

            Log.i("AB","list출력" + centerDatas.get(0).getDistance());
            Log.i("AB","list출력" + centerDatas.get(0).getCenterName());

        }


        // locationarrayList 셋팅
        //arraylist  : 한번에 여러개의 변수들을 담고싶을 때
        locationArrayLists = new ArrayList<LocationArrayList>(); //생성자
        LocationArrayList locationlist = new LocationArrayList(centerDatas.get(0).getCenterName(), String.format("%.02fkm",centerDatas.get(0).getDistance()));
        LocationArrayList locationlist1 = new LocationArrayList(centerDatas.get(1).getCenterName(),String.format("%.02fkm",centerDatas.get(1).getDistance()));
        LocationArrayList locationlist2 = new LocationArrayList(centerDatas.get(2).getCenterName(),String.format("%.02fkm",centerDatas.get(2).getDistance()));


        locationArrayLists.add(locationlist);
        locationArrayLists.add(locationlist1);
        locationArrayLists.add(locationlist2);

        center_id1=centerDatas.get(0).getCenterId();
        center_id2=centerDatas.get(1).getCenterId();
        center_id3=centerDatas.get(2).getCenterId();

        Log.d("AB/C","=========="+center_id1);
        Log.d("AB/C","=========="+center_id2);
        Log.d("AB/C","=========="+center_id3);


/*
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, GENRES));

        final ListView listView = getListView();

        listView.setItemsCanFocus(false);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
*/



    }

    public LocationDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public LocationDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
