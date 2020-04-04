
package Bank;

public class Account 
{
    private int sum;
    public Account()
    {
        sum = 0;
    }
    public Account(int sum)
    {
        this.sum = sum;
    }
    public void AddMoney (int money)
    {
        sum+=money;
    }
    public void TakeMoney (int money)
    {
        sum-=money;
    }
    public int GetBalance()
    {
        return sum;
    }
}
