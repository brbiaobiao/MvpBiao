package com.biaobiao.prijectLibrary.mvp.rxbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * @author: biao
 * @create: 2019/4/9
 * @Describe:
 */
public class RxLifeFragment extends Fragment implements RxLife.IRxLift {
    private BehaviorSubject<RxLife.Event> mRxLifeSubject = RxLife.createSubject();

    @Override
    public BehaviorSubject<RxLife.Event> getRxLiftSubject() {
        return mRxLifeSubject;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.CREATE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.RESUME);
        super.onResume();
    }

    @Override
    public void onStart() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.START);
        super.onStart();
    }

    @Override
    public void onStop() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.STOP);
        super.onStop();
    }

    @Override
    public void onPause() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.PAUSE);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.DESTROY);
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.ATTACH);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.CREATE_VIEW);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDetach() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.DETACH);
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        RxLife.onEvent(mRxLifeSubject, RxLife.Event.DESTROY_VIEW);
        super.onDestroyView();
    }
}
