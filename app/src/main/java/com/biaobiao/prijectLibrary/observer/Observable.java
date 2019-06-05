package com.biaobiao.prijectLibrary.observer;


/**
 * Created by
 *
 * @time 2019/5/7  0:19
 * @desc ${TODD}biao'biao
 */
public interface Observable {

    void add(Observer observer);

    void remove(Observer observer);

    void notify(String msg);
}
