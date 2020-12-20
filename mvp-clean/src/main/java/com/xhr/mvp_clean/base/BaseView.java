package com.xhr.mvp_clean.base;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
