package com.biaobiao.prijectLibrary.mvp.contact;

import com.biaobiao.prijectLibrary.mvp.rxbase.IBasePresenter;
import com.biaobiao.prijectLibrary.mvp.rxbase.IContextView;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public interface MainContact {

    interface IView extends IContextView{

    }

    interface IPersenter extends IBasePresenter<IView>{
        void getTestData();
    }
}
