package com.biaobiao.prijectLibrary.observer;

/**
 * Created by
 *
 * @time 2019/5/7  0:27
 * @desc ${TODD}biao'biao
 */
public class SonZhen implements Observer {

    private String name;

    public SonZhen(String name) {
        this.name = name;
    }

    @Override
    public void updata(String msg) {
        System.out.println(name+"收到了消息:"+msg+"屁颠屁颠照做了");
    }
}
