package com.biaobiao.prijectLibrary.design;

/**
 * @author: biao
 * @create: 2019/5/24
 * @Describe: 单例模式--饿汉式
 */
public class HungrySingleton {

    private HungrySingleton() {//构造函数有private,防止通过new创建更多对象，确保只要一个对象
    }

    //在类初始化时，已经自行实例化,所以是线程安全的
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON;
    }
}
