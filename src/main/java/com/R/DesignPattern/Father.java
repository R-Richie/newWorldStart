package com.R.DesignPattern;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: lijiaren
 * Date: 2016/3/28
 * Time: 14:48
 */
public class Father {
    public Collection doSomething(HashMap map){
        System.out.println("父类被执行。。");
        return map.values();
    }
}
