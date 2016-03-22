package com.R.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * User: lijiaren
 * Date: 2016/3/21
 * Time: 17:00
 */
public class MyMock {
    public static <T> T mock(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MockInterceptor());
        return (T)enhancer.create();
    }
    private static class MockInterceptor implements MethodInterceptor{
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            return null;
        }
    }
    public static void main(String[] args){
//        Calculate
    }
}


