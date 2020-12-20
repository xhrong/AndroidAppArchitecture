package com.xhr.mvp_clean.presenter;


import com.xhr.mvp_clean.base.UseCase;
import com.xhr.mvp_clean.base.UseCaseHandler;
import com.xhr.mvp_clean.contract.CounterContract;
import com.xhr.mvp_clean.usecase.CountTask;

public class CounterPresenter implements CounterContract.IPresenter {

    private CounterContract.IView view;

    private CountTask countTask;
    private UseCaseHandler useCaseHandler;

    private CounterPresenter() {

    }

    public CounterPresenter(CounterContract.IView view, CountTask countTask, UseCaseHandler useCaseHandler) {
        this();
        this.view = view;
        this.countTask = countTask;
        this.useCaseHandler = useCaseHandler;
    }

    @Override
    public void add() {
        CountTask.RequestValues requestValue = new CountTask.RequestValues(1);
        useCaseHandler.execute(countTask, requestValue,
                new UseCase.UseCaseCallback<CountTask.ResponseValue>() {
                    @Override
                    public void onSuccess(CountTask.ResponseValue response) {
                        view.updateUI(response.getCounterModel().getCountStr());
                    }

                    @Override
                    public void onError() {

                    }
                });
    }



    @Override
    public void sub() {
        CountTask.RequestValues requestValue = new CountTask.RequestValues(-1);
        useCaseHandler.execute(countTask, requestValue,
                new UseCase.UseCaseCallback<CountTask.ResponseValue>() {
                    @Override
                    public void onSuccess(CountTask.ResponseValue response) {
                        view.updateUI(response.getCounterModel().getCountStr());
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
