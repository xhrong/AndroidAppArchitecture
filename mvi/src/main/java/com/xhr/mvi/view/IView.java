package com.xhr.mvi.view;

import androidx.lifecycle.MutableLiveData;

import com.xhr.mvi.model.CounterViewState;
import com.xhr.mvi.model.ViewState;

public interface IView<T extends ViewState> {

    public void render(T stateView);
    public void observer(MutableLiveData<T> liveData);
}
