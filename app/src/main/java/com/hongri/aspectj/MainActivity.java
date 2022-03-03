package com.hongri.aspectj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.hongri.aspectj.aop.AopUtil;
import com.hongri.aspectj.aop.AopUtil2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AopUtil.onCallMethod("哈哈");
//        AopUtil2.onCallMethod("哈哈2");

        onCallMethod("hello");

        Log.d("AspectTest", "onCreate()方法");
    }

    public void onCallMethod(String string) {
        new AopUtil().onCallMethod("world");
    }
}