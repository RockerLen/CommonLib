package com.common.library.pull;

import android.content.Context;
import android.util.AttributeSet;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

/**
 * 具备下拉刷新，上拉加载的能力
 */
public class PullRefreshLayout extends SmartRefreshLayout {
    public PullRefreshLayout(Context context) {
        super(context);
        init(context);
    }

    public PullRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        ClassicsHeader header = new ClassicsHeader(context);
        SmartRefreshLayout.LayoutParams paramsHeader = new SmartRefreshLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        header.setLayoutParams(paramsHeader);
        setRefreshHeader(header);

        ClassicsFooter footer = new ClassicsFooter(context);
        SmartRefreshLayout.LayoutParams paramsFoot = new SmartRefreshLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        footer.setLayoutParams(paramsFoot);
        setRefreshFooter(footer);
    }

    public void setRefreshListener(OnRefreshLoadMoreListener listener) {
        setOnRefreshLoadMoreListener(listener);
    }

    public void setNoMoreData() {
        finishLoadMoreWithNoMoreData();
    }
}
