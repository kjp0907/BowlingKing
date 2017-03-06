package com.example.tacademy.bowlingkingproject.TabPager.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.tacademy.bowlingkingproject.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FaceBookFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FaceBookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FaceBookFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    //////////////////////////////////////////////////////
    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    private ExpandableListView mListView;
    View view;
    BaseExpandableAdapter baseExpandableAdapter;

    public FaceBookFragment() {
    }
    public static FaceBookFragment newInstance(String param1, String param2) {
        FaceBookFragment fragment = new FaceBookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ////////////////////////////////////
        view = inflater.inflate(R.layout.fragment_face_book, container, false);

        //////////////////////////////////////////////////////////////////////
        setLayout();
        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();
        mGroupList.add("가위");
        mGroupList.add("바위");
        mGroupList.add("보");
        mChildListContent.add("1");
        mChildListContent.add("2");
        mChildListContent.add("3");
        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);
        baseExpandableAdapter = new BaseExpandableAdapter(getContext(), mGroupList, mChildList);
        mListView.setAdapter(baseExpandableAdapter);
        // 그룹 클릭 했을 경우 이벤트
        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });
        /* 차일드 클릭 했을 경우 이벤트 */
        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });
        // 그룹이 닫힐 경우 이벤트
        mListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });
        // 그룹이 열릴 경우 이벤트
        mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });

        return view;
    }
    //////////////////////////////////////////////////

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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    ///////////////////////////////////////////
    private void setLayout() {
        mListView = (ExpandableListView) view.findViewById(R.id.elv_list);
    }

}
