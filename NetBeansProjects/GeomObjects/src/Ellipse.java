
package GeomObj;

public class Ellipse extends Shape
{
    public double a;
    public double b;
    public Ellipse(double a, double b)
    {
        this.a = a;
        this.b = b;
    }
    @Override
    public double area()
    {
        return Math.PI*a*b;
    }
    @Override
    public double circumference()
    {
        return Math.PI*a*b;
    }
    @Override
    public String name()
    {
        return "Ellipse";
    }
}
