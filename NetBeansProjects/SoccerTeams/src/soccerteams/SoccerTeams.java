package soccerteams;

import javax.swing.JOptionPane;

public class SoccerTeams {

    public static void main(String[] args) {
       /* final int MIN_PLAYERS = 9;      //Minimum players per team
        final int MAX_PLAYERS = 15;     //Max players
        int players;                    //number of players avail.
        int teamsize;                   //players per team
        int teams;                      //number of teams
        int leftOver;                   //number of leftover players
        String input;

        input = JOptionPane.showInputDialog("Enter the number of "
                + "players per team.");

        teamsize = Integer.parseInt(input);

        players = Integer.parseInt(input);
        
        while (players < 0) {
            input = JOptionPane.showInputDialog("Enter 0 or "
                    + "greater.");
            players = Integer.parseInt(input);

        }
        teams = players / teamsize;
        
        
        leftOver = players % teamsize;
        JOptionPane.showMessageDialog(null, "There will be "
                + teams + " teams with "
                + leftOver + " players left over.");*/
    
            int n = 
        
               
    }
    int GCD (int m, int n)
    {
        if((m%n)==0)
            return n;
        else
            return GCD (n, m%n);
    }
}
