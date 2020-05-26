package linhart_alg2_sem_equationtraining.app;

import java.time.LocalDate;


/**
 * A class that stores all data about certain user
 * 
 * Apart from name score and amount of equations solved and failed it contains also the date of last login and boolean collected to determine, wherher the user has right to collect the daily bonus
 */
public class User 
{
    public String name;
    public int score;
    public int equationSolved;
    public int equationFailed;
    public LocalDate lastLogin;
    public boolean collected;
    public User(String name, int score, int equationSolved, int equationFailed, LocalDate lastLogin, boolean collected) 
    {
        this.collected = collected;
        this.lastLogin = lastLogin;
        this.name = name;
        this.score = score;
        this.equationSolved = equationSolved;
        this.equationFailed = equationFailed;
        
    }
    
}
