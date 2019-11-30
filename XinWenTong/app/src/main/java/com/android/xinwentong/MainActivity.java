package com.android.xinwentong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.android.xinwentong.fragmentcontroller.MainFragmentController;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private MainFragmentController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        controller = MainFragmentController.getController(this, R.id.container);
        controller.showFragment(0);
        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.kandian) controller.showFragment(0);
                else if(i == R.id.shipin) controller.showFragment(1);
                else if(i == R.id.xiaoshipin) controller.showFragment(2);
                else controller.showFragment(3);
            }
        });

    }
}
