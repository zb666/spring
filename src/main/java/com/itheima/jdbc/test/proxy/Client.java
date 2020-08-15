package com.itheima.jdbc.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        final IProducer producer = new Proxy();

        IProducer iProducer = (IProducer) java.lang.reflect.Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * 方法增强,可以对方法的参数进行解析，然后包装分析之类，但是不能够改变返回的对象
             * @param proxy 代理对象
             * @param method 当前执行的方法
             * @param args 方法参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object finalValue = null;
                Float money = (Float) args[0];
                if ("saleProduct".equals(method.getName())) {
                    //如果是销售的话就半价，不能是proxy对象，不然就造成递归了
                    finalValue = method.invoke(producer, money * 0.5f);
                } else {
                    //这样就死循环了
//                    finalValue = method.invoke(proxy,args);
                }
                return finalValue;
            }
        });
        iProducer.saleProduct(100);
    }
}
