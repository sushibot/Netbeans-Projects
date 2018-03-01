package projectassignment4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
import java.util.ArrayList;
abstract class shapeClass 
{
    private ArrayList<String> style  = new ArrayList<String>();
    
    public void figureStyle (String key, String value)
    {
        style.add(key + ":" + value);
    }
    void print()
    {
        StringBuilder builder = new StringBuilder();
        for (String keyValue : style) 
        {
            builder.append(keyValue +";");
        }
        System.out.println("style='" + builder + "'/>");
    }
    abstract void printAttributes();
}
