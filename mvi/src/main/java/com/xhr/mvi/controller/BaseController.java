package com.xhr.mvi.controller;

import com.xhr.mvi.model.ViewState;
import com.xhr.mvi.view.IView;

public interface BaseController<V extends IView,S extends ViewState> {
//    public void bindIntents(V view,S viewState);
}
