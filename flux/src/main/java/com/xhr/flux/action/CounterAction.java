package com.xhr.flux.action;

import com.xhr.flux.model.CounterBean;

public class CounterAction extends Action<CounterBean> {
    public static final String COUNTER_ACTION = "counter.action";

    public CounterAction(String type, CounterBean data) {
        super(type, data);
    }
}
