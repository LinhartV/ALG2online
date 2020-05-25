
package Polynoms;
public class Polynomy 
{
    public static Polynom polSum(Polynom p1,Polynom p2)
    {
        int length = p2.coef.length<p1.coef.length?p1.coef.length:p2.coef.length;
        Polynom p = new Polynom(new double[length]);
        for (int i = 0; i < length; i++) 
        {
            if(i>=p1.coef.length)
                 p.coef[i]= p2.coef[i];
            else if(i>=p2.coef.length)
                 p.coef[i]= p1.coef[i];
            else
                p.coef[i]= p1.coef[i]+p2.coef[i];
        }
        return p;
    }
    public static Polynom polSubtract(Polynom p1,Polynom p2)
    {
        int length = p2.coef.length<p1.coef.length?p1.coef.length:p2.coef.length;
        Polynom p = new Polynom(new double[length]);
        for (int i = 0; i < length; i++) 
        {
            if(i>=p1.coef.length)
                 p.coef[i]= p2.coef[i];
            else if(i>=p2.coef.length)
                 p.coef[i]= p1.coef[i];
            else
                p.coef[i]= p1.coef[i]-p2.coef[i];
        }
        return p;
    }
    public static Polynom polMultiply(Polynom p1,Polynom p2)
    {
        double[] tempcoef = new double [p1.coef.length+p2.coef.length-1];
        
        for (int i = 0; i < p1.coef.length; i++) 
        {
            for (int j = 0; j < p2.coef.length; j++) 
            {
                tempcoef[i+j]+=p1.coef[i]*p2.coef[j];
            }
        }
        return new Polynom(tempcoef);
    }
}
