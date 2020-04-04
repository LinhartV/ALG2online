
package Bank;

import java.util.ArrayList;

public abstract class Client 
{
    public ArrayList<Account> accounts= new ArrayList<Account>();
    public String name;
    public void AddAccount()
    {
        accounts.add(new Account());
    }
    public void AddAccount(int sum)
    {
        accounts.add(new Account(sum));
    }
    public int GetSum()
    {
        int sum =0;
        for (int i = 0; i < accounts.size(); i++) 
        {
            sum+=accounts.get(i).GetBalance();
        }
        return sum;
    }
    public abstract String getName();
}
