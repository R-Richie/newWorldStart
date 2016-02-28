package com.R.IO.xfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * User: lijiaren
 * Date: 2016/2/28
 * Time: 14:21
 */
public class ThawALien {
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(".", "X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
