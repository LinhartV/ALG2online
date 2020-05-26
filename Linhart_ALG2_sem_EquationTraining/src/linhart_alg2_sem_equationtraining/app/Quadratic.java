/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhart_alg2_sem_equationtraining.app;

import linhart_alg2_sem_equationtraining.utils.GlobalVars;
import linhart_alg2_sem_equationtraining.utils.EquationInterface;

/**
 * Provides all logic concerning quadratic equations
 * 
 * An example of equation: x² + 10x + 25 = 0
 */
public class Quadratic extends GlobalVars implements EquationInterface
{
    int solution;
    int solution2;
    /**
     * Sets the equation and it's solutions
     * 
     * Creates the equation depending on user's score. The higher the score, the more difficult the equation is. Difficulty is represented by range of possible values to be generated (e. q. maximum value of generated number for user with score 180 is 3, whereas for score 1800 will be 30).
     * Both roots are integers to make counting a bit easier
     * 
     * @return an equation in String format
     */
    @Override
    public String equation() 
    {
        StringBuilder sb = new StringBuilder();
        //Both roots are generated, all other values are counted afterwards.
        solution = (int)(Math.random()*suser.score/30-suser.score/60);
        solution2 = (int)(Math.random()*suser.score/30-suser.score/60);
        //Drasticly eliminating chance for absolute member to be 0
        if((solution == 0||solution2 == 0 )&&Math.random()<0.8)
        {
            solution++;
            solution2++;
        }
        //Quadratic coeficient is allways 1
        sb.append("x² ");
        /*Linear and absolute coeficients are counted as follow: 
        (x - x0)*(x - x1) = 0
        root 1 = x0 + x1
        root 2 = x0 * x1
        */
        if((-solution-solution2)>=0)
            sb.append("+ ").append(-solution-solution2).append("x ");
        else
            sb.append("- ").append(solution2+solution).append("x ");
        if(solution*solution2>=0)
            sb.append("+ ").append(solution*solution2);
        else
            sb.append("- ").append(Math.abs(solution*solution2));
        sb.append(" = 0");
        return sb.toString();        
    }

    @Override
    public String rules() 
    {
        return "You will have 60 seconds to complete as many examples as possible.\nTo complete an equation, you have to write in both roots.\nFor each equation correctly solved, you'll earn "+ this.getProfit()+" points.\nEach wrong answer will lose you "+ this.getPenalty()+" points.\nTo entre the Quadratic mode, "+ this.getEntryFee()+" score points will be taken off.\nDo you really want to continue?\ny - yes\nn - no";
    }
    /**
     * Determines whether the user can enter this mode
     * 
     * @return true, if the user's score is at least 300
     */
    @Override
    public boolean isAccessible() 
    {
        return suser.score>=300;
    }
    /**
     * An error to be displayed if the user's score is too low to enter this mode
     * @return an error message
     */
    @Override
    public String accessError()
    {
        return "Your score is too low to enter this mode.\nGain at least 300 points to play";
    }

    @Override
    public int getEntryFee()
    {
        return 200;
    }

    @Override
    public int getPenalty() {
        return 30;
    }

    @Override
    public int getProfit() 
    {
        return 80+suser.score/20;
    }

    @Override
    public String getSolution() 
    {
        return Integer.toString(solution)+" "+Integer.toString(solution2);
    }
}
