package com.biaobiao.prijectLibrary.mvp.api;

import com.biaobiao.prijectLibrary.mvp.entity.TestEntity;
import com.biaobiao.prijectLibrary.net.RxHttpResponse;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public interface MainApi {

    @POST("Task.queryPlatFormUsedCar")
    Observable<RxHttpResponse<TestEntity>> getTestData();
}
