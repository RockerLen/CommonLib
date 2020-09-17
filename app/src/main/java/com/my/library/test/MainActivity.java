package com.my.library.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.common.library.util.PictureSelectorUtil;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;

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

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}