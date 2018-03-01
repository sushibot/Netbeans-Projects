/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbertable;

/**
 *
 * @author Owner
 */
public class PrimeNumberTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome! This program will print out prime numbers."); //welcomes the user
            
        for (int divideBy = 2; divideBy<=1000; divideBy++)//outerloop, will run the number from 2 to 
                                                               //less than or equal to a given value
        {
            for (int number = 2; number<= divideBy; number++) //inner loop, will determine if the number is prime or not
            {
                if (number == divideBy) //this will give the prime number to print out
                                            
                {
                    System.out.println("The number " +number+ " is prime."); 
                }
                if (divideBy % number == 0) //if the remainder of the number is 0, then it will break out of the loop
                                               
                {
                    break; 
                }
            }
        }
        
    }
}
