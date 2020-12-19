package com.xhr.mvvm_aac.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xhr.mvvm_aac.model.CounterModel;

/**
 * View 和 Model的关联
 */
public class CounterViewModel extends ViewModel {


    private MutableLiveData<CounterModel> counterModelMutableLiveData = new MutableLiveData<>();


    public CounterViewModel() {
        counterModelMutableLiveData.setValue(new CounterModel());
    }

    public MutableLiveData<CounterModel> getCounterModel() {
        return counterModelMutableLiveData;
    }

//    public void add() {
//        counterModelMutableLiveData.getValue().add();
//    }
//
//
//    public void sub() {
//        counterModelMutableLiveData.getValue().sub();
//    }


    public void add() {
        //不能直接更新原Model，必须重新创建，否则无法触发属性更新。Observable对象有notify能力，LiveData没有
        //好处是强制了不可变性，坏处是对象的频繁创建和销毁
        counterModelMutableLiveData.setValue(new CounterModel(counterModelMutableLiveData.getValue().getCount()+1));
    }


    public void sub() {
        //不能直接更新原Model，必须重新创建，否则无法触发属性更新。Observable对象有notify能力，LiveData没有
        //好处是强制了不可变性，坏处是对象的频繁创建和销毁
        counterModelMutableLiveData.setValue(new CounterModel(counterModelMutableLiveData.getValue().getCount()-1));
    }

}
