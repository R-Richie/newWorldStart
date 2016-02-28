package com.R.IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * User: lijiaren
 * Date: 2016/2/28
 * Time: 17:05
 */
public class RecoverCADState {
    public static void main(String[] args) throws Exception{
        @SuppressWarnings("unchecked")
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        //Read in the same order they were written
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>)in.readObject();
        Line.deserializeStatiecState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);

    }
}
