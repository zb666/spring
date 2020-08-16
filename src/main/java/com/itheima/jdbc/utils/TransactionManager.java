package com.itheima.jdbc.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("txManger") //加了Component之后就能够被扫描到
@Aspect  //Aspect切面的配置类
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itheima.jdbc.service.impl.*.*(..))")
    private void pt1(){}

    public void beginTransaction(){
        try {
            //不设置自动提交，因为这个时候可能还未完成事务的整个操作
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint point){
        Object rtValue = null;
        try {
            Object[] args = point.getArgs();
            this.beginTransaction();
            //该切点会执行该方法
            rtValue = point.proceed(args);
            //提交事务  执行完毕之后才会走这个事务的提交
            this.commit();
            return rtValue;
        } catch (Throwable throwable) {
            this.rollback();
            throw new RuntimeException(throwable);
        }finally {
            this.release();
        }
    }

}


