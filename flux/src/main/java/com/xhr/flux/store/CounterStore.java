package com.xhr.flux.store;

import com.xhr.flux.action.Action;
import com.xhr.flux.action.CounterAction;
import com.xhr.flux.model.CounterBean;
import com.xhr.flux.model.CounterModel;

public class CounterStore extends Store {

    private CounterModel counterModel;

    public CounterStore() {
        super();
        setCounterModel(new CounterModel());
    }


    @Override
    public void onAction(Action action) {
        switch (action.getType()) {
            case CounterAction
                    .COUNTER_ACTION:
                CounterBean bean = (CounterBean) action.getData();
                counterModel.operate(bean.step);
                break;
            default:
        }
        emitStoreChange();
    }

    @Override
    protected StoreChangeEvent changeEvent() {
        //这个事件，仅用做业务区分，可不携带数据。数据和通过Store获取
        return new StoreChangeEvent();
    }

    public CounterModel getCounterModel() {
        return counterModel;
    }

    private void setCounterModel(CounterModel counterModel) {
        this.counterModel = counterModel;
    }
}
