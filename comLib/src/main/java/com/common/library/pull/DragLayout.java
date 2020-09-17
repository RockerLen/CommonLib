package com.common.library.pull;

import android.content.Context;
import android.util.AttributeSet;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/**
 * 可以上下拖动的layout
 */
public class DragLayout extends SmartRefreshLayout {

    public DragLayout(Context context) {
        super(context);
        init();
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setEnablePureScrollMode(true);
        setEnableLoadMore(false);
        setDragRate(0.2f);
        setEnableOverScrollDrag(true);
    }
}
