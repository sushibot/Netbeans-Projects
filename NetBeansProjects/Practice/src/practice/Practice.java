/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

/**
 *
 * @author Owner
 */
import java.util.Scanner;
public class Practice {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("Hello World!");
        System.out.println("----------");
        int wordUp=0;
        for(int count = 0; count<5; count++)
        {
            wordUp++;
            System.out.println("Hello World!"+"["+wordUp+"]");
        }
        System.out.println("----------");
        System.out.println("Please enter a number greater than 0: ");
       int n = user.nextInt();
       int twentyOne = 21;
       while(!(n>0))
       {
           System.out.println("Please re-enter a number greater than 0.");
           n = user.nextInt();
      if(n>0){
       if(n<twentyOne)
       {
           int diff = Math.abs(twentyOne-n);
           System.out.println("The absolute difference of "+twentyOne+" - "+n+" is: "+diff);
       }
       else if(n>twentyOne){
           int doub21 = Math.abs(twentyOne*twentyOne);
           int doubN = Math.abs(n*n);
           int doubFin = Math.abs(doubN-doub21);
           System.out.println("The absolute doubled difference of "+doubN+" - "+doub21+" is: "+doubFin);
           
       }
       else if(n == 69) {
           System.out.println("ayyyyyyeeee lmao");}
       } else if(!(n>0)){
           System.out.println("Please enter a number greater than 0.");
           n = user.nextInt();
       }
       } 
    
    
        
        
   
        
    }
}

    

