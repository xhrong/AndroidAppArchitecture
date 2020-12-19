package com.xhr.flux.action;

import com.xhr.flux.dispatcher.CounterDispatcher;
import com.xhr.flux.model.CounterBean;

public class CounterActionCreator {
    private static CounterActionCreator instance;
    private final CounterDispatcher counterDispatcher;

    CounterActionCreator(CounterDispatcher counterDispatcher) {
        this.counterDispatcher = counterDispatcher;
    }

    public static CounterActionCreator get(CounterDispatcher counterDispatcher) {
        if (instance == null) {
            instance = new CounterActionCreator(counterDispatcher);
        }
        return instance;
    }


    public void doAdd() {
        counterDispatcher.dispatch(new CounterAction(CounterAction.COUNTER_ACTION, new CounterBean(1)));
    }

    public void doSub() {
        counterDispatcher.dispatch(new CounterAction(CounterAction.COUNTER_ACTION, new CounterBean(-1)));
    }
}
