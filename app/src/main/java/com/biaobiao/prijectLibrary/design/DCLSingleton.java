package com.biaobiao.prijectLibrary.design;

/**
 * @author: biao
 * @create: 2019/5/24
 * @Describe: 单利模式--双重检查锁定
 */
public class DCLSingleton {

    //volatile 能够防止代码的重排序，保证得到的对象是初始化过
    private volatile static DCLSingleton singleton;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance(){
        if (singleton == null){//第一次检查，避免不必要的同步
            synchronized (DCLSingleton.class){
                if (singleton == null){//第二次检查
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
