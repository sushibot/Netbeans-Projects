/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectassignment4;

/**
 *
 * @author Owner
 */
public class lineClass extends shapeClass
{
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    
    public lineClass(double x1, double x2 ,double y1, double y2)
    {
     this.x1=x1;
     this.x2=x2;
     this.y1=y1;
     this.y2=y2;
    }
    void printAttributes()
    {
         System.out.print("<line x1='" + x1 + "' y1='" + y1 + "' x2='" + x2 + "' y2='" + y2 + "'");
        this.print();
    }
}

