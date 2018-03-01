/*
 * Gabriel Fontanilla
 * Project Assignment X
 * 3/19/15
 * 
 */

package projectassignment3;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author Owner
 */
public class ProjectAssignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        
        int i = 0;
        Scanner user = new Scanner(System.in);
        while(true)
        {
            System.out.println("Please type in the file name: ");
            System.out.println("----->");
            String answer = user.nextLine();
            ArrayList <Double> doubles = new ArrayList();
            File inFile = new File(answer);
            
            try
            {
                Scanner input = new Scanner(inFile);
                while(input.hasNext())
                {
                    String response = input.nextLine();
                    if(response.isEmpty())
                    {
                        System.out.println("Black Line Encountered.");
                        System.exit(0);
                    }
                    double list = Double.parseDouble(response);
                    doubles.add(list);
                    
                }
                double [] read = new double[doubles.size()];
                for (int j = 0; j < doubles.size(); j++) 
                {
                    read[j] = doubles.get(j);
                }
                mergeSort(read);
                break;
            }
            catch(FileNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
              
            
                
              
        }
    }
    static void mergeSort(double [] read)
    {
        double [] u = new double [read.length];
        int minimum = 0;
        int maximum = read.length-1;
        mergeSort (read,u,maximum,minimum);
        for (int i = 0; i < read.length; i++) 
        {
            System.out.println(read[i]);    
        }
    }
    static void mergeSort(double[]read, double[]u, int minimum, int maximum)
    { 
        int lhs;
        int lhsMaximum;
        int lhsMinimum;
        int rhsMinimum;
        int rhs;
        int dst;
        
        if(minimum == maximum) return;
        lhsMaximum = (minimum + maximum)/2;
        rhsMinimum = lhsMaximum+1;
        mergeSort(read, u,minimum,lhsMaximum);
        mergeSort(read, u,rhsMinimum,maximum);
        for (int i = 0; i < read.length; i++) 
        {
            u[i]=read[i];
            
        }
        lhs = minimum;
        rhs = rhsMinimum;
        dst = minimum;
        while((lhs<=lhsMaximum)&&(rhs<=maximum))
        {
            if(u[lhs]<u[rhs])
            {
                read[dst] = u[lhs];
                lhs = lhs+1;
            }
            else
            {
                 read[dst] = u[lhs];
                 rhs = rhs+1;
            }
            dst = dst+1;
        }
        while (lhs<=lhsMaximum)
        {
            read[dst]=u[rhs];
            lhs = lhs+1;
            dst=dst+1;
        }
        while(rhs<=maximum)
        {
            read[dst]=u[rhs];
            rhs = rhs+1;
            dst = dst+1;
        }
    }
}
