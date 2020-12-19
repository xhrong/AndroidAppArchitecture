package com.xhr.mvc_passive;

import android.widget.Button;
import android.widget.TextView;

/**
 * 被动模式的MVC，理论上要将View传递给Controller。
 * 如果不做任何优化的设计的话，2者的依赖过于强，非常不利与扩展和维护
 *
 * 可优化的方案是：将View抽象为接口；或基于回调
 */

public class CounterController {

    private CounterModel counterModel;

    //View依赖，耦合太强
    private TextView textView;

    private CounterController(){
        counterModel=new CounterModel();
    }

    public CounterController(TextView textView){
        this();
        this.textView=textView;
    }
    public void add(){
        if(counterModel!=null){
            counterModel.add();
            this.textView.setText(counterModel.getCountStr());
        }
    }

    public void sub(){
        if (counterModel!=null){
            counterModel.sub();
            this.textView.setText(counterModel.getCountStr());
        }
    }
}
