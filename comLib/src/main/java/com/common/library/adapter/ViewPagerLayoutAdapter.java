package com.common.library.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public abstract class ViewPagerLayoutAdapter<T> extends BannerAdapter<T, ViewPagerLayoutAdapter.QuickBannerLayoutHolder> {

    private int layoutId;

    private LayoutInflater inflater;

    public ViewPagerLayoutAdapter(@LayoutRes int layoutId, @Nullable List<T> dataList) {
        super(dataList);
        this.layoutId = layoutId;
    }

    @Override
    public ViewPagerLayoutAdapter.QuickBannerLayoutHolder onCreateHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return new QuickBannerLayoutHolder(inflater.inflate(layoutId, parent, false));
    }

    @Override
    public void onBindView(ViewPagerLayoutAdapter.QuickBannerLayoutHolder holder, T data, int position, int size) {
        bindView(holder, data, position);
    }

    public abstract void bindView(QuickBannerLayoutHolder holder, T data, int position);

    public class QuickBannerLayoutHolder extends RecyclerView.ViewHolder {

        private final SparseArray<View> views;

        public QuickBannerLayoutHolder(@NonNull View itemView) {
            super(itemView);
            this.views = new SparseArray<>();
        }

        @SuppressWarnings("unchecked")
        public <T extends View> T getView(@IdRes int viewId) {
            View view = views.get(viewId);
            if (view == null) {
                view = itemView.findViewById(viewId);
                views.put(viewId, view);
            }
            return (T) view;
        }
    }
}
