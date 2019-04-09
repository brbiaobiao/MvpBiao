package com.biaobiao.prijectLibrary.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe:
 */
public class BaseApplication extends MultiDexApplication {

    protected static Context intansce;
    @Override
    public void onCreate() {
        super.onCreate();
        intansce = this;
    }

    public static Context getIntansce(){
        return intansce;
    }
}
