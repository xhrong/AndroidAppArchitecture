package com.xhr.mvp_clean.model;

public class CounterModel {

    private int count;

    public CounterModel() {

    }

    public CounterModel(int c) {
        this.count = c;
    }

    public int getCount() {
        return count;
    }

    public String getCountStr() {
        return count + "";
    }
}
