package com.biaobiao.prijectLibrary.manager;


/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe:api管理类
 */
public class ApiConfig {

    public static final String BASE_URL_PRODU_EVIN = "";
    public static final String BASE_URL_TEST_EVIN = "";

    public static String getBaseURL(){
        return AppConfig.IS_DEBUG?BASE_URL_TEST_EVIN:BASE_URL_PRODU_EVIN;
    }
}
