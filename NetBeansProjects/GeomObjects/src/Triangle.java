
package GeomObj;

public class Triangle extends Shape
{
    public double a;
    public double b;
    public double c;
    public Triangle(double a, double b, double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    @Override
    public double circumference()
    {
        return a+b+c;
    }
    @Override
    public double area()
    {
        double p = circumference()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(9-c));
    }
    @Override
    public String name()
    {
        return "Triangle";
    }
}
