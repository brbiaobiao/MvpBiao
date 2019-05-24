package com.biaobiao.prijectLibrary;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.ReplacementTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.biaobiao.prijectLibrary.mvp.contact.MainContact;
import com.biaobiao.prijectLibrary.mvp.entity.TestEntity;
import com.biaobiao.prijectLibrary.mvp.presenter.MainPresenter;
import com.biaobiao.prijectLibrary.mvp.rxbase.BaseMvpActivity;
import com.biaobiao.prijectLibrary.utils.LoggUtil;

public class MainActivity extends BaseMvpActivity<MainContact.IPersenter> implements MainContact.IView {

    private TextView packname_tv;
    private TextView testvalue_tv;
    private Button request_btn;
    private Button getEdit_btn;
    private EditText edit;

    @Override
    protected Integer getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        packname_tv = (TextView)findViewById(R.id.packname_tv);
        testvalue_tv = (TextView)findViewById(R.id.testvalue_tv);
        request_btn = (Button)findViewById(R.id.request_btn);
        getEdit_btn = (Button)findViewById(R.id.getEdit_btn);
        edit = (EditText)findViewById(R.id.edit);
        packname_tv.setText(BuildConfig.APPLICATION_ID);

        request_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggUtil.d("okhttp","点击啦");
                getPresenter().getTestData();
            }
        });

        getEdit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testvalue_tv.setText(edit.getText().toString().trim());
            }
        });

        setEditKeyLisner();
    }

    @Override
    protected MainContact.IPersenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setData(TestEntity entity) {
//        testvalue_tv.setText(entity.getData().getDetail().get(0).getUrl());
    }

    private void setEditKeyLisner(){
        String regular = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        edit.setKeyListener(new DigitsKeyListener(){
            @Override
            public int getInputType() {
                return InputType.TYPE_TEXT_VARIATION_PASSWORD;

            }

            @Override
            protected char[] getAcceptedChars() {
                char[] ac = regular.toCharArray();
                return ac;
            }
        });

//        edit.setTransformationMethod(new A2bigA()); //获取输入的内容之后还是有小写的

        //这种方式能够拿到输入后的值还是大写
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                //先移除当前的监听，防止死循环
                edit.removeTextChangedListener(this);
                String upperCase = edit.getText().toString().toUpperCase();
                edit.setText(upperCase);
                edit.setSelection(upperCase.length());
                //操作完当前的ui修改后再设置监听
                edit.addTextChangedListener(this);
            }
        });
    }
}
