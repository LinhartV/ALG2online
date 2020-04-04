package Bank;



public class Company extends Client
{
    public Company (String name)
    {
        this.name=name;
    }
    @Override
    public String getName()
    {
        return "firma "+name;
    }
}
