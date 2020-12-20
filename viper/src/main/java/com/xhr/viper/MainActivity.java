package com.xhr.viper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xhr.viper.contract.CounterContract;
import com.xhr.viper.presenter.CounterPresenter;
import com.xhr.viper.router.CounterRouter;

public class MainActivity extends AppCompatActivity implements CounterContract.IView {

    private Button btnAdd, btnSub;
    private TextView textView, goHomeTv;

    private CounterContract.IPresenter counterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        textView = findViewById(R.id.text);
        goHomeTv = findViewById(R.id.go_home);


        setPresenter(new CounterPresenter(this, new CounterRouter(this)));
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

        goHomeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterPresenter.goHome();
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