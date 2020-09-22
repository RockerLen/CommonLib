package com.common.library.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public abstract class ViewPagerSimpleViewAdapter<T, V extends View> extends BannerAdapter<T, ViewPagerSimpleViewAdapter.QuickBannerViewHolder> {

    public ViewPagerSimpleViewAdapter(List<T> dataList) {
        super(dataList);
    }

    @Override
    public ViewPagerSimpleViewAdapter.QuickBannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        V view = getItemView(parent.getContext());
        Banner.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        return new QuickBannerViewHolder(view);
    }

    @Override
    public void onBindView(ViewPagerSimpleViewAdapter.QuickBannerViewHolder holder, T data, int position, int size) {
        bindView(holder, data, position);
    }

    public abstract V getItemView(Context context);

    public abstract void bindView(QuickBannerViewHolder holder, T data, int position);

    public class QuickBannerViewHolder extends RecyclerView.ViewHolder {

        public QuickBannerViewHolder(@NonNull V view) {
            super(view);
        }

        public V getView() {
            return (V) itemView;
        }
    }

}
