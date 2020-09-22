package com.my.library.test;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.common.library.adapter.ViewPagerSimpleViewAdapter;

import java.util.List;

public class TestAdapter extends ViewPagerSimpleViewAdapter<String, TextView> {

    public TestAdapter(List<String> dataList) {
        super(dataList);
    }

    @Override
    public TextView getItemView(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.BLUE);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void bindView(QuickBannerViewHolder holder, String data, int position) {
        holder.getView().setText(data);
    }

}
