package com.biaobiao.prijectLibrary.mvp.model;

import com.biaobiao.prijectLibrary.manager.ApiManager;
import com.biaobiao.prijectLibrary.mvp.api.MainApi;
import com.biaobiao.prijectLibrary.mvp.entity.TestEntity;
import com.biaobiao.prijectLibrary.utils.RxUtil;

import io.reactivex.Observable;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public class MainModel extends ApiModel<MainApi> {

    public MainModel() {
        super(ApiManager.mainApi());
    }

    public Observable<TestEntity> getTestData(){
        return getApi().getTestData().compose(RxUtil.httpAsyn());
    }

}
