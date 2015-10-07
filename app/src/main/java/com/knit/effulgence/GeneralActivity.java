package com.knit.effulgence;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;

public class GeneralActivity extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        // Tab Initialization
        initialiseTabHost();
        TabsPagerAdapter mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        // Fragments and ViewPager Initialization


        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(GeneralActivity.this);
    }

    // Method to add a TabHost
    private static void AddTab(GeneralActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
        tabSpec.setContent(new MyTabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    // Manages the Tab changes, synchronizing it with Pages
    public void onTabChanged(String tag) {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    // Manages the Page changes, synchronizing it with Tabs
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        int pos = this.mViewPager.getCurrentItem();
        this.mTabHost.setCurrentTab(pos);
    }

    @Override
    public void onPageSelected(int arg0) {
    }


    // Tabs Creation
    private void initialiseTabHost() {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        GeneralActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Home").setIndicator("Home"));
        GeneralActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("News").setIndicator("News"));
        GeneralActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Visit").setIndicator("Visit"));
        GeneralActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("About").setIndicator("About"));

        mTabHost.setOnTabChangedListener(this);
    }
}