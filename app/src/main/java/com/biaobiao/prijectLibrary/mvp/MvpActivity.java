package com.biaobiao.prijectLibrary.mvp;

import android.os.Bundle;

import com.biaobiao.prijectLibrary.mvp.rxbase.IBasePresenter;
import com.biaobiao.prijectLibrary.mvp.rxbase.RxLifeActivity;

/**
 * @author: biao
 * @create: 2019/4/9
 * @Describe:
 */
public abstract class MvpActivity<T extends IBasePresenter> extends RxLifeActivity {

    private T mPresenter;

    public T getPresenter() {
        return mPresenter;
    }

    public void setPresenter(T presenter) {
        mPresenter = presenter;
        if (mPresenter != null){
            mPresenter.attach(this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mPresenter!=null) {
            mPresenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter!=null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter!=null) {
            mPresenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter!=null) {
            mPresenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null) {
            mPresenter.detach();
            mPresenter.onDestroy();
        }
    }
}
