package com.android.xinwentong.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.xinwentong.R;
import com.android.xinwentong.adapter.NewsRecyclerViewAdaper;
import com.android.xinwentong.base.FragmentBase;
import com.android.xinwentong.entity.ItemCenterPicNews;

import java.util.ArrayList;
import java.util.List;

public class FragmentNewsLists extends FragmentBase {
    View rootView;
    private List<ItemCenterPicNews> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private int channelType; //指明是哪个频道

    public FragmentNewsLists(int channelType) {this.channelType = channelType; }

    public static FragmentNewsLists newInstance(int channelType) {
        return new FragmentNewsLists(channelType);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
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
    protected void loadData(){ //最底层加载数据

    }

    void init(){
        recyclerView = rootView.findViewById(R.id.recyclerview);
        for(int i=0;i<15;i++){
            list.add(new ItemCenterPicNews());
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NewsRecyclerViewAdaper adaper = new NewsRecyclerViewAdaper(list);
        recyclerView.setAdapter(adaper);
    }

}
