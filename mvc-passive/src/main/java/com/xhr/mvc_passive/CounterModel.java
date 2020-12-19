package com.xhr.mvc_passive;

public class CounterModel {
    private int count;

    public int getCount() {
        return count;
    }

    public String getCountStr(){
        return count+"";
    }



    public void add(){
        this.count+=1;
    }

    public void sub(){
        this.count-=1;
    }
}
