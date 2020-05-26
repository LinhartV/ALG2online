/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhart_alg2_sem_equationtraining.app;

import linhart_alg2_sem_equationtraining.utils.GlobalVars;
import linhart_alg2_sem_equationtraining.utils.EquationInterface;


/**
 * Provides all logic concerning linear equations
 * 
 * An example of equation: 2x + 5 = -4x - 1
 */
public class Linear extends GlobalVars implements EquationInterface
{
    int solution = 0;
    /**
     * Sets the equation and it's solution
     * 
     * Creates the equation depending on user's score. The higher the score, the more difficult the equation is. Difficulty is represented by range of possible values to be generated (e. q. maximum value of generated number for user with score 100 is 5, whereas for score 1000 will be 50).
     * Solution is an integer to make counting a bit easier
     * 
     * @return an equation in String format
     */
    @Override
    public String equation()
    {
        int score = suser.score;
        //Equation always has certain number of 'x' on both sides and a number in addition.
        //First there are generated solution, both coeficients and number on the left side. The secong number is counted afterwards. This is to ensure that the solution and all other numbers are always integers.
        StringBuilder sb = new StringBuilder();
        solution = (int)(Math.random()*score/20-score/40);
        int num1 = (int)(Math.random()*score/10-score/20);
        int coef1 = (int)(Math.random()*score/20-score/40);
        int coef2 = (int)(Math.random()*score/20-score/40);
        if(coef1==coef2)
            coef1++;
        int num2 = (coef1-coef2)*solution+num1;
        sb.append(coef1).append("x ");
        if(num1<0)
        {
            sb.append("- ").append(Math.abs(num1));
        }
        else
            sb.append("+ ").append(num1);
        sb.append(" = ");
        sb.append(coef2).append("x ");
        if(num2<0)
        {
            sb.append("- ").append(Math.abs(num2));
        }
        else
            sb.append("+ ").append(num2);
        return sb.toString();
    }
    @Override
    public String rules()
    {
        return "You will have 60 seconds to complete as many examples as possible.\nFor each equation correctly solved, you'll earn "+ this.getProfit()+" points.\nEach wrong answer will lose you "+ this.getPenalty()+" points.\nTo entre the Linear mode, "+ this.getEntryFee()+" score points will be taken off.\nDo you really want to continue?\ny - yes\nn - no";
    }
    /**
     * Determines whether the user can enter this mode
     * 
     * @return true, if the user's score is at least 100
     */
    @Override
    public boolean isAccessible()
    {
        return suser.score>=100;
    }
    /**
     * An error to be displayed if the user's score is too to cannot enter this mode
     * @return an error message
     */
    @Override
    public String accessError()
    {
        return "Your score is too low to enter this mode.\nGain at least 100 points to play";
    }
    @Override
    public int getEntryFee()
    {
        return 100;
    }

    @Override
    public int getPenalty() {
        return 20;
    }

    @Override
    public int getProfit() 
    {
        return 30+suser.score/20;
    }

    @Override
    public String getSolution() 
    {
        return Integer.toString(solution);
    }
}
