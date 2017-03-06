package com.example.tacademy.bowlingkingproject.TabPager.frag;


import android.support.v4.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class LankingFragment extends LankingParentFragment {


    public LankingFragment() {
        // Required empty public constructor
    }



    @Override
    public Query getQuery(DatabaseReference databaseReference){
        Query querylanking = databaseReference.child("posts")
                .limitToLast(30); //시작부터 10개 가져오겠다.
        return querylanking; //자식이 필요에 의해서 추가한 것이다.

    }

}
