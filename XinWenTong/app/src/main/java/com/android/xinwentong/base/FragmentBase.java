package com.android.xinwentong.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//所有fragment 的基类， 用于懒加载，防止重复装载数据

public abstract class FragmentBase extends Fragment {

    public boolean mIsPrepare = false;
    public boolean mIsVisible = false;
    public boolean mIsFirstLoad = true;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIsPrepare = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            mIsVisible = true;
            lazyLoad();
        } else {
            mIsVisible = false;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsFirstLoad=true;
        mIsPrepare=false;
        mIsVisible = false;
    }


    private void lazyLoad(){
        if(!mIsFirstLoad||!mIsPrepare||!mIsVisible) return ;
        loadData();
        mIsFirstLoad = false;
    }

    //用于子类继承装载数据
    protected void loadData(){ }

}
