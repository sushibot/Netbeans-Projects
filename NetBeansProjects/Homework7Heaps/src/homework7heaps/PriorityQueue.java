/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package homework7heaps;

import java.util.NoSuchElementException;

    
/**
 *
 * @author Gabriel Fontanilla
 */

public class PriorityQueue {
           public int [] data; //array of ints
           public int [] priority;//array that keeps count of the priority of data 
           public int [] entered;//array that checks and compares two priorites that got entered in the same time
           public int manyItems; //size of queue so far
           public int top;
         /**
          * Sets up arrays and initializes each size to 10
          * @param root 
          */
        public PriorityQueue()
        {
         manyItems=0;
         entered= new int[10];
         data = new int [10];
         priority = new int[10];      
        }
        /**
         * This method adds a node with its data and priority, into the queue
         * @param item data that will be stored into array 
         * @param p priority that will be stored into array
         */
        public void add(int item, int p)
       {
            //checks if priority entered, is greater than 0
            try{
         //checks if the size of array is full
            if(priority.length==manyItems && data.length==manyItems)
            {
                //if array is full, double size
                int [] tempD = new int[data.length*2];
                data = tempD;
                int [] tempP = new int [priority.length*2];
                priority = tempP;
                int [] tempE = new int [entered.length*2];
                entered = tempE;      
            }
            //checks if arrays are empty   
            if(priority.length==0&&data.length==0)
            {
                //sets the size of 10 to the array if it is empty
                data = new int [10];
                priority = new int [10];              
            }else{
            data[manyItems]=item;
            priority[manyItems]=p;
           entered[manyItems]=manyItems++;
          reHeapUp(manyItems-1);
            }
        }catch(IllegalArgumentException e){
                System.out.println("Error, priority value must be greater or equal to 0.");
        }        
       }
       /**
        * This method checks if the other child exists, 
        * then swaps it with each other.
        * @param A index of first node
        * @param B index of second node
        */
        public void swap(int A, int B)
        {
            
            try{
            int x = data[A];
            data[A]=data[B];
            data[B]=x;
            
            int y = priority[A];
            priority[A]=priority[B];
            priority[A]=y;
            
            int z = entered[A];
            entered[A]=entered[B];
            entered[A]=z;  
            }catch(IllegalArgumentException e){
                System.out.println("No such child exists.");
            }
        } 
        /**
         * Method that moves a new node up the tree
         * @param A Node that we compare
         * @return returns new location
         */
        public int reHeapUp(int A)
        {
            if(A==0)           
                return A;
            if(priority[(A-1)/2]> priority[A])          
                swap(A,(A-1)/2);
                return(A-1)/2; 
            
        }
        /**
         * 
         * @param rem item that will be removed in array
         * @return removed item
         */
        public int remove(int r)
        {
            if(manyItems==0)
            {
               System.out.println("No items in heap");           
            }
            swap(0,manyItems);
            --manyItems;
            int A =1;
            while(priority[A]>priority[(A-1)/2]){
             if(priority[A*2+1]==priority[(A+1)*2])
             {
                 if(entered[(A*2+1)]<entered[(A+1)*2])
                 {
                     swap((A*2+1),A);
                     A=(A*2+1);
                 }
                 else
                 {
                     swap((A+1)*2,A);
                     A = (A+1)*2;
                 }
             } 
             else if(priority[A*2+1]>priority[A])
             {
                 swap((A*2+1),A);
                 A=A*2+1;
             }
             else if(priority[(A+1)*2]>priority[A])
             {
                 swap(A,(A+1)*2);
                 A=(A+1)*2;
             }
            }
            
            return data[manyItems];
        }
}
        
        
    
