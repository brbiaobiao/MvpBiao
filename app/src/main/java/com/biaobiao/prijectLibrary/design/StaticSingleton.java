package com.biaobiao.prijectLibrary.design;

/**
 * @author: biao
 * @create: 2019/5/24
 * @Describe: 单例模式--静态内部类
 */
public class StaticSingleton {
    private StaticSingleton() {
    }

    //静态内部类
    private static class SingleTonHolder{
        private static final StaticSingleton singleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        //第一次调用getInstance方法时才加载SingletonHolder并初始化sInstance
        return SingleTonHolder.singleton;
    }
}
