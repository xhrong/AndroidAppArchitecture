package com.xhr.viper.presenter;


import com.xhr.viper.contract.CounterContract;
import com.xhr.viper.interator.CounterInterator;
import com.xhr.viper.entity.CounterEntity;
import com.xhr.viper.router.CounterRouter;

public class CounterPresenter implements CounterContract.IPresenter, CounterContract.InteractorOutput {

    private CounterInterator counterInterator;
    private CounterRouter counterRouter;
    private CounterContract.IView view;

    private CounterPresenter() {
        counterInterator = new CounterInterator(this);

    }

    public CounterPresenter(CounterContract.IView view, CounterRouter router) {
        this();
        this.view = view;
        this.counterRouter = router;
    }

    @Override
    public void add() {
        counterInterator.operate(1);
    }

    @Override
    public void sub() {
        counterInterator.operate(-1);
    }

    @Override
    public void goHome() {
        counterRouter.goToHomeScreen();
    }


    @Override
    public void onResult(CounterEntity model) {
        this.view.updateUI(model.getCountStr());
    }
}
