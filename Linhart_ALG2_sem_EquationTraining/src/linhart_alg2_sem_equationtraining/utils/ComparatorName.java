package linhart_alg2_sem_equationtraining.utils;

import linhart_alg2_sem_equationtraining.app.User;
import java.util.Comparator;

/**
 * Sorting by name
 */
public class ComparatorName implements Comparator<User>
{
    @Override
    public int compare(User u1, User u2) 
    {
        return u1.name.compareTo(u2.name);
    }
    
}
