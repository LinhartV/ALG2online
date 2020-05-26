package linhart_alg2_sem_equationtraining.app;
import linhart_alg2_sem_equationtraining.utils.GlobalVars;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Scanner;
import static linhart_alg2_sem_equationtraining.utils.GlobalVars.theDate;

/**
 * FileHnadler provides access to UserList.txt file, where all user data are stored
 * 
 * Apart from that, it communicate with main method and provides logic function concerning users
 * 
 */
public class FileHandler extends GlobalVars
{
    /**
     * Reads data from the file and sets the list of users
     * @throws java.io.FileNotFoundException
     */
    public static void createFileAndGetList() throws FileNotFoundException, IOException
    {
        try
        {
            File file = new File(".\\data\\UserList.txt");
            file.createNewFile();
            file.setReadOnly();
            //myObj.setWritable(true);
            String[] datas;
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) 
            {
              datas = myReader.nextLine().split(" ");
              l.add(new User(datas[0], Integer.parseInt(datas[1]), Integer.parseInt(datas[2]), Integer.parseInt(datas[3]),LocalDate.parse(datas[4]),Boolean.parseBoolean(datas[5])));
            }
            myReader.close();
        }
        catch(IOException | NumberFormatException | DateTimeParseException e)
        {
            File file = new File(".\\data\\UserList.txt");
            file.setWritable(true);
            FileWriter myWriter = new FileWriter(file);
        }
        
    }
    /**
     * Pretty much what the heading says
     */
    public static void getCurrentDay()
    {
        LocalDateTime timePoint = LocalDateTime.now();
        theDate = timePoint.toLocalDate();
    }
    /**
     * Get all names of users
     * 
     * @return the names of users from the list of users
     */
    public static String getUserNames()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l.size(); i++) 
        {
            sb.append(l.get(i).name+"\n");
        }
        if(sb.length()>0)
            return sb.toString();
        else
            return "No users found. Create a new user.";
    }
    /**
     * Method that provides formatted or unformatted list of all users along with their additional data (E.g. score etc.)
     * 
     * @param formatted determines, whether the output should be formatted. To display list on the console it always uses formatted output, to save data to the file it always uses unformatted style.
     * @param Com tells the program which way to sort formatted output (by name, score or number of played games)
     * @return list of users
     */
    public static String displayUsers(boolean formatted,Comparator Com)
    {
        if(Com!=null)
        {
            Collections.sort(l,Com);
        }
        StringBuilder sb = new StringBuilder();
        if(formatted)
            sb.append("Name           Score Solved Failed\n----------------------------------\n");
        for (int i = 0; i < l.size(); i++) 
        {
            if(formatted)
            {
                
                if(i!=l.size()-1)
                    sb.append(String.format("%1$-" + 15 + "s", l.get(i).name)+String.format("%1$-" + 6 + "s", Integer.toString(l.get(i).score))+String.format("%1$-" + 6 + "s", Integer.toString(l.get(i).equationSolved))+String.format("%1$-" + 6 + "s", Integer.toString(l.get(i).equationFailed))+"\n");
                else
                    sb.append(String.format("%1$-" + 15 + "s", l.get(i).name)+String.format("%1$-" + 6 + "s", Integer.toString(l.get(i).score))+String.format("%1$-" + 6 + "s", Integer.toString(l.get(i).equationSolved))+String.format("%1$-" + 6 + "s", Integer.toString(l.get(i).equationFailed)));
            }
            else
            {
                if(i!=l.size()-1)
                    sb.append(l.get(i).name+" "+l.get(i).score+" "+l.get(i).equationSolved+" "+l.get(i).equationFailed+" "+l.get(i).lastLogin+" "+Boolean.toString(l.get(i).collected)+"\n");
                else
                    sb.append(l.get(i).name+" "+l.get(i).score+" "+l.get(i).equationSolved+" "+l.get(i).equationFailed+" "+l.get(i).lastLogin+" "+Boolean.toString(l.get(i).collected));
            }
            
        }
        if(sb.length()>0||formatted)
            return sb.toString();
        else
            return "No users found";
    }
    /**
     * Creates new user
     * 
     * The user will not be created if the name already exists or exceeds 14 characters
     * 
     * @param name Name of the user to add
     * @return whether the user could be created
     */
    public static boolean addUser(String name)
    {
        if(name.length()>14)
            return false;
        for (int i = 0; i < l.size(); i++) 
        {
            if(l.get(i).name.equals(name))
                return false;
        }
        l.add(new User(name,0,0,0,theDate,false));
        return true;
    }
    /**
     * Removes desired user
     * 
     * The user will not be removed if the input regex doesn't match any user or matches more than one user name
     * 
     * @param name input regex which the user to be removed is found by
     * @return information, whether the user was removed and if not, then why
     */
    public static String removeUser(String name)
    {
        int br = 0;
        //first cycle which determines if there is just one user name that matches the input regex
        for (int i = 0; i < l.size(); i++) 
        {
            if(l.get(i).name.matches(name+"(.*)"))
            {
                if(l.get(i).name.equals(name))
                {
                    if(l.get(i)==suser)
                    suser = null;
                    String s = "User "+l.get(i).name+" succesfully removed";
                    l.remove(i);
                    return s;
                }
                br++;
            }
        }
        if(br>1)
            return "There are multiple users starting with "+name;
        //if there is just one matching name, this cycle will find it
        for (int i = 0; i < l.size(); i++) 
        {
            if(l.get(i).name.matches(name+"(.*)"))
            {
                if(l.get(i)==suser)
                    suser = null;
                String s = "User "+l.get(i).name.toString()+" succesfully removed";
                l.remove(i);
                return s;
            }
        }
        return "No such user found";
    }
    /**
     * Selects desired user
     * 
     * The user will not be selected if the input regex doesn't match any user or matches more than one user name
     * 
     * @param name input regex which the user to be selected is found by
     * @return true, if the user was succesfully selected
     */
    public static boolean selectUser(String name)
    {
        int br = 0;
        for (int i = 0; i < l.size(); i++) 
        {
            if(l.get(i).name.matches(name+"(.*)"))
            {
                if(l.get(i).name.equals(name))
                {
                    suser = l.get(i);
                    if(theDate.getDayOfYear()!=suser.lastLogin.getDayOfYear()&&theDate.getYear()!=suser.lastLogin.getDayOfYear())
                        suser.collected = false;
                    suser.lastLogin = theDate;
                    return true;
                }
                br++;
            }
        }
        if(br>1)
            return false;
        for (int i = 0; i < l.size(); i++) 
        {
            if(l.get(i).name.matches(name+"(.*)"))
            {
                suser = l.get(i);
                if(theDate.getDayOfYear()!=suser.lastLogin.getDayOfYear()&&theDate.getYear()!=suser.lastLogin.getDayOfYear())
                    suser.collected = false;
                suser.lastLogin = theDate;
                return true;
            }
        }
        return false;
    }
    /**
     * Safely closes the program
     * 
     * All user data will be written to the file and the file will be set to read only
     */
    public static void close()
    {
        try 
        {
            File file = new File(".\\data\\UserList.txt");
            file.setWritable(true);
            FileWriter myWriter = new FileWriter(file);
            if(!l.isEmpty())
                myWriter.write(displayUsers(false, null));
            myWriter.close();
            file.setReadOnly();
        } 
        catch (IOException e) 
        {
            
        }
    }
}
