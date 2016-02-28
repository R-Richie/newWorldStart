package com.R.IO;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: lijiaren
 * Date: 2016/2/28
 * Time: 15:17
 */
public class Logon implements Serializable {
    private Date data = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        this.username = name;
        this.password = pwd;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "data=" + data +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Logon a = new Logon("Hulk", "myLittleRony");
        System.out.println("logon a = "+a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);
        //Now get them back
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at "+ new Date());
        a = (Logon)in.readObject();
        System.out.println("logon a = "+a);
    }
}
