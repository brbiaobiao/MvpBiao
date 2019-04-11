package com.biaobiao.prijectLibrary.mvp.presenter;

import com.biaobiao.prijectLibrary.mvp.contact.MainContact;
import com.biaobiao.prijectLibrary.mvp.entity.TestEntity;
import com.biaobiao.prijectLibrary.mvp.model.MainModel;
import com.biaobiao.prijectLibrary.mvp.observer.NextObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public class MainPresenter extends Presenter<MainContact.IView> implements MainContact.IPersenter {

    private MainModel mMainModels;
    public MainPresenter(MainContact.IView view) {
        super(view);
    }

    @Override
    protected void init() {
        mMainModels = new MainModel();

    }

    @Override
    public void getTestData() {
        mMainModels.getTestData()
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindLife())
                .subscribe(new NextObserver<TestEntity>() {
                    @Override
                    public void onNext(TestEntity testEntity) {
                        getView().setData(testEntity);
                    }
                });
    }
}
