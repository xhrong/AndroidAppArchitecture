package com.xhr.mvvm_aac.model;

public class CounterModel {

    private int count;

    public CounterModel(){
        count=0;
    }
    public CounterModel(int c){
        count=c;
    }
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
