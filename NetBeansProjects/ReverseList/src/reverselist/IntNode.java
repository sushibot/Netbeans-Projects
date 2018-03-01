/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselist;

/**
 *
 * @author Gabriel Fontanilla
 * CSCI 2913
 */
public class IntNode {
    public int number;
    public IntNode next;//points to the next node
    /**
     * 
     * @param number takes in an int
     * @param next takes the address of the node
     */
    public IntNode(int number, IntNode next)
    {
        this.number=number; 
        this.next=next;
    } 
    //returns data within node
    public int getData(){
        return number;
    }
    //returns link that node is associated with
    public IntNode getLink(){
        return next;
    }
    //stores the data into the nde
    public void setData(int number)
    {
        this.number=number;
    }
    //sets the pointer to the next node
    public void setNext(IntNode next){
        this.next=next;
    }  
    /**
     * Head of list becomes tail 
     * @param firstLink 
     * @return 
     */
    public static IntNode reverse(IntNode firstLink)
    {
        if(firstLink == null) return null;   
            else if(firstLink.getLink()==null) return firstLink;
            else{
                IntNode previous = null;
                IntNode current = null; //temp
                while(firstLink!=null)
                {
                    current = firstLink.getLink(); //grabs next node
                    firstLink.setNext(previous); //point current node to the previous
                    previous = firstLink; //set previous node to current 
                    if(current == null) return firstLink; //return null if current node is null
                    firstLink = current; //if the next node is not null, set it as the head
                }
                return firstLink;
            }
                
    }
    
    
}
