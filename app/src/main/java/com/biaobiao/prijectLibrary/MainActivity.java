package com.biaobiao.prijectLibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.biaobiao.prijectLibrary.mvp.MvpActivity;
import com.biaobiao.prijectLibrary.mvp.contact.MainContact;
import com.biaobiao.prijectLibrary.mvp.presenter.MainPresenter;
import com.biaobiao.prijectLibrary.mvp.rxbase.BaseMvpActivity;
import com.biaobiao.prijectLibrary.utils.LoggUtil;

public class MainActivity extends BaseMvpActivity<MainContact.IPersenter> implements MainContact.IView {

    private TextView packname_tv;
    private Button request_btn;

    @Override
    protected Integer getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected MainContact.IPersenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        packname_tv = (TextView)findViewById(R.id.packname_tv);
        request_btn = (Button)findViewById(R.id.request_btn);
        packname_tv.setText(BuildConfig.APPLICATION_ID);

        request_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggUtil.d("okhttp","点击啦");
                getPresenter().getTestData();
            }
        });
    }
}
