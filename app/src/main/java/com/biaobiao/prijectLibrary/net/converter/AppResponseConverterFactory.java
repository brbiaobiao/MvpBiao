package com.biaobiao.prijectLibrary.net.converter;

import com.biaobiao.prijectLibrary.net.ExceptionHandler;
import com.biaobiao.prijectLibrary.net.RxHttpResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe: Gson转换器拓展
 */
public class AppResponseConverterFactory extends ResponseConverterFactory<AppResponseConverterFactory.AppGsonResponseBodyConverter<?>>{
    public AppResponseConverterFactory(Gson gson) {
        super(gson);
    }

    @Override
    protected AppGsonResponseBodyConverter<?> createResponseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new AppGsonResponseBodyConverter<>(gson,type);
    }

    public static class AppGsonResponseBodyConverter<T> extends CustomerGsonResponseBodyConverter<T> {

        public AppGsonResponseBodyConverter(Gson gson, Type type) {
            super(gson, type);
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            String response = value.string();
//            LogUtils.json(response);
            RxHttpResponse httpResult = gson.fromJson(response, RxHttpResponse.class);
            if (httpResult.getCode() == 1) {
                return gson.fromJson(response, type);
            } else {
                throw new ExceptionHandler.APIErrorException(httpResult.getMessage(), httpResult.getCode());//自定义异常处理类
            }
        }
    }
}
