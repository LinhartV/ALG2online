package Fractions;

public class FractionStarter {

    public static void main(String[] args)
    {
        Fraction f1 = new Fraction(10,1);
        Fraction f2 = new Fraction("2/1");
        System.out.println(FractionCalculator.multiply(f1, f2).getString());
    }
    
}
