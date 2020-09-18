package com.my.library.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.common.library.build.IndicatorBuilder;
import com.common.library.util.PictureSelectorUtil;
import com.common.library.widget.BannerView;
import com.common.library.widget.ImageBanner;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.BaseIndicator;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.RotateDownPageTransformer;
import com.youth.banner.transformer.RotateUpPageTransformer;
import com.youth.banner.transformer.RotateYTransformer;
import com.youth.banner.transformer.ScaleInTransformer;
import com.youth.banner.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<LocalMedia> list;

    String path = "/storage/emulated/0/DCIM/Camera/VID_20200917_15090740.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();



        ImageBanner bannerView = findViewById(R.id.banner);
        bannerView.setImgPaths(getList());

        //bannerView.setPageTransformer(new AlphaPageTransformer());
        //bannerView.setPageTransformer(new DepthPageTransformer());
        //bannerView.setPageTransformer(new RotateDownPageTransformer());
        //bannerView.setPageTransformer(new RotateUpPageTransformer());
        //bannerView.setPageTransformer(new RotateYTransformer());
        //bannerView.setPageTransformer(new ScaleInTransformer());
        //bannerView.setPageTransformer(new ZoomOutPageTransformer());
        bannerView.start(this);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TestActivity.class);
                startActivity(intent);
            }
        });
    }

    public List<String> getList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < 10; i1++) {
            list.add("");
        }
        return list;
    }
}