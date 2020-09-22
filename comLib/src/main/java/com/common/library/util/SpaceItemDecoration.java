package com.common.library.util;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int ORIENTATION_HORIZONTAL = 2;

    public int recyclerType;

    private int spaceWith;

    private int orientation;

    private GridLayoutManager gridLayoutManager;

    private GridLayoutManager.SpanSizeLookup spanSizeLookup;

    public static SpaceItemDecoration getLinerItemDecoration() {
        return new SpaceItemDecoration(TYPE_LINEAR_LAYOUT, 5, ORIENTATION_VERTICAL);
    }

    public static SpaceItemDecoration getLinerItemDecoration(int spaceWith) {
        return new SpaceItemDecoration(TYPE_LINEAR_LAYOUT, spaceWith, ORIENTATION_VERTICAL);
    }

    public static SpaceItemDecoration getGridItemDecoration() {
        return new SpaceItemDecoration(TYPE_GRID_LAYOUT, 5, ORIENTATION_VERTICAL);
    }

    public static SpaceItemDecoration getGridItemDecoration(int spaceWith) {
        return new SpaceItemDecoration(TYPE_GRID_LAYOUT, spaceWith, ORIENTATION_VERTICAL);
    }

    public SpaceItemDecoration(int type, int sp, int orientation) {
        this.recyclerType = type;
        this.spaceWith = dp2px(sp);
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (recyclerType == TYPE_LINEAR_LAYOUT) {
            int childPos = parent.getChildAdapterPosition(view);
            int itemCount = parent.getAdapter().getItemCount();
            if (childPos != itemCount - 1) {
                if (orientation == ORIENTATION_VERTICAL) {
                    outRect.bottom = spaceWith;
                } else {
                    outRect.right = spaceWith;
                }
            }
        } else {
            if (gridLayoutManager == null)
                gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
            if (spanSizeLookup == null) spanSizeLookup = gridLayoutManager.getSpanSizeLookup();

            int spanSet = gridLayoutManager.getSpanCount();
            int childPos = parent.getChildAdapterPosition(view);
            int index = spanSizeLookup.getSpanIndex(childPos, spanSet);
            int indexGroup = spanSizeLookup.getSpanGroupIndex(childPos, spanSet);
            int nextIndexGroup = spanSizeLookup.getSpanGroupIndex(childPos + 1, spanSet);
            if (nextIndexGroup <= indexGroup) {
                outRect.right = spaceWith / 2;
            }
            if (index != 0) {
                outRect.left = spaceWith / 2;
            }

            int lastGroup = spanSizeLookup.getSpanGroupIndex(parent.getAdapter().getItemCount() - 1, spanSet);
            if (indexGroup != lastGroup) {
                outRect.bottom = spaceWith;
            }
        }
    }

    public int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
