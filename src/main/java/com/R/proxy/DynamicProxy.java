package com.R.proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * User: lijiaren
 * Date: 2016/3/22
 * Time: 11:00
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h){
        if(true){
            (new BeforeAdvice()).exec();
        }
        return (T) Proxy.newProxyInstance(loader,interfaces,h);
    }
}
