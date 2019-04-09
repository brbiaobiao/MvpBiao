package com.biaobiao.prijectLibrary.mvp.rxbase;

/**
 * @author: biao
 * @create: 2019/4/9
 * @Describe:
 */
public interface IBasePresenter<V> {

    V getView();

    void setView(V baseView);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attach(V view);

    void detach();
}
