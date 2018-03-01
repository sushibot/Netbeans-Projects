/*
 * This program is a java console application that can manage a simple address book.
 * 
 * @author  Fontanilla, Gabriel
 * @assignment CSCI 2912 Assignment X
 * @date 2/29/15
 * 
 */
package projectassignment2;

/**
 *
 * @author Owner
 */
import java.util.Scanner;
import java.io.*;
public class ProjectAssignment2
{


   
    public static void main(String[] args) 
    {
      Scanner user = new Scanner(System.in);
      
      while(true)
      {
          menu();
          String answer = user.next();
          answer.toLowerCase();
          if(answer.toLowerCase().equals("add"))
          {
              AddressBook.addContact();
              
          }
          else if(answer.toLowerCase().equals("find"))
          {
              System.out.println("WHAT--->");
              String locate = user.nextLine();
              AddressBook.findContact(locate);
              System.out.println("Number of Contacts found: "+AddressBook.counter);
              
          }
          else if(answer.toLowerCase().equals("print"))
                  {
                      AddressBook.printContact();
                  }
          else if(answer.toLowerCase().equals("quit"))
          {
              System.exit(0);
          }
          else
          {
              System.out.println("Invalid command. Please try again: ");
          }
      }
      
    }
    
    public static void menu ()
    {
        System.out.println(" `Address Book Menu` ");
        System.out.println("  _________________");
        System.out.println("                  ");
        System.out.println(" ADD: adds contacts");
        System.out.println(" FIND: Finds contact");
        System.out.println("PRINT: Prints contacts");
        System.out.println("    QUIT: Quits  ");
        System.out.println("  _________________");
    }
}