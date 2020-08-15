package com.itheima.jdbc.test.cglib;

import com.itheima.jdbc.test.proxy.Proxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    public static void main(final String[] args) {
        //执行的是对该对象所执行方法的动态的代理
        final Proxy mProxy = new Proxy();

        /**
         * 动态代理
         * 字节码技术，随用随加载
         */
       Proxy proxy = (Proxy) Enhancer.create(mProxy.getClass(), new MethodInterceptor() {
            /**
             *
             * @param proxy 代理对象
             * @param method 被代理的方法
             * @param objects
             * @param methodProxy 当前执行的代理对象
             * @return methodProxy
             * @throws Throwable
             */
            public Object intercept(
                    Object proxy,
                    Method method,
                    Object[] objects,
                    MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) objects[0];
                if(method.getName().equals("saleProduct")){
                    returnValue = method.invoke(mProxy,money*0.6f);
                }
                return returnValue;
            }
        });
        proxy.saleProduct(100.0f);
    }
}
