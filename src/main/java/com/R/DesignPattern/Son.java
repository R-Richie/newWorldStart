package com.R.DesignPattern;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: lijiaren
 * Date: 2016/3/28
 * Time: 14:49
 */
public class Son extends Father {
    public Collection doSomething(Map map){
        System.out.println("子类被执行...");
        return map.values();
    }
}
