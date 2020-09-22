package com.common.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;

import com.common.library.R;
import com.common.library.util.ColorUtils;
import com.common.library.util.DimenUtils;

/**
 * BootstrapEditText allows users to enter values like a regular Android EditText, and allows coloring
 * via BootstrapBrand, and rounding of its background.
 */
public class FrameEditText extends AppCompatEditText {

    private boolean rounded;
    private float cornerRadius;
    private float borderWidth;
    private int borderColor;

    private int DP_10 = DimenUtils.dpToPixels(10);

    public FrameEditText(Context context) {
        super(context);
        initialise(null);
    }

    public FrameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public FrameEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FrameEditText);
        try {
            this.rounded = a.getBoolean(R.styleable.FrameEditText_roundedCorners, true);
            this.cornerRadius = a.getDimension(R.styleable.FrameEditText_cornerRadius, DimenUtils.dpToPixels(5));
            this.borderWidth = a.getDimension(R.styleable.FrameEditText_borderWidth, DimenUtils.dpToPixels(1));
            this.borderColor = a.getColor(R.styleable.FrameEditText_borderColor, getResources().getColor(R.color.bootstrap_gray_light));
        } finally {
            a.recycle();
        }

        GradientDrawable activeDrawable = new GradientDrawable();
        activeDrawable.setColor(ColorUtils.resolveColor(android.R.color.white, getContext()));
        if (rounded) {
            activeDrawable.setCornerRadius(cornerRadius);
        }
        activeDrawable.setStroke((int) borderWidth, borderColor);
        setBackgroundDrawable(this, activeDrawable);
        if (getPaddingLeft() == 0) {
            setPadding(DP_10, 0, DP_10, 0);
        }
        setGravity(Gravity.CENTER_VERTICAL);
    }

    public void setBackgroundDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
