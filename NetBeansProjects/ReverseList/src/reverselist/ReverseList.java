/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselist;

/**
 *
 * @author Gabriel Fontanilla
 * 10/7/16
 * CSCI 2913
 */
public class ReverseList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Standard Link List case output
         */
        System.out.println("[Standard Case]");
        IntNode list = new IntNode(10,new IntNode(37,new IntNode(69,null)));
        System.out.println("_Forward list_");
        for(IntNode point = list; point!=null; point=point.getLink())
        System.out.println(point.getData());     
        System.out.println("_Reverse list_");
        IntNode reverseMe = IntNode.reverse(list);
        for(IntNode point = reverseMe; point !=null; point=point.getLink())
        System.out.println(point.getData());
             System.out.println("\n");
        
        /**
         * 2 node boundary case output
         */
        System.out.println("[Reversing 2 Nodes]");
        list = new IntNode(1, new IntNode(5, null));
        System.out.println("_Forward list_");
        for(IntNode point = list; point!=null; point=point.getLink())
        System.out.println(point.getData());
        System.out.println("_Reverse list_");
        reverseMe = IntNode.reverse(list);
        for(IntNode point = reverseMe; point!=null; point=point.getLink())
        System.out.println(point.getData());
            System.out.println("\n");
        
        /**
         * 1 node boundary case output
         */
          System.out.println("[Reversing 1 Node]");
          list = new IntNode(69, null);
          System.out.println("_Foward list_");
          for(IntNode point =list; point!=null; point=point.getLink())
          System.out.println(point.getData());
          System.out.println("_Reverse list_");
          reverseMe = IntNode.reverse(list);
          for(IntNode point = reverseMe; point!=null; point=point.getLink())
          System.out.println(point.getData());
            System.out.println("\n");
            
         /**
          * Nothing in list, Boundary case output
          */
          System.out.println("[Reversing nothing in list]");
          list = null;
          System.out.println("_Foward list_");
          for(IntNode point = list; point!=null; point=point.getLink())
          System.out.println(point.getData());
          System.out.println("_Reverse list_");
          reverseMe = IntNode.reverse(list);
          for(IntNode point = reverseMe; point!=null; point=point.getLink())
          System.out.println(point.getData());
            
          
        
    }
}
