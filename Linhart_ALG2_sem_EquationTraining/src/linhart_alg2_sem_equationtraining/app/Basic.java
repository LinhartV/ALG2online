package linhart_alg2_sem_equationtraining.app;

import linhart_alg2_sem_equationtraining.utils.GlobalVars;
import linhart_alg2_sem_equationtraining.utils.EquationInterface;

/**
 * Provides all logic concerning basic examples
 * 
 * An example of equation: 2 + 5 or -5 * 2 + 8
 */
public class Basic extends GlobalVars implements EquationInterface
{
    int solution = 0;

    @Override
    public String getSolution() 
    {
        return Integer.toString(solution);
    }
    /**
     * Sets the equation and it's solution
     * 
     * Creates the examples depending on user's score. The higher the score, the more difficult the example is. Difficulty is represented by number of operands, range of possible values to be generated (e. q. maximum value of generated number for user with score 100 is 50, whereas for score 1000 will be 500) and higher chance for multiplication to appear instead of addition.
     * 
     * @return an equation in String format
     */
    @Override
    public String equation()
    {
        int score = suser.score;
        if(score<10)
            score = 10;
        StringBuilder sb = new StringBuilder();
        int varCount = 2+suser.score/150; //Number of operands to be generated depending on user's score (minimum 2)
        int[] ar = new int[varCount]; //Array of operands
        boolean[] oper = new boolean[varCount-1];//Array of operators; true = multiplication, false = addition
        solution = 0;
        for (int i = 0; i < ar.length; i++) 
        {
            //Multiplication
            if((Math.random()*1000<score&&Math.random()>0.3)&&i!=0)
            {
                ar[i] = (int)(Math.random()*Math.sqrt(score)-Math.sqrt(score)/2)+1;
                oper[i-1]=true;
                sb.append(" * ").append(ar[i]);
            }
            //Addition
            else
            {
                if(i!=0)
                    oper[i-1] = false;
                ar[i] = (int)(Math.random()*score-score/2);
                if(i==0)
                    sb.append(ar[i]);
                else if(ar[i]>=0)
                    sb.append(" + ").append(ar[i]);
                else
                    sb.append(" - ").append(Math.abs(ar[i]));
            }
        }
        int savesol=ar[0];
        for (int i = 0; i < oper.length; i++) 
        {
            if(oper[i]==true)
            {
                if(i==0||oper[i-1]==false)
                    savesol = ar[i];
                savesol*=ar[i+1];
            }
            else
            {
                solution+=savesol;
                savesol = ar[i+1];
            }
        }
        solution += savesol;
        return sb.toString();
    }
    @Override
    public String rules()
    {
        return "You will have 60 seconds to complete as many examples as possible.\nFor each equation correctly solved, you'll earn "+ this.getProfit()+" points.\nEach wrong answer will lose you "+ this.getPenalty()+" points.\nTo entre the Basic mode, "+ this.getEntryFee()+" score points will be taken off.\nDo you really want to continue?\ny - yes\nn - no";
    }
    /**
     * Determines whether the user can enter this mode
     * 
     * @return always true as this mode is never unaccessible
     */
    @Override
    public boolean isAccessible()
    {
        return true;
    }
    /**
     * An error to be displayed if the user's score is too to cannot enter this mode
     * @return an error message
     */
    @Override
    public String accessError()
    {
        return "This mode is always accesible";
    }
    @Override
    public int getEntryFee()
    {
        return 50;
    }
    @Override
    public int getPenalty()
    {
        return 10;
    }
    @Override
    public int getProfit()
    {
        return 10+suser.score/10;
    }
}
