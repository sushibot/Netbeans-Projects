/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectassignment4;

/**
 *
 * @author Owner
 */
public class rectangleClass extends shapeClass
{
    private double width;
    private double height;
    private double x;
    private double y;
    
   public rectangleClass (double x, double y, double wt, double ht)
   {
       this.x =x;
       this.y=y;
       this.width = wt;
       this.height = ht;
   }
    
    void printAttributes ()
    {
    System.out.println("<rect x='" + x + "' y='" + y + "' width='" + width +"' height='" + height + "'");
    this.print();
    } 
}
