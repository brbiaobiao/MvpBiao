package com.biaobiao.prijectLibrary.mvp.rxbase;

import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * @author: biao
 * @create: 2019/4/9
 * @Describe: rx生命周期管理
 */
public class RxLife {

    public static BehaviorSubject<Event> createSubject() {
        return BehaviorSubject.create();
    }

    public static void onEvent(BehaviorSubject<Event> subject, Event event) {
        subject.onNext(event);
    }

    public static <T> ObservableTransformer<T, T> bindLife(IRxLift lift) {
        return upstream -> upstream.takeUntil(lift.getRxLiftSubject().skipWhile(t -> t != Event.DESTROY));
    }

    public static <T> ObservableTransformer<T, T> bindLife(IRxLift lift, Event event) {
        return upstream -> upstream.takeUntil(lift.getRxLiftSubject().skipWhile(t -> t != event));
    }

    public interface IRxLift {
        BehaviorSubject<Event> getRxLiftSubject();

        <T> ObservableTransformer<T, T> bindLife();

        <T> ObservableTransformer<T, T> bindLife(Event event);
    }

    public enum Event {
        // Activity life Events
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY,
        // Fragment life  Events
        ATTACH,
        CREATE_VIEW,
        DESTROY_VIEW,
        DETACH,
    }
}
