package com.xhr.mvi.controller;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;

import com.xhr.mvi.intent.CounterIntent;
import com.xhr.mvi.logic.CounterInteractor;
import com.xhr.mvi.model.CounterViewState;
import com.xhr.mvi.view.CounterView;

/**
 * 驱动Intent、Model和View之间的数据流和数据转换。
 * <p>
 * 可使用Rxjava、LiveData、EventBus等方案
 */
public class CounterController implements BaseController<CounterView, CounterViewState> {

    private CounterView view;
    private CounterInteractor interactor;

    public CounterController(CounterView view) {
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
