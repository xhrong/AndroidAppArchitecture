package com.xhr.mvvm_databinding.viewmodel;

import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import com.xhr.mvvm_databinding.model.CounterModel;

/**
 * View 和 Model的关联
 */
public class CounterViewModel {

    private CounterModel counterModel;
    public ObservableField<CounterModel> counterModelObservableField = new ObservableField<>();


    public CounterViewModel() {
        counterModel = new CounterModel();
        counterModelObservableField.set(counterModel);
    }

    public ObservableField<CounterModel> getCounterModel() {
        return counterModelObservableField;
    }


    public void add() {
        counterModelObservableField.get().add();
        counterModelObservableField.notifyChange();
    }


    public void sub() {
        counterModelObservableField.get().sub();
        counterModelObservableField.notifyChange();
    }

}
