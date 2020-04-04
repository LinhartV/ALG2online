
package GeomObj;

import java.util.ArrayList;
import java.util.Scanner;


public class GeomObjStarter {

    public static void main(String[] args) 
    {
        ArrayList<Shape> l = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add an object by pressing:\ns-square\nr-rectangle\nc-circle\ne-ellipse\nt-triangle\n\nTrigger action by pressing:\nd-display all current objects\na-Compute the total area of all objects\nm-find object with the smallest circumference\nn-find object with the largest circumference\n\nx-exit the program");
        String obj = sc.next();
        while(obj!="x")
        {
            switch(obj)
            {
                case "s":
                    System.out.println("Write in the length of the square");
                    l.add(new Square(sc.nextDouble()));
                    System.out.println("Square added");
                    break;
                case "r":
                    System.out.println("Write in the width and height of the rectangle");
                    l.add(new Rectangle(sc.nextDouble(),sc.nextDouble()));
                    System.out.println("Rectangle added");
                    break;
                case "c":
                    System.out.println("Write in the radius of the circle");
                    l.add(new Circle(sc.nextDouble()));
                    System.out.println("Circle added");
                    break;   
                case "e":
                    System.out.println("Write in length of the semi-minor axis and semi-major axis of the ellipse");
                    l.add(new Ellipse(sc.nextDouble(),sc.nextDouble()));
                    System.out.println("Ellipse added");
                    break; 
                case "t":
                    System.out.println("Write in length of the tree side of the triangle");
                    l.add(new Triangle(sc.nextDouble(),sc.nextDouble(),sc.nextDouble()));
                    System.out.println("Trianlge added");
                    break;
                case "d":
                    for (int i = 0; i < l.size(); i++) 
                    {
                        System.out.println(l.get(i).name());
                    }
                    break;
                case "a":
                    double area = 0;
                    for (int i = 0; i < l.size(); i++) 
                    {
                        area += l.get(i).area();
                    }
                    System.out.println("Total area is "+area);
                    break;
                case "m":
                    Shape mins = l.get(0);
                    for (int i = 0; i < l.size(); i++) 
                    {
                        if(mins.circumference()>l.get(i).circumference())
                            mins = l.get(i);
                    }
                    System.out.println("Minimum circumference has "+mins.name());
                    break;
                case "n":
                    Shape maxs = l.get(0);
                    for (int i = 0; i < l.size(); i++) 
                    {
                        if(maxs.circumference()<l.get(i).circumference())
                            maxs = l.get(i);
                    }
                    System.out.println("Maximum circumference has "+maxs.name());
                    break;
            }
            obj = sc.next();
        }
    }
    
}
