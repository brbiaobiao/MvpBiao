package com.biaobiao.prijectLibrary.net.util;

import okhttp3.OkHttpClient;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe:
 */
public class OkHttpUtil {
    private static OkHttpClient okHttpClient;

    /**
     * 以builder的形式构建okhttp
     * @return
     */
    public static OkHttpClient getOkHttpClientInstance(){
        if (okHttpClient == null){
            synchronized (OkHttpUtil.class){
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
}
