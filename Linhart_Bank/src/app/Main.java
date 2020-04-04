
package app;
import Bank.Account;
import Bank.Client;
import Bank.Company;
import Bank.Person;

public class Main 
{
    public static void main(String[] args) 
    {
        Client[] ar = new Client[3];
        ar[0] = new Person("Pekar");
        ar[1] = new Person("Svecova");
        ar[2] = new Company("Skoda");
        ar[0].AddAccount(1000);
        ar[0].AddAccount(500);
        ar[1].AddAccount(1200);
        ar[2].AddAccount(120);
        for (int i = 0; i < ar.length; i++) 
        {
            System.out.println(ar[i].getName() + " "+ar[i].GetSum());
        }
    }
    
}
