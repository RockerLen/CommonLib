package com.common.library.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;

import com.common.library.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.style.PictureParameterStyle;

import java.io.File;
import java.util.List;

public class PictureSelectorUtil {

    /**
     * 选择图片
     *
     * @param activity
     * @param hasChose
     * @param listener
     */
    public static void selectImg(Activity activity, List<LocalMedia> hasChose, OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .selectionMode(PictureConfig.MULTIPLE)
                .maxSelectNum(9)
                .isCompress(true)
                .minimumCompressSize(100)
                .synOrAsy(false)
                .selectionData(hasChose)
                .theme(R.style.picture_white_style)
                .isMaxSelectEnabledMask(true) //开启蒙层效果
                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED)
                .selectionData(hasChose)
                .forResult(listener);
    }

    /**
     * 选择视频
     *
     * @param activity
     * @param hasChose
     * @param listener
     */
    public static void selectVideo(Activity activity, List<LocalMedia> hasChose, OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofVideo())
                .imageEngine(GlideEngine.createGlideEngine())
                .selectionMode(PictureConfig.MULTIPLE)
                .maxSelectNum(9)
                .selectionData(hasChose)
                .theme(R.style.picture_white_style)
                .isMaxSelectEnabledMask(true) //开启蒙层效果
                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED)
                .selectionData(hasChose)
                .forResult(listener);
    }

    /**
     * 选择图片和视频
     *
     * @param activity
     * @param hasChose
     * @param listener
     */
    public static void selectVideoAndImg(Activity activity, List<LocalMedia> hasChose, OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofAll())
                .imageEngine(GlideEngine.createGlideEngine())
                .selectionMode(PictureConfig.MULTIPLE)
                .isCompress(true)
                .minimumCompressSize(100)
                .synOrAsy(false)
                .maxSelectNum(9)
                .maxVideoSelectNum(9)
                .isWithVideoImage(true)
                .selectionData(hasChose)
                .theme(R.style.picture_white_style)
                .isMaxSelectEnabledMask(true) //开启蒙层效果
                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED)
                .selectionData(hasChose)
                .forResult(listener);
    }

    /**
     * 选择头像专用
     *
     * @param activity
     * @param listener
     */
    public static void chooseHeadImg(Activity activity, OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .selectionMode(PictureConfig.SINGLE)
                .isEnableCrop(true)
                .freeStyleCropEnabled(false)
                .scaleEnabled(true)
                .isDragFrame(false)
                .withAspectRatio(1, 1)
                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED)
                .forResult(listener);
    }

    /**
     * 调用相机拍照
     *
     * @param activity
     * @param listener
     */
    public static void takePhoto(Activity activity, OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.create(activity)
                .openCamera(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .forResult(listener);
    }

    /**
     * 调用相机录制视频
     *
     * @param activity
     * @param listener
     */
    public static void recordVideo(Activity activity, OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.create(activity)
                .openCamera(PictureMimeType.ofVideo())
                .recordVideoSecond(10)
                .imageEngine(GlideEngine.createGlideEngine())
                .forResult(listener);
    }

    /**
     * 预览选择的 Media
     *
     * @param activity
     * @param selectList
     * @param currentPos
     */
    public static void previewImg(Activity activity, List<LocalMedia> selectList, int currentPos) {
        PictureSelector.create(activity)
                .themeStyle(R.style.picture_default_style)
                .isNotPreviewDownload(true)
                .imageEngine(GlideEngine.createGlideEngine())
                .openExternalPreview(currentPos, selectList);
    }

    /**
     * 预览本地视频
     *
     * @param activity
     * @param videoPath
     */
    public static void previewVideo(Activity activity, String videoPath) {
        PictureSelector.create(activity).externalPictureVideo(videoPath);
    }

}
