package com.R.IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * User: lijiaren
 * Date: 2016/2/28
 * Time: 14:18
 */
public class FreezeAlien {
    public static void  main(String[] args)throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
