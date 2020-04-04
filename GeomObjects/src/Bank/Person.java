package Bank;



public class Person extends  Client
{
    public Person (String name)
    {
        this.name=name;
    }
    @Override
    public String getName()
    {
        if(name.endsWith("ova"))
            return "paní "+name;
        else
            return "pan "+name;
    }
}
