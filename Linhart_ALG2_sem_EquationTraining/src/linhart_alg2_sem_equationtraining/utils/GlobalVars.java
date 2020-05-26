package linhart_alg2_sem_equationtraining.utils;

import linhart_alg2_sem_equationtraining.app.User;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class most of other classes inherits from
 * 
 * It contains often used variables all classes should have access to
 * It also provides boolean isRunning that handles communication between countdown and main method while solving equations
 */
public class GlobalVars 
{
    public static ArrayList<User> l = new ArrayList<User>(); //list of users
    public static User suser; //selected user
    public static boolean isRunning;
    public static LocalDate theDate;
}
