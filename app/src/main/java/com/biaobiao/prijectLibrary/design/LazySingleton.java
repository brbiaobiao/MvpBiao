package com.biaobiao.prijectLibrary.design;

/**
 * @author: biao
 * @create: 2019/5/24
 * @Describe: 单例模式--懒汉式
 */
public class LazySingleton {
    private LazySingleton() {
    }

    private static LazySingleton singleton = null;

    //加上synchronized同步，线程安全
    public synchronized static LazySingleton getInstance(){
        if (singleton == null){
            //在第一次调用getInstance()时才实例化，实现懒加载,所以叫懒汉式
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
