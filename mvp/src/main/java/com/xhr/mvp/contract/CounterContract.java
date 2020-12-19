package com.xhr.mvp.contract;

import com.xhr.mvp.base.BasePresenter;
import com.xhr.mvp.base.BaseView;

public interface CounterContract {

    public interface IPresenter extends BasePresenter {
        public void add();

        public void sub();
    }

    public interface IView extends BaseView<IPresenter> {
        public void updateUI(String text);
    }
}
