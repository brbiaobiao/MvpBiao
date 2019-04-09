package com.biaobiao.prijectLibrary.net.converter;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe:
 */
public abstract class CustomerGsonResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    protected final Gson gson;
    protected final Type type;

    public CustomerGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }
}
