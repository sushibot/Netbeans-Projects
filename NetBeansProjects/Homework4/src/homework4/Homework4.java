/*
 * @author Gabriel Fontanilla
 * CSCI 2913
 * 9/26/16
 */
package homework4;


public class Homework4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //This is the standard test case
    keyedBag H1 = new keyedBag(6);
    H1.insert("Rachel",99);
    H1.insert("Michelle",82);
    H1.insert("Gabe",27);
    H1.insert("Alter",12);
    H1.insert("Tyler",90);
        System.out.println("[Standard Case]");
        System.out.println(H1.retrieve(69)+" Her key item is 69");
        System.out.println("Does the key item 69 exist? "+H1.search(69));
        System.out.println("Is the key item for Rachel removed? "+H1.remove(69));
        System.out.println("__________________________________________");
        System.out.println(H1.retrieve(82)+" Her key item is 82");
        System.out.println("Is the key item for Michelle removed? "+H1.remove(82));
        System.out.println("Does the key item 82 exist? "+H1.search(82));
        System.out.println("__________________________________________");
        System.out.println(H1.retrieve(27)+" His key item is 27");
        System.out.println("Does the key item 27 exist? "+H1.search(27));
        System.out.println("Is the key item for Gabe removed? "+H1.remove(27));
        System.out.println("__________________________________________");
        System.out.println(H1.retrieve(12)+" His key item is 12");
        System.out.println("Does the key item for Alter exist? "+H1.search(12));
        System.out.println("Is the key item for Alter removed? "+H1.remove(12));
        System.out.println("__________________________________________");
        System.out.println(H1.retrieve(90)+" His key item is 90");
        System.out.println("Does the key item for Tyler exist? "+H1.search(90));
        System.out.println("Is the key item for Tyler removed? "+H1.remove(90));
        System.out.println("\n");
        
        //This case will retrieve a removed item 
        System.out.println("[Calling a removed key Case]");
        System.out.println("The key I will be retrieving is 69: "+H1.retrieve(69));
        System.out.println("\n");
        
        //This case will call an item that does not exist
        System.out.println("[Calling an item that does not exist Case]");
        System.out.println("Does this item exist? "+H1.retrieve(96));
        System.out.println("\n");
        
        //This case will search a key that does not exist
        System.out.println("[Searching for a key that does not exist Case]");
        System.out.println("Does this key item exist? "+H1.search(66));
        System.out.println("\n");
        
        //This case will call an removed item that does not exist
        System.out.println("[Calling removed item that does not exist Case]");
        System.out.println("Does this removed item exist? "+H1.remove(6969));
        System.out.println("\n");
        
        //This case will search for a removed key
        System.out.println("[Searching for removed key Case]");
        System.out.println("Searching for removed key....It is removed! "+H1.remove(27));
        System.out.println("\n");
        
        //This case will search, retrieve, and remove an item from an empty bag
        keyedBag H2 = new keyedBag();
        System.out.println("[Empty Bag Case]");
        System.out.println("Does this item exist? "+"\""+H2.retrieve(777777)+"\"");
        
        
        
    

        
    }
}
