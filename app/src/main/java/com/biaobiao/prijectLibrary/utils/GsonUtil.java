package com.biaobiao.prijectLibrary.utils;

import com.google.gson.Gson;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe:
 */
public class GsonUtil {
    private static Gson gson;

    public static synchronized Gson getIntance(){
        if (gson == null){
            gson = new Gson();
        }
        return gson;
    }
}
