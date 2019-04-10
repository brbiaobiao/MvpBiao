package com.biaobiao.prijectLibrary.utils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe: 事件总线RxBus
 */
public class RxBus {

    private static volatile RxBus rxBus;
    private final Subject<Object> bus;

    public RxBus() {
        bus = PublishSubject.create();
    }

    public static RxBus getDefault(){
        if (rxBus == null){
            synchronized (RxBus.class){
                if (rxBus == null){
                    rxBus = new RxBus();
                }
            }
        }
        return rxBus;
    }

    public void post(Object t){
        bus.onNext(t);
    }

    public <T> Observable<T> toObserverable(Class<T> eventType){
        return bus.ofType(eventType);
    }


    public static void unrigister(Disposable disposable){
        if (disposable!=null&&!disposable.isDisposed()){
            disposable.dispose();
        }
    }

    /*
    实例：
        RxBus.getDefault().post(new ShowListItemChangeEvent(carId, ShowListItemChangeEvent.TYPE_DELETE));

        RxBus.getInstance()
                        .toObserverable(ShowListItemChangeEvent.class)
                        .compose(bindLife())
                        .subscribe(new NextObserver<ShowListItemChangeEvent>() {
                            @Override
                            public void onNext(ShowListItemChangeEvent event) {
                                //处理事件
                            }
                        });
    */
}
