package com.R.proxy;

/**
 * User: lijiaren
 * Date: 2016/3/21
 * Time: 18:33
 */
public interface IGamePlayer {
    public void login(String user,String password);
    public void killBoss();
    public void upgrade();
    public IGamePlayer getProxy();
}
