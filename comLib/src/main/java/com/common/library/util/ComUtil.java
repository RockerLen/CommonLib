package com.common.library.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.common.library.R;

public class ComUtil {

    public static Drawable getDefaultDrawable(Context context) {
        return new ColorDrawable(ContextCompat.getColor(context, R.color.app_color_white_transparent));
    }

}
