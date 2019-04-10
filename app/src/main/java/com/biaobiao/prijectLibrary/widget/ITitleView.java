package com.biaobiao.prijectLibrary.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.TextView;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public interface ITitleView {
    void setTitleText(String title);

    void setTitleRightIcon(Drawable drawable);

    void setTitleRightIcon(@DrawableRes int res);

    void setTitleRightIconClick(View.OnClickListener listener);

    void setTitleRightText(String text);
    void setTitleRightTextColor(int color);

    void setTitleRightTextClick(View.OnClickListener listener);

    void isShowRightIcon(boolean visiable);

    void setTitleLeftTextClick(View.OnClickListener listener);

    void isShowHeadDivider(boolean visiable) ;

    void isShowTitleRightText(boolean visible);

    View getTitleBar();

    View getTitleView();

    TextView getLeftTextView();

    TextView getRightTextView();

    View getLeftIconView();

    View getRightIconView();
}
