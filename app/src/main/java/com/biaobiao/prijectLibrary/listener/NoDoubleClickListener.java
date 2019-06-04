package com.biaobiao.prijectLibrary.listener;

import android.view.View;

import java.util.Calendar;

/**
 * @author: biao
 * @create: 2019/5/27
 * @Describe: 如类名
 */
public abstract class NoDoubleClickListener implements View.OnClickListener {
    private static final int MIN_CLICK_TIME = 1000;
    private long lastClickTime = 0;
    @Override
    public void onClick(View v) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - lastClickTime > MIN_CLICK_TIME){
            lastClickTime = timeInMillis;
            noDoubleClick(v);
        }
    }

    public abstract void noDoubleClick(View v);
}
