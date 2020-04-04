
package GeomObj;

public class Circle extends Ellipse 
{
    double r;
    public Circle(double r) 
    {
        super(r,r);
    }
    @Override
    public String name()
    {
        return "Circle";
    }
}
