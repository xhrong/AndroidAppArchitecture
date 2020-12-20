package com.xhr.viper.contract;


import com.xhr.viper.base.BasePresenter;
import com.xhr.viper.base.BaseView;
import com.xhr.viper.entity.CounterEntity;

public interface CounterContract {

    public interface IPresenter extends BasePresenter {
        public void add();

        public void sub();

        public void goHome();
    }

    public interface IView extends BaseView<IPresenter> {
        public void updateUI(String text);
    }

    public interface Interactor {
        public void operate(int c);
    }

    public interface InteractorOutput {
        public void onResult(CounterEntity model);
    }

    public interface Router {
        public void goToHomeScreen(); // Now the router handles it
    }
}
