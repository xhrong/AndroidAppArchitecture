package com.xhr.mvc_active;

import java.util.zip.CheckedOutputStream;

/**
 * 主动模式的MVC，直接由M更新通过C，C通知V。C需要实现观察者。可以更好地统一管理
 *
 * MVP的重要思路
 */

public class CounterController1 implements CounterObserver {

    private CounterModel counterModel;

    private IView view;

    private CounterController1(){
        counterModel=new CounterModel();
    }

    public CounterController1(IView view){
        this();
        this.view=view;
        counterModel.register(this);
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

    @Override
    public void notifyChange(String change) {
        this.view.updateUI(change);
    }
}
