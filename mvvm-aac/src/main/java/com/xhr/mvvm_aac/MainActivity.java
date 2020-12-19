package com.xhr.mvvm_aac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xhr.mvvm_aac.databinding.ActivityMainBinding;
import com.xhr.mvvm_aac.model.CounterModel;
import com.xhr.mvvm_aac.viewmodel.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    private CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterViewModel = new ViewModelProvider(this).get(CounterViewModel.class);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(counterViewModel);
        //让DataBinding和LiveData关联，配置后可直接更新绑定数据  ------ 关键点1
        activityMainBinding.setLifecycleOwner(this);
        setEvent();
        registerObserver();

    }

    private void registerObserver(){
        counterViewModel.getCounterModel().observe(this, new Observer<CounterModel>() {
            @Override
            public void onChanged(CounterModel counterModel) {
                Log.e("xxxhrong",counterModel.getCountStr());
                //如果 关键点1 不配置，可在这里更新DataBinding数据源（需要额外创建）。实现2个组件的解耦与配合
            }
        });
    }

    private void setEvent() {
        activityMainBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterViewModel.add();
            }
        });

        activityMainBinding.btnSub.setOnClickListener((view -> counterViewModel.sub()));
    }
}