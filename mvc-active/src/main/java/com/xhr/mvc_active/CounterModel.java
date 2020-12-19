package com.xhr.mvc_active;

import java.util.ArrayList;
import java.util.List;

public class CounterModel {

    private List<CounterObserver> counterObservers = new ArrayList<>();
    private int count;

    public int getCount() {
        return count;
    }

    public String getCountStr() {
        return count + "";
    }


    public void add() {
        this.count += 1;
        notifyChange();
    }

    public void sub() {
        this.count -= 1;
        notifyChange();
    }


    public void register(CounterObserver observer) {
        this.counterObservers.add(observer);
    }


    private void notifyChange() {
        for (CounterObserver observer : counterObservers) {
            observer.notifyChange(getCountStr());
        }
    }
}
