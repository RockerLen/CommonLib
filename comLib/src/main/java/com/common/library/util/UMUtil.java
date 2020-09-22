package com.common.library.util;

import android.app.Activity;
import android.util.Log;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.Map;

/**
 * 友盟集成第三方登陆分享的功能
 * <p>
 * <p>
 * 需要依赖的库
 * compileOnly 'com.umeng.umsdk:common:9.1.0'
 * compileOnly 'com.umeng.umsdk:asms:1.1.3'
 * compileOnly 'com.umeng.umsdk:crash:0.0.4'
 * compileOnly 'com.umeng.umsdk:common:2.2.5'
 * compileOnly 'com.umeng.umsdk:share-core:7.0.2'
 * compileOnly 'com.umeng.umsdk:share-board:7.0.2'
 * compileOnly 'com.umeng.umsdk:share-wx:7.0.2'
 * <p>
 * 添加
 * maven { url 'https://dl.bintray.com/umsdk/release' }
 */
public class UMUtil {

    public static void shareWxText(Activity activity, String msg) {
        new ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN).withText(msg).setCallback(new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onResult(SHARE_MEDIA share_media) {
                ToastUtils.showShort("分享成功");
            }

            @Override
            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                ToastUtils.showShort("分享失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {
                ToastUtils.showShort("分享取消");
            }
        }).share();
    }

    public static void shareWxImg(Activity activity, String imageUrl) {
        UMImage image = new UMImage(activity, imageUrl);//网络图片
        new ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN).withMedia(image).setCallback(new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onResult(SHARE_MEDIA share_media) {
                ToastUtils.showShort("分享成功");
            }

            @Override
            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                ToastUtils.showShort("分享失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {
                ToastUtils.showShort("分享取消");
            }
        }).share();
    }

    public static void shareWxLink(Activity activity, String linkUrl, String tile, String thumbUrl, String description) {
        UMWeb web = new UMWeb(linkUrl);
        web.setTitle(tile);//标题
        web.setThumb(new UMImage(activity, thumbUrl));  //缩略图
        web.setDescription(description);//描述

        new ShareAction(activity)
                .setPlatform(SHARE_MEDIA.WEIXIN)
                .withMedia(web)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        ToastUtils.showShort("分享成功");
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        ToastUtils.showShort("分享失败");
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {
                        ToastUtils.showShort("分享取消");
                    }
                })
                .share();
    }

    /**
     * 避免内存泄漏 UMShareAPI.get(this).release();
     *
     * @param activity
     */
    public static void wxLogin(Activity activity) {
        UMShareAPI shareAPI = UMShareAPI.get(Utils.getApp());
        if (!shareAPI.isInstall(activity, SHARE_MEDIA.WEIXIN)) {
            ToastUtils.showShort("没有安装微信");
            return;
        }
        shareAPI.getPlatformInfo(activity, SHARE_MEDIA.WEIXIN, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.e("onComplete", GsonUtils.toJson(map));
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                ToastUtils.showShort("微信登陆失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                ToastUtils.showShort("微信授权取消");
            }
        });
    }

}
