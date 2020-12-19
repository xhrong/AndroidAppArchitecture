package com.xhr.flux.store;

import com.xhr.flux.action.Action;

import org.greenrobot.eventbus.EventBus;

/**
 * 如果不采用EventBus，而是采用其它方案驱动数据流，就会和其他的Unidirectional Architecture相似了。
 */

public abstract class Store {
    private static final EventBus mBus = EventBus.getDefault();

    protected Store() {

    }

    public void register(Object view) {
        this.mBus.register(view);
    }

    public void unregister(Object view) {
        this.mBus.unregister(view);
    }

    /**
     * post事件到view层,进行UI的后续处理
     */
    protected void emitStoreChange() {
        this.mBus.post(changeEvent());
    }


    /**
     * 处理Action的逻辑,子类必须实现此方法
     * @param action
     */
    public abstract void onAction(Action action);

    /**
     * post事件
     * @return
     */
    protected abstract StoreChangeEvent changeEvent();

    public class StoreChangeEvent{}
}
