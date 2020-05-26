package linhart_alg2_sem_equationtraining.app;

import linhart_alg2_sem_equationtraining.utils.EquationInterface;
import java.util.ArrayList;
import java.util.Collections;
import linhart_alg2_sem_equationtraining.utils.GlobalVars;

/**
 * Provides all logic concerning sorting examples
 * 
 * User will be displayed numbers in random order and the goal is to sort those numbers in ascending order
 * An example of challenge: 3 8 -5 2 and the right answer would be -5 2 3 8
 */
public class Sorting extends GlobalVars implements EquationInterface
{
    StringBuilder solution = new StringBuilder();
    /**
     * Sets the sorting example and it's solutions
     * 
     * Creates the example depending on user's score. The higher the score, the more difficult the example is. Difficulty is represented by amount of numbers and by range of possible values to be generated (e. q. maximum value of generated number for user with score 200 is 100, whereas for score 1000 will be 500).
     * 
     * @return an example in String format
     */
    @Override
    public String equation() 
    {
        solution = new StringBuilder();
        int score = suser.score;
        StringBuilder sb = new StringBuilder();
        int varCount = 3+suser.score/100;//amount of numbers to be generated (minimum is 3)
        ArrayList<SortingNum> ar = new ArrayList<>();
        //First, the numbers are generated and stored in the order they are displeyed
        for (int i = 0; i < varCount; i++) 
        {
            ar.add(new SortingNum((int)(Math.random()*score-score/2)));
            if(i!=varCount-1)
                sb.append(ar.get(i).num).append(" ");
            else
                sb.append(ar.get(i).num);
        }
        //Second, the solution is created from the sorted values by Comparable interface
        Collections.sort(ar);
        for (int i = 0; i < ar.size(); i++) 
        {
            if(i!=ar.size()-1)
                solution.append(ar.get(i).num).append("_");
            else
                solution.append(ar.get(i).num);
        }
        
        return sb.toString();
    }

    @Override
    public String rules() 
    {
        return "You will have 60 seconds to complete as many examples as possible.\nTo complete an example, you have to write in ascending sequence of numbers separated by _ \nE. g. 1_2_4_10.\nFor each example correctly solved, you'll earn "+ this.getProfit()+" points.\nEach wrong answer will lose you "+ this.getPenalty()+" points.\nTo entre the Sorting mode, "+ this.getEntryFee()+" score points will be taken off.\nDo you really want to continue?\ny - yes\nn - no";
    }
    /**
     * Determines whether the user can enter this mode
     * 
     * @return true, if the user's score is at least 50
     */
    @Override
    public boolean isAccessible() 
    {
        return suser.score>=50;
    }
    /**
     * An error to be displayed if the user's score is too low to enter this mode
     * @return an error message
     */
    @Override
    public String accessError() 
    {
        return "Your score is too low to enter this mode.\nGain at least 50 points to play";
    }

    @Override
    public int getEntryFee() {
        return 15;
    }

    @Override
    public int getPenalty() {
        return 15;
    }

    @Override
    public int getProfit() {
        return 10+suser.score/30;
    }

    @Override
    public String getSolution() {
        return solution.toString();
    }
}
