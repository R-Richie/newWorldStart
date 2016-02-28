package com.R.IO;





import java.io.*;
import java.util.ArrayList;
import java.util.Random;


/**
 * Saving the state of a pretend CAD system.
 * User: lijiaren
 * Date: 2016/2/28
 * Time: 16:29
 */
abstract class Shape implements Serializable{
    public static final int RED = 1,BLUE =2,GREEN = 3;
    private int xPos,yPos,dismension;
    private static Random rand = new Random(47);
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();

    public Shape(int xPos, int yPos, int dismension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dismension = dismension;
    }

    @Override
    public String toString() {
        return getClass() + "color["+getColor()+"] xPos["+xPos+"] yPos["+yPos+"] dim["+dismension+"]\n";
    }
    public static Shape randomFactory(){
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3){
            default:
            case 0:return new Circle(xVal,yVal,dim);
            case 1:return new Square(xVal,yVal,dim);
            case 2:return new Line(xVal,yVal,dim);

        }
    }
}
class Circle extends Shape{
    private static int color = RED;

    public Circle(int xPos, int yPos, int dismension) {
        super(xPos, yPos, dismension);
    }
    public void setColor(int newColor){ color = newColor;}
    public int getColor(){return color;}
}

class Square extends Shape{
    private static int color;

    public Square(int xPos, int yPos, int dismension) {
        super(xPos, yPos, dismension);
        color = RED;
    }
    public void setColor(int newColor){ color = newColor;}

    @Override
    public int getColor() {
        return color;
    }
}
class Line extends Shape{
    private static int color = RED;
    public  static void serializeStaticState(ObjectOutputStream os) throws IOException{
        os.writeInt(color);
    }
    public static void deserializeStatiecState(ObjectInputStream os) throws  IOException{
        color = os.readInt();
    }

    public Line(int xPos, int yPos, int dismension) {
        super(xPos, yPos, dismension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}
public class StoreCADState {
    public static void main(String[] args) throws Exception{
        ArrayList<Class<? extends Shape>> shapeType = new ArrayList<>();
        //Add references to the class Objects;
        shapeType.add(Circle.class);
        shapeType.add(Square.class);
        shapeType.add(Line.class);
        ArrayList<Shape> shapes = new ArrayList<>();
        //Make some shapes:
        for (int i = 0; i < 10;i++)
            shapes.add(Shape.randomFactory());
        //set all the static colors to Green:
        for (int i = 0; i<10;i++)
            ((Shape)shapes.get(i)).setColor(Shape.GREEN);
        //Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeType);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        //Dispaly the shapes:
        System.out.println(shapes);
    }
}
