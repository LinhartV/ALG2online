package linhart_alg2_sem_equationtraining.utils;
import linhart_alg2_sem_equationtraining.app.User;
import java.util.Comparator;

/**
 * Sorting by number of equations faced
 */
public class ComparatorGame implements Comparator<User>
{
    @Override
    public int compare(User u1, User u2) 
    {
        return (u2.equationFailed+u2.equationSolved ) - (u1.equationFailed+u1.equationSolved);
    }
    
}
