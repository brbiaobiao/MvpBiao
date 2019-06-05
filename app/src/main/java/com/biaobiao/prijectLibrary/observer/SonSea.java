package com.biaobiao.prijectLibrary.observer;

/**
 * Created by
 *
 * @time 2019/5/7  0:25
 * @desc ${TODD}biao'biao
 */
public class SonSea implements Observer {

    private String name;

    public SonSea(String name) {
        this.name = name;
    }

    @Override
    public void updata(String msg) {
        System.out.println(name+"收到了消息:"+msg+"后开始傲娇拒绝");
    }
}
