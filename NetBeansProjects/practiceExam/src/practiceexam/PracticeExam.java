/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceexam;

/**
 *
 * @author Owner
 */
public class PracticeExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        execute(8);
    }
    private static void execute (int num)
    {
        if(num>1)
        {
            System.out.println("Executing "+ num);
            execute(num - 2);
            System.out.println("Done with "+num);
        }
    }
}
