package excercise;


import java.util.Scanner;
public class Excercise {

    public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What is the radius of this circle?");
    double x = keyboard.nextDouble();
    double pi = 3.1415926;
    if (x>0) {
        System.out.println("The radius is " +x);
    } else {
        System.out.println("error");
    }
    
    
        
        
        
      
    }
}
