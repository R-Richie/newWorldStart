package com.R.proxy;

/**
 * User: lijiaren
 * Date: 2016/3/21
 * Time: 18:41
 */
public class Client {
    public static void main(String[] args){
        IGamePlayer player = new GamePlayer("张三");
        IGamePlayer proxy = player.getProxy();
        System.out.println("开始时间是：2016-3-21 18:43");
        proxy.login("zhangsSan","password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是：2016-3-21 18:30");
    }
}
