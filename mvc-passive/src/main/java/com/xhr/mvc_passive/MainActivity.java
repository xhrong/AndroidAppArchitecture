package com.xhr.mvc_passive;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements IView {

    private Button btnAdd, btnSub;
    private TextView textView;


    private Button btnAdd1, btnSub1;
    private TextView textView1;

    private CounterController counterController;
    private CounterController1 counterController1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        textView = findViewById(R.id.text);


        btnAdd1 = findViewById(R.id.btn_add1);
        btnSub1 = findViewById(R.id.btn_sub1);
        textView1 = findViewById(R.id.text1);


        //需要将View传递给Controller，耦合非常大。
        counterController=new CounterController(textView);
        counterController1=new CounterController1(this);
        initEvent();
    }

    private void initEvent(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterController.add();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterController.sub();
            }
        });


        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterController1.add();
            }
        });

        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterController1.sub();
            }
        });
    }

    @Override
    public void updateUI(String text) {
        textView1.setText(text);
    }
}
