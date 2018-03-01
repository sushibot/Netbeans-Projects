/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectassignment2;

/**
 *
 * @author Owner
 */
import java.util.ArrayList;

public class AddressBook 
{
    static ArrayList<Contacts> index = new ArrayList();
    static int i = 0;
    public static int counter = 0;
    
    public AddressBook(String name)
            {
                
            }
    public static void addContact()
    {
     Contacts addPerson = new Contacts();
     index.add(addPerson);
        System.out.println("\nAdded ["+addPerson+"]");
    }
    
    public static void findContact(String find)
    {
        counter = 0;
        for (int j = 0; j < index.size(); j++) 
        {
             if (index.get(i).toString().toLowerCase().contains(find.toLowerCase())) {
                System.out.println("[" + index.get(i) + "]");
                counter++;
        }
             
    }
    }
    public static void printContact()
    {
        for (int j = 0; j <index.size(); j++) 
            System.out.println("["+index.get(j)+"]");
        {
            
        }
        System.out.println("\nThe number of contacts you have are: "+index.size() +"\n");
    }
}
