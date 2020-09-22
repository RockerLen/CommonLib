package com.my.library.test;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.common.library.adapter.BaseSimpleViewAdapter;
import com.common.library.util.DimenUtils;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TestAdapter3 extends BaseSimpleViewAdapter<String, TextView> {

    public TestAdapter3(@Nullable List<String> data) {
        super(data);
    }

    @Override
    public TextView getItemView(Context context) {
        TextView textView = new TextView(context);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DimenUtils.dpToPixels(100));
        textView.setLayoutParams(params);
        textView.setBackgroundColor(Color.GRAY);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void bindView(SimpleViewHolder holder, String s) {
        holder.getSimpleView().setText(s);
    }
}
