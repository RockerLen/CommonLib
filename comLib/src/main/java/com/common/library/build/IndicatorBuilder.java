package com.common.library.build;

import android.content.Context;

import com.youth.banner.indicator.BaseIndicator;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;

public class IndicatorBuilder {

    public static final int CIRCLE_INDICATOR = 0;

    public static final int RECT_INDICATOR = 1;

    public static final int LINE_INDICATOR = 2;

    private BaseIndicator indicator;

    private IndicatorBuilder(int indicatorType, Context context) {
        switch (indicatorType) {
            case CIRCLE_INDICATOR:
                indicator = new CircleIndicator(context);
                break;
            case RECT_INDICATOR:
                indicator = new RectangleIndicator(context);
                break;
            case LINE_INDICATOR:
                indicator = new RoundLinesIndicator(context);
                break;
        }
    }

    public static IndicatorBuilder create(int indicatorType, Context context) {
        return new IndicatorBuilder(indicatorType, context);
    }

    public static IndicatorBuilder create(Context context) {
        return create(CIRCLE_INDICATOR, context);
    }

    public BaseIndicator getIndicator(){
        return indicator;
    }

    public IndicatorBuilder setMarginTop(int size){
        indicator.getIndicatorConfig().getMargins().topMargin = size;
        return this;
    }

    public IndicatorBuilder setMarginLeft(int size){
        indicator.getIndicatorConfig().getMargins().leftMargin = size;
        return this;
    }

    public IndicatorBuilder setMarginRight(int size){
        indicator.getIndicatorConfig().getMargins().rightMargin = size;
        return this;
    }

    public IndicatorBuilder setMarginBottom(int size){
        indicator.getIndicatorConfig().getMargins().bottomMargin = size;
        return this;
    }

    public IndicatorBuilder setSpaceWidth(int size){
        indicator.getIndicatorConfig().setIndicatorSpace(size);
        return this;
    }
}
