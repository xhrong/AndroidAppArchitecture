package com.xhr.viper.entity;

public class CounterEntity {


    private int count;

    public CounterEntity() {

    }

    public CounterEntity(int c) {
        this.count = c;
    }

    public int getCount() {
        return count;
    }

    public String getCountStr() {
        return count + "";
    }
}
