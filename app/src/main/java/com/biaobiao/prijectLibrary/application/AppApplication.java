package com.biaobiao.prijectLibrary.application;

import com.biaobiao.prijectLibrary.manager.AppManager;
import com.biaobiao.prijectLibrary.net.AppExceptionHandler;
import com.biaobiao.prijectLibrary.net.ExceptionHandler;
import com.biaobiao.prijectLibrary.net.retrofit.AppHttpClient;
import com.biaobiao.prijectLibrary.net.retrofit.AppRetrofitCreator;

import java.util.logging.Handler;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe:
 */
public class AppApplication extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        AppManager.setApplication(this);
        //初始化网络框架
        AppHttpClient.init(new AppRetrofitCreator());

        ExceptionHandler.init(new AppExceptionHandler());
    }
}
