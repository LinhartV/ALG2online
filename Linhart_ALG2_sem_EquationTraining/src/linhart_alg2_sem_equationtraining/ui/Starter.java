
package linhart_alg2_sem_equationtraining.ui;
import java.io.IOException;
import java.util.Scanner;
import linhart_alg2_sem_equationtraining.app.Basic;
import linhart_alg2_sem_equationtraining.utils.ComparatorGame;
import linhart_alg2_sem_equationtraining.utils.ComparatorName;
import linhart_alg2_sem_equationtraining.utils.ComparatorScore;
import linhart_alg2_sem_equationtraining.utils.CountDown;
import linhart_alg2_sem_equationtraining.utils.EquationInterface;
import linhart_alg2_sem_equationtraining.app.FileHandler;
import linhart_alg2_sem_equationtraining.utils.GlobalVars;
import linhart_alg2_sem_equationtraining.app.Linear;
import linhart_alg2_sem_equationtraining.app.Quadratic;
import linhart_alg2_sem_equationtraining.app.Sorting;
/**
 *
 * @author Vojtěch Linhart
 */
public class Starter extends GlobalVars 
{
    /**
     * EquationTraining is a software that you can learn and train math by.
     * 
     * It provides multiple excercise, from basic examples like 2+3 to quadratic equations.
     * Each user collects score points wich enable entrance to higher levels and to show who is the best
     * 
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        FileHandler.createFileAndGetList();
        FileHandler.getCurrentDay();
        System.out.println(theDate);
        Scanner sc = new Scanner(System.in);
        EquationInterface Eq = null;
        System.out.println("Welcome to EquationTraining!\nFirst of all, select your user name from the list bellow,\nor create a new user.\n");
        System.out.println(FileHandler.getUserNames());
        System.out.println("s - select a user\na - add new user\nr - remove a user\nd - display user list\n-> ds - sort by score\n-> dn - sort by name\n-> dp - sort by number of played game\np - start playing\nx - exit the game\n");
        String s = sc.next();
        
        while(!"x".equals(s))
        {
            switch(s) 
            {
                //cheat
                case "c":
                    System.out.println("If your brain won't gain you score, there are some other ways...!");
                    if(suser==null)
                        System.out.println("Okey, if your moral levels and math abilities are so low to use cheats, at least use them correctly and select a user first.");
                    else
                    {
                        suser.score+=100;
                        System.out.println("At least other will think you are clever. \n*Abracadabra*\nYour score is as if by magic 100 point higher then before... ");
                    }
                    break;
                //selecting a user
                case "s":
                    if(l.size()>0)
                    {
                        if(l.size()>1)
                        {
                            System.out.println("Write in the user name\n"+FileHandler.getUserNames());
                            if(!FileHandler.selectUser(sc.next()))
                            {
                                do
                                {                            
                                    System.out.println("No such user found, select another name");
                                }while(!FileHandler.selectUser(sc.next()));
                            }
                        }
                        else
                        {
                            FileHandler.selectUser(l.get(0).name);
                        }
                        System.out.println(suser.name+" selected");
                        if(!suser.collected)
                        {
                            System.out.println("Receive daily bonus?\ny - yes\nn - no");
                            if("y".equals(sc.next()))
                            {
                                suser.collected=true;
                                if(Math.random()>0.75)
                                {
                                    suser.score+=40;
                                    System.out.println("Lucker! You've gained 40 score :O");
                                }
                                else
                                {
                                    suser.score+=20;
                                    System.out.println("You've earned 20 score");
                                }
                            }
                            else
                                System.out.println("You haven't collected your daily bonus");
                        }
                    }
                    else
                        System.out.println("No user exists. First, create a new one");
                    break;
                //Adding new user
                case "a":
                    System.out.println("Write in your name");
                    if(!FileHandler.addUser(sc.next()))
                    {
                        do
                        {                            
                            System.out.println("This name is already used or is too long, choose another one");
                        }while(!FileHandler.addUser(sc.next()));
                    }
                    System.out.println("User succesfully added");
                    break;
                //Displaying users sorted by random, score, name or number of equation faced.
                case "d":
                    System.out.println(FileHandler.displayUsers(true,null));
                    break;
                case "ds":
                    System.out.println(FileHandler.displayUsers(true,new ComparatorScore()));
                    break;
                case "dn":
                    System.out.println(FileHandler.displayUsers(true,new ComparatorName()));
                    break;
                case "dp":
                    System.out.println(FileHandler.displayUsers(true,new ComparatorGame()));
                    break;
                //Removing a user
                case "r":
                    System.out.println("Write in the name of the user you want to delete");
                    System.out.println(FileHandler.removeUser(sc.next()));
                    break;
                //The equations menu
                case "p":
                    if(suser!=null)
                    {
                        System.out.println("Welcome "+ suser.name + ". Choose what to play:\nb - basic examples\nl - linear equations\nq - quadratic equation\ns - sorting\nx - return to main menu");
                        s = sc.next();

                        while(!"x".equals(s))
                        {
                            switch(s)
                            {
                                case "b":
                                    Eq = new Basic();
                                    break;
                                case "l":
                                    Eq = new Linear();
                                    break;
                                case "q":
                                    Eq = new Quadratic();
                                    break;
                                case "s":
                                    Eq = new Sorting();
                                    break;
                                default: 
                                    System.out.println("You selected unknown command. Try again");
                                    break;
                            }
                            
                            if(Eq!=null)
                            {
                                if(!Eq.isAccessible())
                                {
                                    System.out.println(Eq.accessError());
                                    Eq = null;
                                    System.out.println("Choose game mode");
                                    s = sc.next();
                                    continue;
                                }
                                System.out.println(Eq.rules());
                                s = sc.next();
                                
                                if("y".equals(s))
                                {
                                    startEquation(Eq);
                                }
                                else if(!"n".equals(s))
                                {
                                    System.out.println("I take is as 'no'");
                                }
                            }
                            Eq = null;
                            System.out.println("Choose game mode");
                            s = sc.next();
                        }
                        System.out.println("Main menu:");
                        System.out.println("s - select a user\na - add new user\nr - remove a user\nd - display user list\n-> ds - sort by score\n-> dn - sort by name\n-> dp - sort by number of played game\np - start playing\nx - exit the game\n");
        
                        }
                    else
                    {
                        System.out.println("You haven't selected any user yet");
                    }
                        break;
                default:
                    System.out.println("Not a command");
            }
            System.out.println("");
            s = sc.next();
        }
        FileHandler.close();
        System.out.println("See you next time!");
    }
    /**
     * A method that outputs equations itselves
     * 
     * It contains the start countdown and checkes the correstness of user's input solution
     * @param Eq 
     */
    private static void startEquation(EquationInterface Eq)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("\nGET READY\n");
            Thread.sleep(1000);
            System.out.println(" ---3--- ");
            Thread.sleep(1000);
            System.out.println(" ---2--- ");
            Thread.sleep(1000);
            System.out.println(" ---1--- ");
            Thread.sleep(1000);
            System.out.println(" --GO!-- ");
            Thread.sleep(1000);
            String s;
            String s2 = "";
            int solved = 0;
            int failed = 0;
            CountDown cd = new CountDown();
            cd.start();
            isRunning = true;
            while(isRunning)
            {
                System.out.println(Eq.equation());
                s = sc.next();
                if(!Eq.getClass().getName().endsWith("Quadratic"))
                {
                    if(isRunning)
                    {
                        if(s.equals(Eq.getSolution()))
                        {
                            System.out.println("It's correct");
                            solved++;
                            suser.equationSolved++;
                        }
                        else
                        {
                            System.out.println("It's wrong, right answer was "+Eq.getSolution());
                            failed++;
                            suser.equationFailed++;
                        }
                    }
                }
                else
                {
                    if(isRunning)
                        s2 = sc.next();
                    if(isRunning)
                    {
                        
                        if(Eq.getSolution().equals(s+" "+s2)||Eq.getSolution().equals(s2+" "+s))
                        {
                            System.out.println("It's correct");
                            solved++;
                            suser.equationSolved++;
                        }
                        else
                        {
                            System.out.println("It's wrong, right answer was " + Eq.getSolution());
                            failed++;
                            suser.equationFailed++;
                        }
                    }
                }
                
            }
            System.out.println("Statistics: \nEquations solved: "+ solved+"\nEquation failed: "+ failed+"\nScore gained: "+(solved*Eq.getProfit()-failed*Eq.getPenalty()-Eq.getEntryFee())+"\nActual score: "+(suser.score+(solved*Eq.getProfit()-failed*Eq.getPenalty()-Eq.getEntryFee()))+"\n");
            suser.score += (solved*Eq.getProfit()-failed*Eq.getPenalty()-Eq.getEntryFee());
        }
        catch(InterruptedException e)
        {
            System.out.println("Error has occured");
        }
    }
}
