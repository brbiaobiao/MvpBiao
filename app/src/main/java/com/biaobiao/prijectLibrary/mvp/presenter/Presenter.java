package com.biaobiao.prijectLibrary.mvp.presenter;

import com.biaobiao.prijectLibrary.mvp.rxbase.IBasePresenter;
import com.biaobiao.prijectLibrary.mvp.rxbase.RxLife;

import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public abstract class Presenter<V> implements IBasePresenter<V>, RxLife.IRxLift {

    private BehaviorSubject<RxLife.Event> mRxLifeSubject = RxLife.createSubject();

    private V view;
    private boolean isInited = false;//是否已经初始化

    public Presenter(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

    public void setView(V baseView) {
        this.view = baseView;
    }

    public void onStart() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.START);
    }

    public void onRestart() {
    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (ModuleActivity or Fragment) onResume() method.
     */
    public void onResume() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.RESUME);
        if (!isInited) {
            init();
            isInited = true;
        }
    }

    /**
     * 初始化presenter
     */
    protected abstract void init();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (ModuleActivity or Fragment) onPause() method.
     */
    public void onPause() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.PAUSE);
    }

    public void onStop() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.START);
    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * ModuleActivity onDestroy() method. Fragment onDestroyView() method.
     */
    public void onDestroy() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.DESTROY);
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.DESTROY_VIEW);
        view = null;
    }

    public boolean isAttach() {
        return view != null;
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLife() {
        return RxLife.bindLife(this);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLife(RxLife.Event event) {
        return RxLife.bindLife(this,event);
    }

    @Override
    public BehaviorSubject<RxLife.Event> getRxLiftSubject() {
        return mRxLifeSubject;
    }
}
