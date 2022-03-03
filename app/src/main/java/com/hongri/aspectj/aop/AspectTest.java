package com.hongri.aspectj.aop;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 参考：https://mbd.baidu.com/ug_share/mbox/4a81af9963/share?tk=c12be6ea134361e65d0dd2dd52907905&share_url=https%3A%2F%2Fyebd1h.smartapps.cn%2Fpages%2Fblog%2Findex%3FblogId%3D84069529%26_swebfr%3D1%26_swebFromHost%3Dbaiduboxapp
 */
@Aspect
public class AspectTest {
    final String TAG = AspectTest.class.getSimpleName();

//    @Before("execution(* *..MainActivity+.on**(..))")
//    public void method(JoinPoint joinPoint) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        String className = joinPoint.getThis().getClass().getSimpleName();
//        Log.d(TAG, "method -- class:" + className);
//        Log.d(TAG, "method -- method:" + methodSignature.getName());
//    }

//    @After("execution(* *..MainActivity+.on**(..))")
//    public void method(JoinPoint joinPoint) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        String className = joinPoint.getThis().getClass().getSimpleName();
//        Log.d(TAG, "method -- class:" + className);
//        Log.d(TAG, "method -- method:" + methodSignature.getName());
//    }


    /**
     * Around:
     * 在方法执行前后和抛出异常时执行
     * @param proceedingJoinPoint
     * @throws Throwable
     */
//    @Around("call(* com.hongri.aspectj.MainActivity.setContentView(..))")
//    public void invokeSetContentView(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        Log.d(TAG, "执行setContentView方法前:" + System.currentTimeMillis());
//        proceedingJoinPoint.proceed();
//        Log.d(TAG, "执行setContentView方法后:" + System.currentTimeMillis());
//    }

    /**
     * target【调用此方法的对象是否是Type类型的子类或者其本身】：
     * target一般用在call的情况，call一个函数，这个函数可能定义在其他类。
     * 比如testMethod是TestDerived类定义的。那么target(TestDerived)就会搜索到调用testMethod的地方。
     * 但是不包括testMethod的execution JPoint
     *
     * @param joinPoint
     * @throws Throwable
     */
    //TODO 待调试
    //有问题
    @Around("call(* *..onCallMethod(java.lang.String)) && target(com.hongri.aspectj.aop.AopUtil)")
    //没问题
//    @Around("call(* com.hongri.aspectj.aop.AopUtil.onCallMethod(java.lang.String))")
    public void doSomeThing(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getThis().getClass().getSimpleName();
        String target = joinPoint.getTarget().toString();
        Log.d(TAG, "doSomeThing -- class:" + className);
        Log.d(TAG, "doSomeThing -- method:" + methodSignature.getName());
        Log.d(TAG, "doSomeThing -- target:" + target);
    }
}
