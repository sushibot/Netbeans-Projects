/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package homework7heaps;

/**
 *
 * @author Owner
 */

import java.util.Scanner;
public class Homework7Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      PriorityQueue p = new PriorityQueue();

        
        p.add(69, 0);
        p.add(26,1);
        p.add(9, 2);  
        p.add(32, 3);
        p.add(10, 4);
        p.add(3, 4);
        p.add(2, 5);
        p.add(5,6);
        p.add(7, 8);
        p.add(89,9);
        System.out.println("__Standard Case__");
        System.out.println("[Priority]"+" "+"[Data]");
        for (int i = 0,j=0; i < p.priority.length&&j<p.data.length; i++,j++)
        {
            System.out.println(""+" | "+p.priority[i]+" | "+" -> "+" | "+p.data[j]+" | ");
        }
        System.out.println("\n");
        System.out.println("__Empty Case__");
        PriorityQueue p1= new PriorityQueue();
        p1.add(1, 1);
        System.out.println(p1.remove(1));
        System.out.println("\n");
        
        System.out.println("__Removing Same Case__");
        PriorityQueue p2 = new PriorityQueue();
        p2.add(1, 1);
        p2.add(1, 2);
        p2.add(3, 2);
        p2.add(5, 2);
        System.out.println(p2.remove(1));
        
       
    }
}
