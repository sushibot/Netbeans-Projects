/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author Gabriel Fontanilla
 * CSCI 2913
 * 9/17/16
 */
import java.util.Random;

public class Homework2 {
    public static void main(String[] args) {  
        //Runs standard test case of real number input 
        System.out.println("Standard Case");
       Statistician s = new Statistician();
       s.nextNumber (1.1);
       s.nextNumber(-2.4);
       s.nextNumber(0.8);   
       System.out.println("The maximum number of the current sequence is: "+ s.getLarge());
       System.out.println("The minimum number of the current sequence is: "+s.getSmall());
       System.out.println("The mean of the current sequence is: "+ s.getMean());
       System.out.println("The sum of the current sequence is: " + s.getSum());
       System.out.println("The length of the current sequence is: " +s.getLength());
       System.out.println("The last number of the current sequence is: "+s.getLast());
        System.out.println("\n");
        //Runs test case of randomized number input
        System.out.println("Random Case");
       Random bag = new Random();
       Double inputOne =bag.nextDouble();
       Double inputTwo =bag.nextDouble();
       Double inputThree =bag.nextDouble();
       Statistician r = new Statistician();
       r.nextNumber(inputOne);
       r.nextNumber(inputTwo);
       r.nextNumber(inputThree);
       System.out.println("The maximum number of the random sequence is: "+r.getLarge());
       System.out.println("The minimum number of the random sequeqnce is: "+r.getSmall());
       System.out.println("The mean of the random sequence is: "+r.getMean());
       System.out.println("The sum of the random sequence is "+r.getSum());
       System.out.println("The length of the random sequence is: "+r.getLength());
       System.out.println("The last number of the random sequence is "+r.getLast());
        System.out.println("\n");
        //Runs test case of an empty input
        System.out.println("Empty Case");
       Double nonNum1 =0.0;
       Double nonNum2=0.0;
       Double nonNum3=0.0;
       Statistician none = new Statistician();
       System.out.println("The maximum number of the 0 sequence is: "+none.getLarge());
       System.out.println("The minimum number of the 0 sequence is: "+none.getSmall());
       System.out.println("The mean of the 0 sequence is: "+none.getMean());
       System.out.println("The sum of the 0 sequence is: "+none.getSum());
       System.out.println("The length of the 0 sequence is: "+none.getLength());
       System.out.println("The last number of the 0 sequence is: "+none.getLast());
        System.out.println("\n");
        //Runs test case of a single number input
        System.out.println("Boundary Case");
      Statistician boundary = new Statistician();
       boundary.nextNumber (69.96);   
       System.out.println("The maxmimum number of the boundary case is: "+boundary.getLarge());
       System.out.println("The minimum number of the boundary case is: "+boundary.getSmall());
       System.out.println("The mean number of the boundary case is: "+boundary.getMean());
       System.out.println("The sum of the boundary case is: "+boundary.getSum());
       System.out.println("The length of the boundary case is: "+boundary.getLength());
       System.out.println("The last number of the boundary case is: "+boundary.getLast());
    }
}





