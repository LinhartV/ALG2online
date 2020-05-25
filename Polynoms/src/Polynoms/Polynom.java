package Polynoms;

public class Polynom 
{
    public double[] coef; //coefficients
    public Polynom(double[] coef)
    {
        this.coef = coef;
    }
    public double solve (double x)
    {
        int sum = 0;
        for (int i = 0; i < coef.length; i++) 
        {
            sum += coef[i] * Math.pow((int)x, i);
        }
        return sum;
    }
    public void constMultiply(double cons)
    {
        for (int i = 0; i < coef.length; i++) 
        {
            coef[i]*=cons;
        }
    }
    public void derivate()
    {
        for (int i = 1; i < coef.length; i++) 
        {
            coef[i-1] = i*coef[i];
        }
        coef[coef.length-1]=0;
    }
    
}
