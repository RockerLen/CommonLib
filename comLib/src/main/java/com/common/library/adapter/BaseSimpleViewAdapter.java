package com.common.library.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class BaseSimpleViewAdapter<T, V extends View> extends BaseQuickAdapter<T, BaseSimpleViewAdapter.SimpleViewHolder> {

    public BaseSimpleViewAdapter(@Nullable List<T> data) {
        super(0, data);
    }

    @NotNull
    @Override
    protected BaseSimpleViewAdapter.SimpleViewHolder createBaseViewHolder(@NotNull ViewGroup parent, int layoutResId) {
        return new BaseSimpleViewAdapter.SimpleViewHolder(getItemView(parent.getContext()));
    }

    @Override
    protected void convert(@NotNull BaseSimpleViewAdapter.SimpleViewHolder simpleViewHolder, T t) {
        bindView(simpleViewHolder, t);
    }

    public abstract V getItemView(Context context);

    public abstract void bindView(SimpleViewHolder holder, T t);

    public class SimpleViewHolder extends BaseViewHolder {

        public SimpleViewHolder(@NotNull V view) {
            super(view);
        }

        public V getSimpleView() {
            return (V) itemView;
        }
    }

}
