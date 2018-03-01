
package nestedloopsnumber13;



public class NestedLoopsNumber13 {

   
    
    
    public static void main(String[] args) {
        System.out.println("Welcome. This program will print a certain pattern of stars.");
        final int baseSize = 8;
        //int add =1;
      for (int add = 1; add<baseSize; add++)
        {
            for (int star = 1; star <(add + 1); star++)
            {
                
                System.out.print("*");
            }
            System.out.println();
       }
    }
}
