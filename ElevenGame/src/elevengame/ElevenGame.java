package elevengame;

import java.util.Scanner;

public class ElevenGame extends GameLogic
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nHey! Press:\nq - quit\ns2 - select two cards\ns3 - select three cards\n");
        newGame();    
        while(isLost())
            newGame();    
        dispBoard();
        String s = sc.next();
        
        while(!"q".equals(s))
        {
            switch(s) 
            {
                case "s2":
                    System.out.println("Select two cards\n0 = ♥, 1 = ♦, 2 = ♣, 3 = ♠\nA, 2-10, J, Q, K\ne.g. 05 3Q");
                    if(!select(sc.next(),sc.next()))
                        System.out.println("And now try for a change to select right cards");
                    break;
                case "s3":
                    System.out.println("Select three cards\n0 = ♥, 1 = ♦, 2 = ♣, 3 = ♠\nA, 2-10, J, Q, K\ne.g. 1J 3Q 2K");
                    if(!select(sc.next(),sc.next(),sc.next()))
                        System.out.println("And now try for a change to select right cards");
                    break;
                default:
                    System.out.println("You jerk, can't you write a proper command?! Try harder");
            }
            dispBoard();
            if(isLost())
            {
                System.out.println("Your a looser... I knew it from the beginning.\nWanna try again? Why should I ask you...\nHere is new deal!");
                newGame();
                while(isLost())
                    newGame();
                dispBoard();
            }
            for (int i = 0; i < board.length; i++) 
            {
                if(board[i]!=null)
                    break;
                else if (i == board.length-1)
                {
                System.out.println("Impossible... you won?\nIt was just a sheer luck, here is a new deal to prove,\nyou're nothing but a looser.");
                newGame();
                while(isLost())
                    newGame();
                dispBoard();
                }
            }
            
            s = sc.next();
            
        }
        System.out.println("See u next time!");
        
    }
    public static void dispBoard()
    {
        for (int i = 0; i < 9; i++) 
        {
            if(i%3==0)
                System.out.println("");
            if(board[i]!=null)
                System.out.print(board[i].name+" ");
            else
                System.out.print("   ");
        }
        System.out.println("");
    }
    public static void dispDeck()
    {
        for (int i = 0; i < l.size(); i++) 
        {
            System.out.println(l.get(i).name);
        }
    }
}