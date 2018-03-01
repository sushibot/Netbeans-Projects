/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Owner
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(fib(9));
        int [] look = {1,3,5,9,11,15,21,26};
    }
    public static int fib(int n)
    {
        return(n<=1)?n: fib(n-1)+fib(n-2);
    }
    public static int binary(int n, int[]nums)
    {
        int mid = nums.length/2;
        if(n<mid)
        {
            
        }
        else if(n>mid)
        {
            
        }
    }
}
