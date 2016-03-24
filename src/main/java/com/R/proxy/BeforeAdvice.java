package com.R.proxy;

/**
 * User: lijiaren
 * Date: 2016/3/22
 * Time: 11:03
 */
public class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        System.out.println("我是前置通知，我被执行了！");
    }
}
