package com.biaobiao.prijectLibrary.mvp.observer;

import com.biaobiao.prijectLibrary.net.ExceptionHandler;
import com.biaobiao.prijectLibrary.utils.LoggUtil;

import io.reactivex.Observer;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public abstract class BasicObserver<T> implements Observer<T> {

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        LoggUtil.d("BasicObserver","失败回调");
        ExceptionHandler.handle(e).show();
    }
}
