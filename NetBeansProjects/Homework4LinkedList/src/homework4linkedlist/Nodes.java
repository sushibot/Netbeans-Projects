/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4linkedlist;

/**
 *
 * @author Owner
 */
public class Nodes 
{
    public int number;
    public Nodes next;
    
    public Nodes(int number, Nodes next ) {
        this.number=number;
        this.next = next;
    }
    public void display(){
        System.out.println(number+":");
   
    }
    
class LinkList
{
    public Nodes firstLink;
    
    LinkList(){
        firstLink=null; //first link always starts as a null value
        
    }
    public boolean isEmpty(){
        return(firstLink==null); //checks if first link is empty
    }
    /*
     * Method adds a new link to the list
     * creates a new link, takes value of previous linked list and stores
     * into next, store a reference to new link as a value for first link
     */
    public void insertFirstLink(int number){
        Nodes newLink = new Nodes(number);//new link added
        newLink.next=firstLink;//stores address for new link
        firstLink=newLink;//this link is now the last guy to be added
    }
    /*
     * Method removes a node from the list
     */
    public Nodes removeFirst(){
        Nodes linkReference = firstLink;
        if(!isEmpty()){
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty Linked List");
        }
        return linkReference;
            
    }
    /*
     * Cycling through all the links in the lists
     */
    public void display(){
        Nodes theLink = firstLink; //last link to be added
        while(theLink!=null){
            theLink.display();
            System.out.println("Next Link: "+theLink.next);
            theLink = theLink.next;//address for next link
            System.out.println();
        }
    }
    /*
     * Method that matches and finds a link in the list
     */
    public Nodes find(int num)
    {
        Nodes theLink = firstLink;
        if(!isEmpty()) //checks if the list is empty first
        {
            while(theLink.number!=number)
            {
                if(theLink.next==null)//checks if end of list
                {
                    return null;
                } else 
                {
                    theLink = theLink.next; //when it finds mathcing link
                }
            } 
         }     else{
                    System.out.println("Empty Linked List"); //prints if link list is empty
                   }
        return theLink;  //returns matching link
    }
    /**
     * 
     * @param num node that method will remove
     * @return returns either if the node is removed, null, or empty
     */
    public Nodes removeSpecificLink(int num)
    {
        Nodes currentLink =firstLink; 
        Nodes previousLink = firstLink;
        
        while(currentLink.number!=number)
        {
            if(currentLink.next==null)
            {
                return null;
            } else 
            {
                previousLink = currentLink;
                
                currentLink = currentLink.next;
            }
        }
        if(currentLink == firstLink)
        {
            firstLink = firstLink.next;
        }
        else
        {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }
    }
}

    
    
    
    

