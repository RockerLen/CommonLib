package com.common.library.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.common.library.R;
import com.common.library.build.IndicatorBuilder;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.transformer.ScaleInTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * &#x5bf9;&#x5e38;&#x89c4;Banner&#x7684;&#x4e00;&#x4e9b;&#x57fa;&#x7840;&#x5c01;&#x88c5;
 *
 * https://github.com/youth5201314/banner
 */

public class ImageBanner extends Banner {

    private List<String> imgPaths;

    private BannerImageAdapter adapter;

    private Drawable defaultDrawable;

    public ImageBanner(Context context) {
        super(context);
        init(context);
    }

    public ImageBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setIndicator(new RoundLinesIndicator(context));
        setIndicatorSpace(20);
        getIndicator().getIndicatorConfig().getMargins().bottomMargin = 40;
        setPageTransformer(new ScaleInTransformer());
        defaultDrawable = new ColorDrawable(ContextCompat.getColor(context, R.color.app_color_white_transparent));
        imgPaths = new ArrayList<>();
        adapter = new BannerImageAdapter<String>(imgPaths) {
            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                Glide.with(holder.itemView).load(data).placeholder(defaultDrawable).into(holder.imageView);
            }
        };
        setAdapter(adapter);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setIndicatorNormalColor(0x80ffffff);
        setIndicatorSelectedColor(0xffffffff);
        setIndicatorSelectedWidth(40);
    }

    /**
     * IndicatorBuilder.CIRCLE_INDICATOR;
     *
     * @param indicatorType
     */
    public void setIndicator(int indicatorType, Context context) {
        setIndicator(IndicatorBuilder.create(indicatorType, context).getIndicator());
    }

    public void setCircleIndicator(Context context) {
        setIndicator(IndicatorBuilder.create(context).getIndicator());
    }

    /**
     * 设置图片地址数组
     *
     * @param list
     */
    public void setImgPaths(List<String> list) {
        setDatas(list);
    }

    /**
     * 和Activity绑定在一起
     *
     * @param activity
     */
    public void start(AppCompatActivity activity) {
        addBannerLifecycleObserver(activity);
    }

    public void setMZGalleyStyle() {
        setBannerGalleryMZ(10, 0.9f);
    }
}
