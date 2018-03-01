/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandbooleans;

/**
 *
 * @author Gabriel Fontanilla
 */
import java.util.Scanner;
import java.util.Stack;
public class StacksAndBooleans {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("[Standard Expression]");
        String [] exp = new String[16];
             exp[0] = "(6>9)"; //false
             exp[1] = "(6>=9)"; //false
             exp[2] = "(6==9)"; //false
             exp[3] = "(6!=9)"; //true
             exp[4] = "(6<=9)"; //true
             exp[5] = "((6<9)&&(9>6))"; //true
             exp[6] = "(6<9)"; //true
             exp[7] = "((6>9)||(9>6))"; //true
             exp[8] = "((6!=9)&&(6<9)||(9==9))";//true
             exp[9] = "((6>9)&&(6<9)&&(6==9))"; //false
             exp[10] = "((9!=9)||(4==5)&&(6<9))"; //false
             exp[11] = "((6!=9)||(9==6))"; //false
             exp[12] = " "; //invalid
             exp[13] = "()"; //invalid
             exp[14] = "(O==0)"; //invalid
             exp[15] = "10>1"; //invalid
           System.out.println("Please type in a number from 0-15 to be evaluated: ");           
          int pick1 = in.nextInt();
                System.out.println("Your expression is: "+(exp[pick1]));
                System.out.println(Stacks.evaluate(exp[pick1]));
          }   
    }

   

    
