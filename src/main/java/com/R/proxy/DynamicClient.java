package com.R.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * User: lijiaren
 * Date: 2016/3/22
 * Time: 11:14
 */
public class DynamicClient {
    public static void main(String[] args){
        Subject subject = new RealSubject();
        InvocationHandler handler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),handler);
        proxy.doSomething("Finish");
    }
}
