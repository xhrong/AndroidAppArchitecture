package com.xhr.mvp.presenter;

import com.xhr.mvp.contract.CounterContract;
import com.xhr.mvp.model.CounterModel;


/**
 * MVP最大的特别是面向接口，把View、Presenter都抽象一层，以便解耦
 *
 * 弊端是，增加了类的层次结构和类的数量，大量的模板代码
 *
 * MVP是MVC的优化改造的结果。也可以像MVC一样，分成被动的和主动的。
 *
 * 做为优化，MVP可以引入生命周期的概念，和View的生命周期关联，以免内存问题
 */

public class CounterPresenter implements CounterContract.IPresenter {


    private CounterModel counterModel;

    private CounterContract.IView view;

    private CounterPresenter() {
        counterModel = new CounterModel();
    }

    public CounterPresenter(CounterContract.IView view) {
        this();
        this.view = view;
    }

    @Override
    public void add() {
        if (counterModel != null) {
            counterModel.add();
            this.view.updateUI(counterModel.getCountStr());
        }
    }

    @Override
    public void sub() {
        if (counterModel != null) {
            counterModel.sub();
            this.view.updateUI(counterModel.getCountStr());
        }
    }
}
