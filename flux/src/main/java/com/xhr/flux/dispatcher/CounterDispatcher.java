package com.xhr.flux.dispatcher;

import com.xhr.flux.store.Store;
import com.xhr.flux.action.Action;

import java.util.ArrayList;
import java.util.List;

public class CounterDispatcher {
    private static CounterDispatcher INSTANCE;

    private List<Store> mStores;

    private CounterDispatcher() {
        mStores = new ArrayList<>();
    }

    public static CounterDispatcher getInstance() {
        if(INSTANCE == null) {
            synchronized (CounterDispatcher.class) {
                if(INSTANCE == null) {
                    INSTANCE = new CounterDispatcher();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 注册store,即把store添加到list中
     * @param store
     */
    public void register(Store store) {
        this.mStores.add(store);
    }

    /**
     * 注销store,从list中移除
     * @param store
     */
    public void unregister(Store store) {
        this.mStores.remove(store);
    }

    /**
     * 分发action
     * @param action
     */
    public void dispatch(Action action) {
        post(action);
    }

    /**
     * 向注册的store list依次分发acion
     * @param action
     */
    private void post(Action action) {
        for (Store store : mStores) {
            store.onAction(action);
        }
    }
}
