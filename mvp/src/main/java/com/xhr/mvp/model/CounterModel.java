package com.xhr.mvp.model;

import java.util.ArrayList;
import java.util.List;

public class CounterModel {

    private int count;

    public int getCount() {
        return count;
    }

    public String getCountStr() {
        return count + "";
    }


    public void add() {
        this.count += 1;
    }

    public void sub() {
        this.count -= 1;
    }
}
