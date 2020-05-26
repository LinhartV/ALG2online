package linhart_alg2_sem_equationtraining.utils;

import linhart_alg2_sem_equationtraining.app.User;
import java.util.Comparator;

/**
 * Sorting by score
 */
public class ComparatorScore implements Comparator<User>
{
    @Override
    public int compare(User u1, User u2) 
    {
        return u2.score-u1.score;
    }
    
}
