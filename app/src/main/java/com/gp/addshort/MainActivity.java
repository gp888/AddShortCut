package com.gp.addshort;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent shortcutIntent = new Intent(this, SecondActivity.class);
        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //普通添加快捷方式
        Button btn_addShort = (Button) findViewById(R.id.btn_addShortcut);
        ColorStateList csl=(ColorStateList)getResources().getColorStateList(R.color.button_text);
        btn_addShort.setTextColor(csl);

        btn_addShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortCutUtil.addShortcut(getApplicationContext(),"测试",shortcutIntent, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.weixin),false);
            }
        });
        //删除
        //api25不行
        Button btn_removeShortcut = (Button) findViewById(R.id.btn_removeShortcut);
        btn_removeShortcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortCutUtil.deleteShortcut(getApplicationContext(),"测试",shortcutIntent,true);
            }
        });
        //添加本应用程序的快捷图标
        Button shortcut = (Button) findViewById(R.id.shortcut);
        shortcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortCutUtil.addApplicationShortcut(MainActivity.this);
            }
        });
        //添加onekeyclean快捷图标
        Button onekeyclean = (Button) findViewById(R.id.onekeyclean);
        onekeyclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortCutUtil.addOneKeyCleanShortcut(MainActivity.this);
            }
        });
        //我的游戏
        Button GameShortCut = (Button) findViewById(R.id.GameShortCut);
        GameShortCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortCutUtil.addMyGameShortcut(MainActivity.this, BitmapFactory.decodeResource(getResources(),R.drawable.weixin));
            }
        });
        //更新我的游戏
        Button upDateGameShortcut = (Button) findViewById(R.id.upDateGameShortcut);
        upDateGameShortcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortCutUtil.updateMyGameShortcut(MainActivity.this,BitmapFactory.decodeResource(getResources(),R.drawable.game));
            }
        });
    }
}
