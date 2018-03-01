/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

/**
 *
 * @author Gabriel Fontanilla
 */
public class keyedBag {
    private String[] item; //item that represents a persons name
    private int[] key; //unique number that points to corresponding item
    private int allItems = 0; //number of items in the bag
    
    //constructor takes in int and sets it to whatever size that is typed in
    public keyedBag(int size)
    {

        this.item = new String[size];
        this.key = new int[size];    
      
        size=100;
        
    }
    public keyedBag()
    {
      this(10);
    }
    /**
     * 
     * @param entry takes in string item and stores into item array
     * @param data takes in int item and stores into key array
     */
    public void insert(String entry, int data)
    {
        this.item[allItems]=entry;
        this.key[allItems++]=data;             
    } 
    //searches the array for the index that the key is in
    public boolean search(int data)
    {   
        for(int i =0; i<key.length; i++ )
        {
            if(key[i]==data)
            {
                return true;
            }
        }
        return false;
    }
    //retrivies data from the corresponding key given
    public String retrieve(int data)       
    {
        for(int i =0; i<key.length; i++ )
        {
            if(key[i]==data)
            {
                return item[i];
            }     
            else if(key[i]==data)
            {
                if(data==data){
                return item[i];
                }
            }
        }
        return null;
    }
    //removes data from the corresponding data given
    public boolean remove(int data)
    {
        
        for(int i =0; i<key.length; i++)
        {
            if(key[i]==data)
            {
                this.item[i]=this.item[allItems--];
                return true;
            }
        } return false;
    }
    
}
