package com.biaobiao.prijectLibrary.manager;

import com.biaobiao.prijectLibrary.BuildConfig;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe: App控制类
 */
public class AppConfig {

    /**
     * 全局debug提示
     */
    public static final boolean IS_DEBUG = !BuildConfig.ISRELEASE;

    public static String dversion = BuildConfig.VERSION_NAME;
}
