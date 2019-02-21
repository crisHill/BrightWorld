package com.zls.brightworld;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private List<TextView> tabs = new ArrayList<>();
    private ViewPager vp;
    private TextView currentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //start(this, SplashActivity.class);

        initView();
        initData();
    }

    private void initData() {
        Fragment forumFragment = new ForumFragment();
        Fragment videoFragment = new ForumFragment();
        Fragment dataFragment = new ForumFragment();
        Fragment myFragment = new ForumFragment();

        fragments.add(forumFragment);
        fragments.add(videoFragment);
        fragments.add(dataFragment);
        fragments.add(myFragment);

        HomepageFragmentPagerAdapter adapter = new HomepageFragmentPagerAdapter(getSupportFragmentManager(), fragments);
//      MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getFragmentManager(), fragments);
        vp.setAdapter(adapter);
    }

    private void initView() {
        vp =  findViewById(R.id.vp);

        tabs.add((TextView) findViewById(R.id.forumTv));
        tabs.add((TextView) findViewById(R.id.videoTv));
        tabs.add((TextView) findViewById(R.id.dataTv));
        tabs.add((TextView) findViewById(R.id.myTv));
        for (final TextView textView : tabs){
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeTab(tabs.indexOf(textView));
                }
            });
        }
        currentTab = tabs.get(0);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        vp.setOffscreenPageLimit(2); //设置向左和向右都缓存limit个页面
    }

    private void changeTab(int index) {
        if(tabs.indexOf(currentTab) == index || index < 0 || index >= tabs.size()){
            return;
        }
        currentTab.setTextColor(getResources().getColor(R.color.homepage_tab_text_unselect_color));
        currentTab = tabs.get(index);
        currentTab.setTextColor(getResources().getColor(R.color.homepage_tab_text_select_color));

        vp.setCurrentItem(index);
    }

}
