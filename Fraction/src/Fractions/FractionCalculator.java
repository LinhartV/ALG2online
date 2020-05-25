
package Fractions;
public class FractionCalculator 
{
    static public Fraction sum (Fraction f1,Fraction f2)
    {
        return new Fraction(f1.getNum()*f2.getDen()+f2.getNum()*f1.getDen(),f1.getDen()*f2.getDen()).simplify();
    }
    static public Fraction subtract (Fraction f1,Fraction f2)
    {
        return new Fraction(f1.getNum()*f2.getDen()-f2.getNum()*f1.getDen(),f1.getDen()*f2.getDen()).simplify();
    }
    static public Fraction multiply (Fraction f1,Fraction f2)
    {
        return new Fraction(f1.getNum()*f2.getNum(),f1.getDen()*f2.getDen()).simplify();
    }
    static public Fraction devide (Fraction f1,Fraction f2)
    {
        return new Fraction(f1.getNum()*f2.getDen(),f1.getDen()*f2.getNum()).simplify();
    }
}
