/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectassignment4;

/**
 *
 * @author Owner
 */
import java.util.ArrayList;

public class ScalableVectorGraphics 
{
    private ArrayList<shapeClass> shapes = new ArrayList<shapeClass>();
    private double width;
    private double height;
    
    public ScalableVectorGraphics(double ht, double wt)
    {
        this.height=ht;
        this.width=wt;
    }
    void addShape (shapeClass shape)
    {
        shapes.add(shape);
    }

    void print() 
    {
         System.out.println("<svg "+"width= "+width+"' height= " + height +">");
        
        for(int i = 0; i<shapes.size(); i++)
        {
            shapes.get(i).printAttributes();
        }
        
        System.out.println("</svg>");
    }
}
