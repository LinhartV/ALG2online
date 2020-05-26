package linhart_alg2_sem_equationtraining.utils;

/**
 * Class that uses mutlithreading to provide time handling while solving an equation
 * 
 */
public class CountDown extends GlobalVars implements Runnable
{
    /**
     * Counts 60 seconds which the equation solving ends after
     */
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(50000);
            System.out.println("----Hurry up, last 10 seconds----");
            Thread.sleep(10000);
            isRunning=false;
            System.out.println("-----------Time is up!-----------"
                            +"\n----Press any key to continue----");
        }
        catch(InterruptedException e)
        {
            System.out.println("An error has occured");
        }
    }
    /**
     * Starts the coundown
     */
    public void start()
    {
        Thread t;
        t = new Thread(this,"l");
        t.start();
    }
}
