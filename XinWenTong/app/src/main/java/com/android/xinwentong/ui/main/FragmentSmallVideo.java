package com.android.xinwentong.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.xinwentong.R;
import com.android.xinwentong.base.FragmentBase;

public class FragmentSmallVideo extends FragmentBase {

    View rootView;
    public FragmentSmallVideo() {}

    public static FragmentSmallVideo newInstance(){
        return new FragmentSmallVideo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_smallvideo, container, false);
        }
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
}
