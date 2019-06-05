package com.biaobiao.prijectLibrary.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 *
 * @time 2019/5/7  0:22
 * @desc ${TODD}biao'biao
 */
public class FatherOb implements Observable {

    private List<Observer> sonList = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        sonList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        sonList.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer observer : sonList){
            observer.updata(msg);
        }
    }
}
