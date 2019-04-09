package com.biaobiao.prijectLibrary.utils;

import com.biaobiao.prijectLibrary.net.ExceptionHandler;
import com.biaobiao.prijectLibrary.net.RxHttpResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: biao
 * @create: 2019/4/9
 * @Describe:
 */
public class RxUtil {

    public static void unSub(Disposable subscribe) {
        if (subscribe != null && !subscribe.isDisposed()) {
            subscribe.dispose();
        }
    }

    public static <T> ObservableTransformer<T, T> io2main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 网络请求使用,转换出泛型数据,并进行线程调度
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<RxHttpResponse<T>, T> httpAsyn() {
        return (upstream) -> {
            return upstream.map(new Function<RxHttpResponse<T>, T>() {
                public T apply(RxHttpResponse<T> response) throws Exception {
                    return response.getData();
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        };
    }

    /**
     * 只对网络请求数据进行转换,没有返回主线程
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<RxHttpResponse<T>, T> httpTrans() {
        return (upstream) -> {
            return upstream.map(new Function<RxHttpResponse<T>, T>() {
                public T apply(RxHttpResponse<T> response) throws Exception {
                    return response.getData();
                }
            }).subscribeOn(Schedulers.io());
        };
    }

    /**
     * rx异常
     */
    public static void setRxJavaErrorHandler() {
        try {
            if (!RxJavaPlugins.isLockdown()) {
                RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        ExceptionHandler.handle(throwable).show();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
