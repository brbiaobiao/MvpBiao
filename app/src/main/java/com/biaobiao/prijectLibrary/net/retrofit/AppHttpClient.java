package com.biaobiao.prijectLibrary.net.retrofit;

import retrofit2.Retrofit;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe: 网络请求的初始化。在app启动时初始化
 */
public class AppHttpClient {

    /**
     * retrofit对象
     */
    private static volatile Retrofit retrofit = null;
    private static RetrofitCreator mCreators;

    private static Retrofit getInstance(){
        if (retrofit == null){
            synchronized (AppHttpClient.class){
                retrofit = mCreators.create();
            }
        }
        return retrofit;
    }

    /**
     * 在application中初始化
     * @param creator
     */
    public static void init(RetrofitCreator creator){
        AppHttpClient.mCreators = creator;
        retrofit = creator.create();
    }


    /**
     * retrofit的请求方式
     * @param tClass 请求接口
     */
    public static <T> T create(Class<T> tClass){
        return getInstance().create(tClass);
    }
}
