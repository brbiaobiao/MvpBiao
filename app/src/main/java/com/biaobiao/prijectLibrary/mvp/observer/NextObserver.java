package com.biaobiao.prijectLibrary.mvp.observer;

import io.reactivex.disposables.Disposable;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public abstract class NextObserver<T> extends BasicObserver<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
