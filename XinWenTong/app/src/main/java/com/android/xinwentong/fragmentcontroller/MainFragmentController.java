package com.android.xinwentong.fragmentcontroller;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.xinwentong.ui.main.FragmentSmallVideo;
import com.android.xinwentong.ui.main.FragmentVideo;
import com.android.xinwentong.ui.main.FragmentWoDe;
import com.android.xinwentong.ui.main.Fragment_KanDian;

import java.util.ArrayList;

public class MainFragmentController extends Fragment {
    private int containerId;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;
    private static MainFragmentController controller;
    private FragmentTransaction ft;

    public static MainFragmentController getController(FragmentActivity activity, int containerId){
        if(controller == null){
            controller = new MainFragmentController(activity, containerId);
        }
        return controller;
    }

    private MainFragmentController(FragmentActivity activity, int containerId){
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        initFragment();
    }

    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(Fragment_KanDian.newInstance());
        fragments.add(FragmentVideo.newInstance());
        fragments.add(FragmentSmallVideo.newInstance());
        fragments.add(FragmentWoDe.newInstance());
        ft = fm.beginTransaction();
        for(Fragment fragment : fragments){
            ft.add(containerId,fragment);
        }
        ft.commit();
    }

    public void hideFragments(){
        ft = fm.beginTransaction();
        for(Fragment fragment : fragments){
            if(fragment != null) ft.hide(fragment);
        }
        ft.commit();
    }

    public void showFragment(int pos){
        hideFragments();
        Fragment fragment = fragments.get(pos);
        ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commit();
    }

    public Fragment getFragment(int pos){
        return fragments.get(pos);
    }

    public static void destroyController(){
        controller = null;
    }

}
