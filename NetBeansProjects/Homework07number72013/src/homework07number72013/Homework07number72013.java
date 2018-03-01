
package homework07number72013;


import java.util.Scanner;

public class Homework07number72013 {

 
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        
        //This program will print 2 string in alphabetical order
        
        System.out.println("Please enter 2 words " +
                "and we will print them in alphabetical order.");
        
        String A = user.next();
        String B = user.next();
       
        if (A.compareTo(B)<0){
            System.out.println(A + " comes before " +B);
            
        }else{
            System.out.println(A + " comes after " + B);
       // }   else if (A.compareTo(B)<0) {
            // System.out.println(B + " comes after " + A);  
            
        }
    }
}
        

        
        
    
    

