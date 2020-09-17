package com.common.library.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.kongzue.dialog.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialog.interfaces.OnInputDialogButtonClickListener;
import com.kongzue.dialog.interfaces.OnMenuItemClickListener;
import com.kongzue.dialog.util.DialogSettings;
import com.kongzue.dialog.v3.BottomMenu;
import com.kongzue.dialog.v3.CustomDialog;
import com.kongzue.dialog.v3.InputDialog;
import com.kongzue.dialog.v3.MessageDialog;
import com.kongzue.dialog.v3.WaitDialog;

/**
 * 对话框包装类
 * 引用到的Module: 'com.kongzue.dialog_v3x:dialog:3.2.3'
 */
public class DialogController {

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        DialogSettings.init();
//        defaultConfig {
//            renderscriptTargetApi 14
//            renderscriptSupportModeEnabled true    // Enable RS support
//        }
        DialogSettings.checkRenderscriptSupport(context); //高斯模糊
        //可以切换风格
        DialogSettings.style = DialogSettings.STYLE.STYLE_IOS;
        DialogSettings.theme = DialogSettings.THEME.LIGHT;
    }

    /**
     * 提示对话框
     *
     * @param activity
     * @param tipMessage
     */
    public static void showTipDialog(AppCompatActivity activity, String tipMessage) {
        MessageDialog.show(activity, "提示", tipMessage, "确定");
    }

    /**
     * 确认对话框
     *
     * @param activity
     * @param tipMessage
     * @param listener
     */
    public static void showConfirmDialog(AppCompatActivity activity, String tipMessage, OnDialogButtonClickListener listener) {
        MessageDialog.show(activity, "提示", tipMessage, "确定", "取消")
                .setButtonOrientation(LinearLayout.HORIZONTAL).setOnOkButtonClickListener(listener);
    }

    /**
     * 输入对话框
     *
     * @param activity
     * @param title
     * @param tipMessage
     * @param inputHint
     * @param listener
     */
    public static void showInputDialog(AppCompatActivity activity, String title, String tipMessage, String inputHint, OnInputDialogButtonClickListener listener) {
        InputDialog.build(activity)
                .setTitle(title)
                .setMessage(tipMessage)
                .setHintText(inputHint)
                .setOkButton("确定", listener)
                .setCancelButton("取消")
                .setCancelable(true)
                .show();
    }

    /**
     * 加载中对话框
     *
     * @param activity
     */
    public static void showLoading(AppCompatActivity activity) {
        WaitDialog.show(activity, "请稍候...").setTheme(DialogSettings.THEME.LIGHT).setCancelable(true);
    }

    /**
     * 关闭加载对话框
     */
    public static void hideLoading() {
        WaitDialog.dismiss();
    }

    /**
     * 自定义对话框,全屏
     *
     * @param activity
     * @param view
     */
    public static void show(AppCompatActivity activity, View view) {
        CustomDialog.show(activity, view).setFullScreen(true);
    }

    /**
     * 底部菜单选择对话框
     *
     * @param activity
     * @param title
     * @param menus
     * @param listener
     */
    public static void showBottomMenu(AppCompatActivity activity, String title, String[] menus, OnMenuItemClickListener listener) {
        BottomMenu.show(activity, menus, listener).setTitle(title);
    }
}
