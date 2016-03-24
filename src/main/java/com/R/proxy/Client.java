package com.R.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * User: lijiaren
 * Date: 2016/3/21
 * Time: 18:41
 */
public class Client {
    public static void main(String[] args) throws Throwable{
        IGamePlayer player = new GamePlayer("张三");
        InvocationHandler handler = new GamePlayIH(player);
        System.out.println("开始时间是：2016-3-21 18:43");
        ClassLoader cl = player.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
        proxy.login("zhangsSan","password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是：2016-3-21 18:30");
    }
}
