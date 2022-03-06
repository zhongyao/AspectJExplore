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
 * 参考：https://juejin.cn/post/6844903941054922760
 */
@Aspect //用Aspect 声明一个类，用来表示需要执行的一个切面
public class AspectTest {
    final String TAG = AspectTest.class.getSimpleName();

    /**
     * Before：切入点前织入
     * After：切入点后织入，无论连接点执行如何，包括正常的 return 和 throw 异常
     * AfterReturning：只有在切入点正常返回之后才会执行，不指定返回类型时匹配所有类型
     * AfterThrowing：只有在切入点抛出异常后才执行，不指定异常类型时匹配所有类型
     * execution：被织入到指定的方法内部
     * @param joinPoint
     * @throws Throwable
     */
    @Before("execution(* *..MainActivity+.on**(..))")
//    @After("execution(* *..MainActivity+.on**(..))")
    public void method(JoinPoint joinPoint) throws Throwable {
        //this
        Object className = joinPoint.getThis();
        //target
        Object target = joinPoint.getTarget();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Log.d(TAG, "method -- this:" + className);
        Log.d(TAG, "method -- target:" + target);
        Log.d(TAG, "method -- method:" + methodSignature.getName());
    }


    /**
     * Around：替代原有切点，如果要执行原来代码的话，调用 ProceedingJoinPoint.proceed()
     * call：被织入在指定方法被调用的位置上
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
     * Around：替换原有切点
     * target：指切入点方法的所有者
     * this：指被织入代码所属类的实例对象
     *
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    // 切入语句解释：* 表示返回任意类型  ..表示匹配任意类型。即：当调用com.hongri.aspectj.aop.AopUtil类中，
    // 参数类型为String的onCallMethod方法时，会被替换成调用以下的doSomeThing方法
//    @Around("call(* *..onCallMethod(java.lang.String)) && target(com.hongri.aspectj.aop.AopUtil)")

    //切入语句解释：跟上面切入语句效果相同
//    @Around("call(* com.hongri.aspectj.aop.AopUtil.onCallMethod(java.lang.String))")
/*    public void doSomeThing(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //this
        Object className = proceedingJoinPoint.getThis();
        //target
        String target = proceedingJoinPoint.getTarget().toString();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Log.d(TAG, "doSomeThing -- this:" + className);
        Log.d(TAG, "doSomeThing -- target:" + target);
        Log.d(TAG, "doSomeThing -- method:" + methodSignature.getName());
        //执行原方法
        proceedingJoinPoint.proceed();
    }*/
}
