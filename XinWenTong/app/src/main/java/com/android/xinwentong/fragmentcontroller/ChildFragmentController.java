package com.android.xinwentong.fragmentcontroller;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.xinwentong.ui.main.FragmentNewsLists;
import com.android.xinwentong.ui.main.FragmentSmallVideo;
import com.android.xinwentong.ui.main.FragmentVideo;
import com.android.xinwentong.ui.main.FragmentWoDe;
import com.android.xinwentong.ui.main.Fragment_KanDian;

import java.util.ArrayList;

//子类fragment控制器

public class ChildFragmentController extends Fragment {
    private int containerId;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;
    private static ChildFragmentController controller;
    private FragmentTransaction ft;

    public static ChildFragmentController getController(Fragment parentFragment, int containerId){
        if(controller == null){
            controller = new ChildFragmentController(parentFragment, containerId);
        }
        return controller;
    }

    private ChildFragmentController(Fragment parentFragment, int containerId){
        this.containerId = containerId;
        fm = parentFragment.getChildFragmentManager();
        initFragment();
    }

    private void initFragment(){
        fragments = new ArrayList<>();
        for(int i=0;i<15;i++){
            fragments.add(FragmentNewsLists.newInstance());
        }
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

    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

}
