/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectassignment2;

/**
 *
 * @author Owner
 */
import java.util.Scanner;
import java.util.*;

public class Contacts 
{
    String name; //stores contact name
    String phoneNumber; //stores contacts number
   
   public Contacts()
   {
       Scanner user = new Scanner(System.in);
       System.out.println("NAME:");
       name = user.nextLine();
       System.out.println("PHONE: ");
       phoneNumber = user.nextLine();
       
   }
    public String toString()
    {
        return (name +";" +phoneNumber);
    }
   public String getNumber()
   {
       return phoneNumber;
   }
}
