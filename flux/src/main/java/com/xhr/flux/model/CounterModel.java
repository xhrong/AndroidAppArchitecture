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


    //从不可变性角度来说，不应该提供该方法
    public void operate(int op) {
        count += op;
    }
}
