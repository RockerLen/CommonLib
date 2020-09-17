package com.common.library.pull;

import android.content.Context;
import android.util.AttributeSet;

import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

public class SwipeRefreshLayout extends SmartRefreshLayout {

    public SwipeRefreshLayout(Context context) {
        super(context);
        init(context);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        SmartRefreshLayout.LayoutParams params = new SwipeRefreshLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        MaterialHeader materialHeader = new MaterialHeader(context);
        materialHeader.setLayoutParams(params);
        addView(materialHeader);
    }

    public void setRefreshListener(OnRefreshListener listener) {
        setOnRefreshListener(listener);
    }
}
