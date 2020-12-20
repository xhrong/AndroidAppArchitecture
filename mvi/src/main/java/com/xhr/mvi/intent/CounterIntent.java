package com.xhr.mvi.intent;


import com.xhr.mvi.bean.CounterBean;

public class CounterIntent extends BaseIntent<CounterBean> {
    public static final String COUNTER_INTENT = "counter.intent";

    public CounterIntent(String type, CounterBean data) {
        super(type, data);
    }
}
