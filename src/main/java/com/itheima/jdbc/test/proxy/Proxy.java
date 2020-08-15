package com.itheima.jdbc.test.proxy;

//原先的实现
public class Proxy implements IProducer {

    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱："+money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
