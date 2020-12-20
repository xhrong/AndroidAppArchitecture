package com.xhr.mvp_clean.repo;

import com.xhr.mvp_clean.model.CounterModel;

public class CounterRepository {

    private static CounterRepository counterRepository;

    private CounterModel counterModel;

    private CounterRepository(){
        counterModel=new CounterModel();
    }

    public static CounterRepository getInstance() {
        if (counterRepository == null) {
            counterRepository = new CounterRepository();
        }
        return counterRepository;
    }


    public CounterModel operateCounter(int step){
        counterModel=new CounterModel(counterModel.getCount()+step);
        return counterModel;
    }
}
