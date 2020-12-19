package com.xhr.flux;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xhr.flux.action.CounterActionCreator;
import com.xhr.flux.dispatcher.CounterDispatcher;
import com.xhr.flux.store.CounterStore;
import com.xhr.flux.store.Store;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private CounterActionCreator mActionCreator;
    private CounterStore mStore;


    private Button btnAdd, btnSub;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        initViews();
        initEvent();
    }

    private void initVariables() {
        CounterDispatcher counterDispatcher = CounterDispatcher.getInstance();
        mStore = new CounterStore();
        mActionCreator = CounterActionCreator.get(counterDispatcher);
        counterDispatcher.register(mStore);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStore.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStore.unregister(this);
    }

    private void initViews() {
        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        textView = findViewById(R.id.text);
    }

    private void initEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActionCreator.doAdd();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActionCreator.doSub();
            }
        });
    }

    @Subscribe
    public void onChangeEvent(Store.StoreChangeEvent changeEvent) {
        textView.setText(mStore.getCounterModel().getCountStr());
    }
}