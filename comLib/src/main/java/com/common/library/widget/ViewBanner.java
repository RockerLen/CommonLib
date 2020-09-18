package com.common.library.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.youth.banner.Banner;

/**
 * 代替ViewPage
 */
public class ViewBanner extends Banner {
    public ViewBanner(Context context) {
        super(context);
    }

    public ViewBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context){
        isAutoLoop(false);
    }

}
