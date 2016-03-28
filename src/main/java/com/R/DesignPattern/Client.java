package com.R.DesignPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * User: lijiaren
 * Date: 2016/3/28
 * Time: 14:50
 */
public class Client {
    public static void invoker(){
        Father f = new Father();
//        Son f = new Son();
        HashMap map = new HashMap();
        f.doSomething(map);
    }
    public static void main(String[] args){
        invoker();
    }
}
