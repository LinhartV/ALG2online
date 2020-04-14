
package linhart_calendar;

public class Calendar 
{
    private int day;
    private int month;
    private int year;
    private int numOfDays;
    public Calendar (int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        if(month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12)
            numOfDays = 31;
        if(month == 4||month == 6||month == 9||month == 11)
            numOfDays = 30;
        if(month == 2)
        {
            if((year%4==0&&year%100!=0)||year%400==0)
                numOfDays = 29;
            else
                numOfDays = 28;
        }
    }
    public static int actualDay(int day, int month, int year)
    {
        int q=day;
        int m=month;
        int K =year%100;
        int J = year/100;
        return ((((q+(13*(m+1)/5)+K+K/4+J/4-2*J)%7)+5)%7)+1;
    }
    public String formattedCalendar()
    {
        String s = "";
        
        int num = 1;
        int first = actualDay(1, month, year);
        for (int i = 0; i < 7; i++) 
        {
            for (int j = 0; j < 7; j++) 
            {
                if(i==0)
                {
                    if (j==0)
                        s+="Po ";
                    if (j==1)
                        s+="Út ";
                    if (j==2)
                        s+="St ";
                    if (j==3)
                        s+="Čt ";
                    if (j==4)
                        s+="Pá ";
                    if (j==5)
                        s+="So ";
                    if (j==6)
                        s+="Ne ";
                    continue;
                }
                if(j<first-1&&i==1)
                {
                    s+="   ";
                }
                else
                {
                    if(num<10)
                        s+= Integer.toString(num)+"  ";
                    else
                        s+= Integer.toString(num)+" ";
                    num++;
                }
                if(num > numOfDays)
                    num=1;
            }
            s+="\n";
        }
        return s;
    }
    public String next()
    {
        month++;
        if(month == 13)
            month =1;
        return formattedCalendar();
    }
    public String prev()
    {
        month--;
        if(month == 0)
            month =12;
        return formattedCalendar();
    }
    public static Boolean isLeap(int year)
    {
        if((year%4==0&&year%100!=0)||year%400==0)
                return true;
            else
                return false;
    }
    public static int numberOfDaysInYear(int year)
    {
        if(isLeap(year))
            return 366;
        else
            return 365;
    }
}
