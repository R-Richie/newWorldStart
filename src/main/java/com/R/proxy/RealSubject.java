package com.R.proxy;

/**
 * User: lijiaren
 * Date: 2016/3/22
 * Time: 10:49
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.println("do something!---->"+str);
    }
}
