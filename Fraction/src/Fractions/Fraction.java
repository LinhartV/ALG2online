package Fractions;

public class Fraction 
{
    private int num; //numerator
    private int den; //denominator
    public Fraction (int num, int den)
    {
        this.num = num;
        this.den = den;
    }
    public Fraction (String frac)
    {
        String tempNum = "";
        String tempDen = "";
        boolean change = false;
        for (int i = 0; i<frac.length(); i++) 
        {
            if(frac.charAt(i)<48||frac.charAt(i)>57)
            {
                change=true;
                continue;
            }
            if(change)
                tempDen+=frac.charAt(i);
            else
                tempNum+=frac.charAt(i);
            
        }
        num = Integer.parseInt(tempNum);
        den = Integer.parseInt(tempDen);
    }
    public int getNum()
    {
        return num;
    }
    public int getDen()
    {
        return den;
    }
    public String getString ()
    {
        return Integer.toString(num)+"/"+Integer.toString(den); 
    }
    public Fraction simplify()
    {
        int p = num;
        int q = den;
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return new Fraction(num/p,den/p);
    }
}
