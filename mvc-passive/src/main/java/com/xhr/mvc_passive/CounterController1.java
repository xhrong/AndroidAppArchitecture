package com.xhr.mvc_passive;

import android.widget.TextView;

/**
 * 被动模式的MVC，理论上要将View传递给Controller。
 * 如果不做任何优化的设计的话，2者的依赖过于强，非常不利与扩展和维护
 *
 * 演示：将View抽象为接口。（基于回调的方案本质上也是一样的，只不过是类和方法的命名不同）
 * 这种优化正是MVP的关键点思路
 */

public class CounterController1 {

    private CounterModel counterModel;

    private IView view;

    private CounterController1(){
        counterModel=new CounterModel();
    }

    public CounterController1(IView view){
        this();
        this.view=view;
    }
    public void add(){
        if(counterModel!=null){
            counterModel.add();
            this.view.updateUI(counterModel.getCountStr());
        }
    }

    public void sub(){
        if (counterModel!=null){
            counterModel.sub();
            this.view.updateUI(counterModel.getCountStr());
        }
    }
}
