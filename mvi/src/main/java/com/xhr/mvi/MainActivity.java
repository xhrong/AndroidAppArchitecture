package com.xhr.mvi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xhr.mvi.bean.CounterBean;
import com.xhr.mvi.controller.CounterController;
import com.xhr.mvi.intent.CounterIntent;
import com.xhr.mvi.model.CounterViewState;
import com.xhr.mvi.model.ViewState;
import com.xhr.mvi.view.CounterView;

public class MainActivity extends AppCompatActivity implements CounterView {

    private Button btnAdd, btnSub;
    private TextView textView;

    private CounterController counterController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvent();

        counterController = new CounterController(this);
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
                counterController.receive(intentAdd());
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterController.receive(intentSub());
            }
        });
    }

    @Override
    public CounterIntent intentAdd() {
        return new CounterIntent(CounterIntent.COUNTER_INTENT, new CounterBean(1));
    }

    @Override
    public CounterIntent intentSub() {
        return new CounterIntent(CounterIntent.COUNTER_INTENT, new CounterBean(-1));
    }

    @Override
    public void render(CounterViewState viewState) {
        textView.setText(viewState.getCountStr());
    }

    @Override
    public void observer(MutableLiveData<CounterViewState> counterViewStateMutableLiveData) {
        counterViewStateMutableLiveData.observe(this, new Observer<CounterViewState>() {
            @Override
            public void onChanged(CounterViewState viewState) {
                render(viewState);
            }
        });
    }
}