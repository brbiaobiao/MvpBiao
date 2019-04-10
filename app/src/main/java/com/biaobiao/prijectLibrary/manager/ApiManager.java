package com.biaobiao.prijectLibrary.manager;

import com.biaobiao.prijectLibrary.mvp.api.MainApi;
import com.biaobiao.prijectLibrary.net.retrofit.AppHttpClient;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public class ApiManager {

    public static MainApi mainApi(){
        return AppHttpClient.create(MainApi.class);
    }
}
