package com.xhr.mvi.model;

import com.xhr.mvi.view.CounterView;

/**
 * 全量记录View的状态信息，可基于此完全恢复View
 *
 * 和其他模式的主要区别
 */
public class CounterViewState implements ViewState {

    private int count;

    public CounterViewState(int c){
        this.count=c;
    }

    public int getCount() {
        return count;
    }

    public String getCountStr() {
        return count + "";
    }

}
