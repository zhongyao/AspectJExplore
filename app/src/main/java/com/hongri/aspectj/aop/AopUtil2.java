package com.hongri.aspectj.aop;

import android.util.Log;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AopUtil2 {

    public static void onCallMethod(String string) {
        Log.d("AspectTest", "----onCallMethod---" + string);
    }
    public void onDoSomeThing() {
        Log.d("AspectTest", "---");
    }
}
