package com.biaobiao.prijectLibrary.mvp;

import android.content.Context;

import com.biaobiao.prijectLibrary.mvp.rxbase.IBasePresenter;
import com.biaobiao.prijectLibrary.mvp.rxbase.RxLifeFragment;

/**
 * @author: biao
 * @create: 2019/4/9
 * @Describe:
 */
public abstract class MvpFragment<T extends IBasePresenter> extends RxLifeFragment {

    private T mPresenter;

    public T getPresenter() {
        return mPresenter;
    }

    public void setPresenter(T presenter) {
        mPresenter = presenter;
        if (mPresenter!=null){
            mPresenter.attach(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mPresenter!=null) {
            getPresenter().onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter!=null) {
            getPresenter().onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter!=null) {
            getPresenter().onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter!=null) {
            getPresenter().onStop();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter!=null) {
            getPresenter().detach();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null) {
            getPresenter().onDestroy();
        }
    }
}
