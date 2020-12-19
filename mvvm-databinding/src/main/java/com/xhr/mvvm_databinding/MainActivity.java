package com.xhr.mvvm_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.xhr.mvvm_databinding.databinding.ActivityMainBinding;
import com.xhr.mvvm_databinding.model.CounterModel;
import com.xhr.mvvm_databinding.viewmodel.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    private CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        counterViewModel=new CounterViewModel();
        activityMainBinding.setViewModel(counterViewModel);
        setEvent();
    }

    private void setEvent(){
        activityMainBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterViewModel.add();
            }
        });

        activityMainBinding.btnSub.setOnClickListener((view -> counterViewModel.sub()));
    }
}