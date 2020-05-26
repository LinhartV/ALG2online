package linhart_alg2_sem_equationtraining.utils;

/**
 * An interface all equation classes inherits from
 */
public interface EquationInterface 
{
    public String equation();
    public String rules();
    public boolean isAccessible();
    public String accessError();
    public int getEntryFee();
    public int getPenalty();
    public int getProfit();
    public String getSolution();
}
