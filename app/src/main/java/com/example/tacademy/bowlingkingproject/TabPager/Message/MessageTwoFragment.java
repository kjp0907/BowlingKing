package com.example.tacademy.bowlingkingproject.TabPager.Message;


import android.support.v4.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageTwoFragment extends MessageTwoParentFragment {


    public MessageTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public Query getQuery(DatabaseReference databaseReference){
        Query query = databaseReference.child("posts")
                .limitToLast(10); //시작부터 10개 가져오겠다.
        return query; //자식이 필요에 의해서 추가한 것이다.

    }

}
