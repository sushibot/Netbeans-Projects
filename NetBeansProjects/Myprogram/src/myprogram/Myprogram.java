
package myprogram;

import java.util.Scanner;
public class Myprogram {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            
        }
            
        }    
    public static boolean vowels(char [] c){
        for (int i = 0; i < c.length; i++) {
            if( (c.equals('a')) || (c.equals('e')) || (c.equals('i')) || (c.equals('o')) || (c.equals('u')))
                return true;       
        }
        return false;
    
    }
    }       

