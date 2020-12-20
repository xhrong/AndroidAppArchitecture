package com.xhr.mvi.logic;

import androidx.lifecycle.MutableLiveData;

import com.xhr.mvi.intent.CounterIntent;
import com.xhr.mvi.model.CounterViewState;

/**
 * 通过这个业务逻辑层发射数据，各Controller自行订阅。Controller之间可以解耦
 */
public class CounterInteractor {
    private MutableLiveData<CounterViewState> counterViewStateMutableLiveData = new MutableLiveData<>();
    private CounterViewState viewState;

    private static CounterInteractor counterInteractor;

    private CounterInteractor() {
        viewState = new CounterViewState(0);
        counterViewStateMutableLiveData.setValue(viewState);
    }

    public static CounterInteractor getInstance(){
        if(counterInteractor==null){
            counterInteractor=new CounterInteractor();
        }
        return counterInteractor;
    }

    public MutableLiveData<CounterViewState> getCounterViewState() {
        return counterViewStateMutableLiveData;
    }

    public void bindIntent(CounterIntent intent) {
        //有过Intent创建ViewState(Model)
        //每次创建新的Model，保证不可变性
        viewState = new CounterViewState(viewState.getCount() + intent.getData().step);
        counterViewStateMutableLiveData.postValue(viewState);
    }
}
