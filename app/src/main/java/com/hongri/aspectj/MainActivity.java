package com.hongri.aspectj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.hongri.aspectj.aop.AopUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AopUtil.onCallMethod("哈哈");

        onCallMethod("hello");

        Log.d("AspectTest", "onCreate()方法");
    }

    public void onCallMethod(String string) {
        new AopUtil().onCallMethod("world");
    }
}