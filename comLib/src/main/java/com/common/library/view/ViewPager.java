package com.common.library.view;

import android.content.Context;
import android.util.AttributeSet;

import com.common.library.adapter.ViewPagerLayoutAdapter;
import com.common.library.adapter.ViewPagerSimpleViewAdapter;
import com.youth.banner.Banner;

/**
 * 用来代替ViewPage
 * <p>
 * <p>
 * https://github.com/youth5201314/banner
 */
public class ViewPager extends Banner {
    public ViewPager(Context context) {
        super(context);
        init(context);
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        isAutoLoop(false);
    }

    public void setViewBannerAdapter(ViewPagerLayoutAdapter adapter, boolean isRepeat) {
        setAdapter(adapter, isRepeat);
    }

    public void setViewBannerAdapter(ViewPagerSimpleViewAdapter adapter, boolean isRepeat) {
        setAdapter(adapter, isRepeat);
    }

}
