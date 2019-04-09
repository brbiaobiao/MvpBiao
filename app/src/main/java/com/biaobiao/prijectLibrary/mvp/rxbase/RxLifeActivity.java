package com.biaobiao.prijectLibrary.mvp.rxbase;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.Nullable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * @author: biao
 * @create: 2019/4/9
 * @Describe: 监听rx生命周期activity
 */
public abstract class RxLifeActivity extends AppCompatActivity implements RxLife.IRxLift {
    private BehaviorSubject<RxLife.Event> mRxLifeSubject = RxLife.createSubject();

    @Override
    public BehaviorSubject<RxLife.Event> getRxLiftSubject() {
        return mRxLifeSubject;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.CREATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.RESUME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.STOP);
    }

    @Override
    protected void onPause() {
        super.onPause();
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.PAUSE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.DESTROY);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLife() {
        return RxLife.bindLife(this);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLife(RxLife.Event event) {
        return RxLife.bindLife(this, event);
    }
}
