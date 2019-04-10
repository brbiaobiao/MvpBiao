package com.biaobiao.prijectLibrary.utils;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe: rx事件总线，加入Rxlifecycle解决rxJava引起的内存泄露
 */
public class RxBus2 {

    private static volatile RxBus2 mDefault;
    private final Subject<Object> mBus;

    public RxBus2() {
        mBus = PublishSubject.create().toSerialized();
    }


    public static RxBus2 getDefault(){
        if (mDefault == null){
            synchronized (RxBus2.class){
                if (mDefault == null){
                    mDefault = new RxBus2();
                }
            }
        }
        return mDefault;
    }

    /**
     * 发送事件
     * @param t
     */
    public void post(Object t){
        mBus.onNext(t);
    }

    /**
     * 订阅事件
     * 使用Rxlifecycle解决rxJava引起的内存泄露
     * @param owner
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(LifecycleOwner owner,final Class<T> eventType){
        LifecycleProvider<Lifecycle.Event> provider = AndroidLifecycle.createLifecycleProvider(owner);
        return mBus.ofType(eventType).compose(provider.<T>bindToLifecycle());
    }

    public static void unrigister(Disposable disposable){
        if (disposable!=null&&!disposable.isDisposed()){
            disposable.dispose();
        }
    }

    /*
    实例：
        RxBus.getInstance().post(new MsgEvent("Java"));

        RxBus2.getDefault().toObservable(this,MsgEvent.class).subscribe(new Consumer<MsgEvent>() {
            @Override
            public void accept(MsgEvent msgEvent) throws Exception {
                //处理事件
            }
        });*/
}
