package com.xhr.viper.router;

import android.content.Context;
import android.content.Intent;

import com.xhr.viper.contract.CounterContract;

/**
 * Router依赖Activity，耦合性太高。
 *
 * 可以考虑使用ARouter等组件进行解耦
 */
public class CounterRouter implements CounterContract.Router {
    private Context context;

    public CounterRouter(Context context) {
        this.context = context;
    }

    @Override
    public void goToHomeScreen() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);// "android.intent.action.MAIN"
        intent.addCategory(Intent.CATEGORY_HOME); //"android.intent.category.HOME"
        context.startActivity(intent);
    }
}
