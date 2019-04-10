package com.biaobiao.prijectLibrary.net.retrofit;

import com.biaobiao.prijectLibrary.manager.AppConfig;
import com.biaobiao.prijectLibrary.manager.ApiConfig;
import com.biaobiao.prijectLibrary.net.converter.AppResponseConverterFactory;
import com.biaobiao.prijectLibrary.net.interceptor.AppRequestInterceptor;
import com.biaobiao.prijectLibrary.net.interceptor.LoggedInterceptor;
import com.biaobiao.prijectLibrary.utils.GsonUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe: 网络框架初始化构建
 */
public class AppRetrofitCreator implements RetrofitCreator {
    @Override
    public Retrofit create() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (AppConfig.IS_DEBUG){//在debug版本时才打印
            LoggedInterceptor loggedInterceptor = new LoggedInterceptor();
            loggedInterceptor.setLevel(LoggedInterceptor.Level.BODY);
            builder.addInterceptor(loggedInterceptor);//添加网络请求log请求拦截器
        }

        builder.addInterceptor(new AppRequestInterceptor());

        builder.connectTimeout(30*1000, TimeUnit.MILLISECONDS)
                .readTimeout(30*1000,TimeUnit.MILLISECONDS)
                .writeTimeout(30*1000,TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true);//失败重连

        OkHttpClient build = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConfig.getBaseURL())
                .addConverterFactory(new AppResponseConverterFactory(GsonUtil.getIntance()))//这里可以使用自定义的Gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//retrofit和rxJava适配器
                .client(build)
                .build();
        return retrofit;
    }
}
