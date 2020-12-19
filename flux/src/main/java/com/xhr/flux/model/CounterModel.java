package com.xhr.flux.model;

/**
 * 用作系统状态记录
 */
public class CounterModel {
    private int count;

    public int getCount() {
        return count;
    }

    public String getCountStr() {
        return count + "";
    }


    public void operate(int op) {
        count += op;
    }
}
