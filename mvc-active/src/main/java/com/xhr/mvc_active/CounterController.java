package com.xhr.mvc_active;

import android.widget.TextView;

/**
 * 主动模式的MVC，直接由M更新V。V需要实现观察者，C负责关联2者
 *
 * 是MVVM的主要思想之一
 */

public class CounterController {


    private CounterModel counterModel;

    private CounterObserver view;

    private CounterController(){
        counterModel=new CounterModel();
    }

    public CounterController(CounterObserver view){
        this();
        this.view=view;
        counterModel.register(view);
    }
    public void add(){
        if(counterModel!=null){
            counterModel.add();
        }
    }

    public void sub(){
        if (counterModel!=null){
            counterModel.sub();
        }
    }
}
