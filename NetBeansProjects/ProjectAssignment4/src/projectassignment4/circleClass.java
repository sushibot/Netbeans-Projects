/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectassignment4;

/**
 *
 * @author Owner
 */
public class circleClass extends shapeClass
{
    private double circleX;
    private double circleY;
    private double radius;
    
    public circleClass(double cx, double cy, double r)
    {
        this.circleX=cx;
        this.circleY = cy;
        this.radius = r;
    }
    void printAttributes ()
    {
        System.out.print("<circle cx='" + circleX +"' cy='" + circleY + "' r='" + radius + "'");
        this.print();
    }
}
