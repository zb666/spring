package com.itheima.jdbc.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class Logger {


    @Pointcut("execution(* com.itheima.jdbc.service.impl.*.*(..))")
    private void pt1() {
    }

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint) {
        Object rtValue = null;
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("--- 开始记录日志了 --- 前置");
            rtValue = joinPoint.proceed(args);
            System.out.println("--- 开始记录日志了 --- 后置");
        } catch (Throwable ex) {
            ex.printStackTrace();
            System.out.println("--- 开始记录日志了 --- 异常");
        } finally {
            System.out.println("--- 开始记录日志了 --- 最终");
        }
        return rtValue;
    }

}
