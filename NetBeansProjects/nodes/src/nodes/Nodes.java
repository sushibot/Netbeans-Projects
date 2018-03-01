/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.util.*;

public class Nodes
{


    public static void main(String[] args) 
    {
     
     int trapNetwork[][]={{0,1,1,0,0,0},
                          {1,0,0,1,0,0},
                          {1,0,0,1,1,0},
                          {0,1,1,0,0,1},
                          {0,0,1,0,0,1},
                          {0,0,0,1,1,0}};
 
     for(int rows = 0; rows < 6; rows++)
     {
         System.out.println();
         for(int columns = 0; columns <6; columns++)
         {
             System.out.print(trapNetwork[rows][columns]);
         }
        
     }
     
     
     
        
        
        
    }
}
