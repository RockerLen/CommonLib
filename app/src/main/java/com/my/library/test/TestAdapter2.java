package com.my.library.test;

import androidx.annotation.Nullable;

import com.common.library.adapter.ViewPagerLayoutAdapter;

import java.util.List;

public class TestAdapter2 extends ViewPagerLayoutAdapter<String> {

    public TestAdapter2(int layoutId, @Nullable List<String> dataList) {
        super(layoutId, dataList);
    }

    @Override
    public void bindView(QuickBannerLayoutHolder holder, String data, int position) {

    }
}
