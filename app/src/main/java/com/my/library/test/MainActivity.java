package com.my.library.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.common.library.Test;
import com.common.library.dialog.DialogController;
import com.kongzue.dialog.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialog.interfaces.OnInputDialogButtonClickListener;
import com.kongzue.dialog.interfaces.OnMenuItemClickListener;
import com.kongzue.dialog.util.BaseDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogController.init(this);

        //Test.test(getApplication());

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogController.showBottomMenu(MainActivity.this, "选择性别", new String[]{"男", "女"}, new OnMenuItemClickListener() {
                    @Override
                    public void onClick(String text, int index) {
                        Log.e("..........", text);
                    }
                });
            }
        });
    }
}