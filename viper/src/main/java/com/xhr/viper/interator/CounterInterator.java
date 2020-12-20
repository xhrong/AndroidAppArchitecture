package com.xhr.viper.interator;

import com.xhr.viper.contract.CounterContract;
import com.xhr.viper.entity.CounterEntity;

/**
 * 本质是在Presenter之后，又抽象了一层，业务逻辑层
 */
public class CounterInterator implements CounterContract.Interactor {

    private CounterContract.InteractorOutput callback;

    private CounterEntity counterEntity;

    public CounterInterator(CounterContract.InteractorOutput callback) {
        this.callback = callback;
        this.counterEntity = new CounterEntity();
    }

    @Override
    public void operate(int c) {

        this.counterEntity = new CounterEntity(this.counterEntity.getCount() + c);

        this.callback.onResult(this.counterEntity);
    }
}
