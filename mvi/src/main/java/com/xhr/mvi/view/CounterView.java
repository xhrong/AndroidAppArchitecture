package com.xhr.mvi.view;

import com.xhr.mvi.intent.CounterIntent;
import com.xhr.mvi.model.CounterViewState;

public interface CounterView extends IView<CounterViewState> {

    public CounterIntent intentAdd();

    public CounterIntent intentSub();
}
