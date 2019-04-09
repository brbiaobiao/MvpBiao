package com.biaobiao.prijectLibrary.net.retrofit;

import retrofit2.Retrofit;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe: 暴露retrofit构建方法
 */
public interface RetrofitCreator {

    /**
     * 创建和初始化retrofit
     * @return 创建好的retrofit对象
     */
    Retrofit create();
}
