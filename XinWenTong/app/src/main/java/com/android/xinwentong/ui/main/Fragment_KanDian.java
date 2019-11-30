package com.android.xinwentong.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.android.xinwentong.R;
import com.android.xinwentong.adapter.MyViewPagerAdapter;
import com.android.xinwentong.base.FragmentBase;
import com.android.xinwentong.fragmentcontroller.ChildFragmentController;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Fragment_KanDian extends FragmentBase {
    private View rootView;
    private ChildFragmentController controller;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;
    private MyViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public Fragment_KanDian() {
    }

    public static Fragment_KanDian newInstance() {
        return new Fragment_KanDian();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_kandian, container, false);
        }
        init();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsFirstLoad = true;
        mIsPrepare = false;
        mIsVisible = false;
        if (rootView != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }

    @Override
    protected void loadData(){

    }

    private void init(){
//        controller = ChildFragmentController.getController(this, R.id.viewpager_kandian);
//        fragments = controller.getFragments();
        fragments = new ArrayList<>();
        for(int i=0;i<15;i++){
            fragments.add(FragmentNewsLists.newInstance(i));

        }
        title = new ArrayList<>();
        for(int i=0;i<15;i++){
            String s = new String("a"+i);
            title.add(s);
        }
        viewPagerAdapter = new MyViewPagerAdapter(this.getChildFragmentManager(),fragments, title);
        viewPager = rootView.findViewById(R.id.viewpager_kandian);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = rootView.findViewById(R.id.tablayout_kandian);
        tabLayout.setupWithViewPager(viewPager);
    }
}

