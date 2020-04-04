
package GeomObj;

public class Rectangle extends Shape
{
    double a;
    double b;
    public Rectangle(double a, double b)
    {
        this.a = a;
        this.b = b;
    }
    @Override
    public String name()
    {
        return "Rectangle";
    }
    @Override
    public double circumference()
    {
        return 2*(a+b);
    }
    @Override
    public double area()
    {
        return a*b;
    }
}
