package com.xhr.mvp_clean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xhr.mvp_clean.base.UseCaseHandler;
import com.xhr.mvp_clean.contract.CounterContract;
import com.xhr.mvp_clean.presenter.CounterPresenter;
import com.xhr.mvp_clean.repo.CounterRepository;
import com.xhr.mvp_clean.usecase.CountTask;

public class MainActivity extends AppCompatActivity implements CounterContract.IView {

    private Button btnAdd, btnSub;
    private TextView textView;

    private CounterContract.IPresenter counterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        textView = findViewById(R.id.text);


        setPresenter(new CounterPresenter(this, new CountTask(CounterRepository.getInstance()), UseCaseHandler.getInstance()));
        initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        counterPresenter.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        counterPresenter.onDestory();
    }

    private void initEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterPresenter.add();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterPresenter.sub();
            }
        });
    }

    @Override
    public void updateUI(String text) {
        textView.setText(text);
    }

    @Override
    public void setPresenter(CounterContract.IPresenter presenter) {
        counterPresenter = presenter;
    }
}