package com.example.tacademy.bowlingkingproject.TabPager.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.frag.CallSearchFragment;
import com.example.tacademy.bowlingkingproject.TabPager.frag.FaceBookFragment;
import com.example.tacademy.bowlingkingproject.TabPager.frag.LankingParentFragment;
import com.example.tacademy.bowlingkingproject.TabPager.frag.MessageFragment;
import com.example.tacademy.bowlingkingproject.TabPager.frag.TotalRankingFragment;
import com.example.tacademy.bowlingkingproject.TabPager.frag.WebSearchFragment;

public class CallSearchActivity extends AppCompatActivity
        implements CallSearchFragment.OnFragmentInteractionListener,
        FaceBookFragment.OnFragmentInteractionListener,
        WebSearchFragment.OnFragmentInteractionListener,
        LankingParentFragment.OnFragmentInteractionListener,
        MessageFragment.OnFragmentInteractionListener

{




    android.support.design.widget.TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;
    TextView toolbar_title;

    Toolbar toolbar;




    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    private int[] tabIcons = {
            R.drawable.home,
            R.drawable.my_lanking,
            R.drawable.register,
            R.drawable.lanking,
            R.drawable.message

    };

    private int[] tabClickIcons={
            R.drawable.home_click,
            R.drawable.my_lanking_click,
            R.drawable.register_click,
            R.drawable.lanking_click,
            R.drawable.message_click

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_search);

        tabLayout = (android.support.design.widget.TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        toolbar_title = (TextView)findViewById(R.id.toolbar_title);



    //    Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.setting);
  //      toolbar.setOverflowIcon(drawable);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
              //  tabLayout.getTabAt(position).setIcon(tabClickIcons[position]);


                switch (position) {
                    case 0:
                        tabLayout.getTabAt(position).setIcon(tabClickIcons[position]);
                        for(int i=1;i<5;i++){
                            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
                        }
                        toolbar_title.setText("홈");
                        break;
                    case 1:
                        tabLayout.getTabAt(position).setIcon(tabClickIcons[position]);
                        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                        for(int i=2;i<5;i++){
                            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
                        }
                        toolbar_title.setText("내 기록");

                        break;
                    case 2:
                        tabLayout.getTabAt(position).setIcon(tabClickIcons[position]);
                        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                        for(int i=3;i<5;i++){
                            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
                        }
                        toolbar_title.setText("등록하기");

                        break;
                    case 3:
                        tabLayout.getTabAt(position).setIcon(tabClickIcons[position]);
                        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
                        for(int i=0;i<3;i++){
                            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
                        }
                        toolbar_title.setText("랭킹보기");

                        break;

                    default:
                        tabLayout.getTabAt(position).setIcon(tabClickIcons[position]);
                        for(int i=0;i<4;i++){
                            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
                        }
                        toolbar_title.setText("메세지");

                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setTabIcons();




}

    // 탭뷰 아이콘 셋팅
    public void setTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }





    public void onTabSelected(TabLayout.Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }



    class FragmentAdapter extends FragmentPagerAdapter {
        Fragment[]frags = new Fragment[]{
                new CallSearchFragment(),
                new FaceBookFragment(),
                new WebSearchFragment(),
                 new TotalRankingFragment(),
                new MessageFragment()
        };
//        String[] titles = new String[]{
//                "홈" , "내기록", "추가", "랭킹", "메신저"
//        };

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frags[position];
        }

        @Override
        public int getCount() {
            return frags.length;
        }

       /* @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }*/
    }

    public void onClickedSetting(View view){

        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

}
