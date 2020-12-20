package com.xhr.mvp_clean.contract;

import com.xhr.mvp_clean.base.BasePresenter;
import com.xhr.mvp_clean.base.BaseView;

public interface CounterContract {

    public interface IPresenter extends BasePresenter {
        public void add();

        public void sub();
    }

    public interface IView extends BaseView<IPresenter> {
        public void updateUI(String text);
    }
}
