package com.common.library.build;

import com.luck.picture.lib.config.PictureConfig;

public class SelectBuild {

    public static final int STYLE_WHITE = 0;

    public static final int STYLE_BLACK = 0;

    private int style;

    private int selectMode; //多选，单选

    private int maxSelectNum;

    private boolean enableCrop; //开启裁剪

    private boolean enableCompress; //开启亚索

    private SelectBuild(){
        style = STYLE_WHITE;
        selectMode = PictureConfig.MULTIPLE;
        maxSelectNum = 9;
        enableCrop = false;
    }

    public static SelectBuild SelectBuild(){
        return new SelectBuild();
    }


}
