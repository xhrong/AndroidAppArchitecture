package com.xhr.mvi.controller;

import com.xhr.mvi.intent.CounterIntent;
import com.xhr.mvi.logic.CounterInteractor;
import com.xhr.mvi.model.CounterViewState;
import com.xhr.mvi.view.CounterView;

public class CounterController1 implements BaseController<CounterView, CounterViewState> {

    private CounterView view;
    private CounterInteractor interactor;

    public CounterController1(CounterView view) {
        this.view = view;
        this.interactor = CounterInteractor.getInstance();

        view.observer(this.interactor.getCounterViewState());
    }

    /**
     * 通知View更新
     *
     * @param viewState
     */
    public void publish(CounterViewState viewState) {
        view.render(viewState);
    }

    /**
     * 接收View意图
     *
     * @param intent
     */
    public void receive(CounterIntent intent) {
        bind(intent);
    }

    /**
     * Intent和Model之间转换，并驱动数据流
     *
     * @param intent
     */
    private void bind(CounterIntent intent) {
        interactor.bindIntent(intent);
    }
}
