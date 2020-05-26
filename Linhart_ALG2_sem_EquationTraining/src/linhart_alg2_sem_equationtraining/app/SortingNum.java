package linhart_alg2_sem_equationtraining.app;

/**
 * Class used only for sorting examples
 * 
 * It contains the values of numbers in the example and compareTo method which enables them to be easily sorted
 */
public class SortingNum implements Comparable<SortingNum>
{
    public int num;
    public SortingNum(int num) 
    {
        this.num = num;
    }
    /**
     * Sorting by value method
     * 
     * Inherited from Comparable
     * @param t an object to be compared
     * @return value that represents which of the two given numbers is bigger
     */
    @Override
    public int compareTo(SortingNum t) 
    {
        if(num==t.num)  
            return 0;  
        else if(num>t.num)  
            return 1;  
        else  
            return -1;  
    }
}
