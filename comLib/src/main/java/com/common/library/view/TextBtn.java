package com.common.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.common.library.R;
import com.common.library.util.DimenUtils;

public class TextBtn extends AppCompatTextView {

    private boolean rounded;
    private float cornerRadius;
    private float borderWidth;
    private int borderColor;
    private int solidColor;
    private int fillType;

    public TextBtn(@NonNull Context context) {
        super(context);
        initialise(null);
    }

    public TextBtn(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public TextBtn(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TextBtn);
        try {
            this.fillType = a.getInt(R.styleable.TextBtn_fillType, 0);
            this.rounded = a.getBoolean(R.styleable.TextBtn_roundedCorners, true);
            this.cornerRadius = a.getDimension(R.styleable.TextBtn_cornerRadius, DimenUtils.dpToPixels(5));
            this.borderWidth = a.getDimension(R.styleable.TextBtn_borderWidth, DimenUtils.dpToPixels(1));
            this.borderColor = a.getColor(R.styleable.TextBtn_borderColor, getResources().getColor(R.color.bootstrap_gray_light));
            this.solidColor = a.getColor(R.styleable.TextBtn_solidColor, Color.WHITE);
        } finally {
            a.recycle();
        }

        GradientDrawable activeDrawable = new GradientDrawable();
        activeDrawable.setColor(solidColor);
        if (rounded) {
            activeDrawable.setCornerRadius(cornerRadius);
        }
        if (fillType == 1) {
            activeDrawable.setStroke((int) borderWidth, borderColor);
        }
        setBackgroundDrawable(this, activeDrawable);
        setGravity(Gravity.CENTER);
    }

    public void setBackgroundDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
