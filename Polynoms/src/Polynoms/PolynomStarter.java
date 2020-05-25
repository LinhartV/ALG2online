
package Polynoms;

public class PolynomStarter 
{
    public static void main(String[] args) 
    {
        double[]coef1 = {1,2,3};
        Polynom p1 = new Polynom(coef1);
        double[]coef2 = {1,2};
        Polynom p2 = new Polynom(coef2);
        System.out.println("Polynom 1");
        for (int i = 0; i < p1.coef.length; i++) 
        {
            System.out.print(p1.coef[i]+" ");
        }
        System.out.println("\nPolynom 2");
        for (int i = 0; i < p2.coef.length; i++) 
        {
            System.out.print(p2.coef[i]+" ");
        }
        Polynom p3=Polynomy.polSum(p1, p2);
        System.out.println("\nSum:");
        for (int i = 0; i < p3.coef.length; i++) 
        {
            System.out.print(p3.coef[i]+" ");
        }
        System.out.println("\nMultiply:");
        for (int i = 0; i < Polynomy.polMultiply(p1, p2).coef.length; i++) 
        {
            System.out.print(Polynomy.polMultiply(p1, p2).coef[i]+" ");
        }
        System.out.println("\nPolynom 1 solution for number 2:");
        System.out.println(p1.solve(2));
        System.out.println("Polynom 1 derivation:");
        p1.derivate();
        for (int i = 0; i < p1.coef.length; i++) 
        {
            System.out.print(p1.coef[i]+" ");
        }
        
        
    }
    
}
