/*
* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectassignment4;

/**
 *@author Fontanilla, Gabriel
 *@assignment CSCI 2912 Project Assignment X
 * @date 4/16/15
 */
import java.io.*;
import java.util.*;

public class ProjectAssignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       String thisLine = " "; 
       String scalableVectorGraphic = "";
       String holder = "";
       double height = 0.0;
       double width =0.0;
       
       try
       {
           for (String file : args) 
           {
            FileInputStream in = new FileInputStream(file);
                Scanner reader = new Scanner(in);
                String header = reader.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(header);
                scalableVectorGraphic = tokenizer.nextToken().trim();
                if(!scalableVectorGraphic.equalsIgnoreCase("svg"))
                {
                    throw new IllegalArgumentException("Invalid token; "+scalableVectorGraphic);
                }
                holder = tokenizer.nextToken().trim();
                height = Double.parseDouble(holder);
                holder = tokenizer.nextToken().trim();
                width = Double.parseDouble(holder);
                
                ScalableVectorGraphics mySvg = new ScalableVectorGraphics (height, width);
                
                while(reader.hasNext())
                {
                    thisLine = reader.next();
                    tokenizer = new StringTokenizer(thisLine);
                    
                    while(tokenizer.hasMoreTokens())
                    {
                        String command = tokenizer.nextToken();
                        thisLine = reader.nextLine();
                        double x,y;
                        
                        if(command.equalsIgnoreCase("rect"))
                        {
                            tokenizer = new StringTokenizer(thisLine);
                            holder = tokenizer.nextToken().trim();
                            x = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            y = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            height = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            width = Double.parseDouble(holder);
                            rectangleClass rect = new rectangleClass(x,y,width,height);
                            mySvg.addShape(rect);
                            newStyle(rect, reader);
                        }
                        else if(command.equalsIgnoreCase("circle"))
                        {
                            tokenizer = new StringTokenizer(thisLine);
                            holder = tokenizer.nextToken().trim();
                            x = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            y = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            double radius = Double.parseDouble(holder);
                            circleClass circle = new circleClass(x,y,radius);
                            mySvg.addShape(circle);
                            newStyle(circle, reader);
                        }else if(command.equalsIgnoreCase("line"))
                        {
                            tokenizer = new StringTokenizer(thisLine);
                            holder = tokenizer.nextToken().trim();
                            x = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            y = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            double x2 = Double.parseDouble(holder);
                            holder = tokenizer.nextToken().trim();
                            double y2 = Double.parseDouble(holder);
                            lineClass line = new lineClass(x,y,x2,y2);
                            mySvg.addShape(line);
                            newStyle(line, reader);
                        }else
                        {
                            throw new IllegalArgumentException("Invalid token: "+command);
                        }
                    }
                }
                mySvg.print();
            }
        } catch (NumberFormatException e) 
        {
            System.err.println("Invalid token: " + e.getMessage());
        } catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        } catch (IOException e) 
        {
            System.err.println("Failed to read input file: " + e.getMessage());
        } 

    }
    static void newStyle(shapeClass s, Scanner input) { //Method used to capture Shape styles.
        String tokenOne, tokenTwo, thisLine;
        
        
        do {
            
            thisLine = input.nextLine();
            
            StringTokenizer tokenizer = new StringTokenizer(thisLine);
            
            tokenOne = tokenizer.nextToken().trim();
            if (!tokenOne.equalsIgnoreCase("end")) {
                tokenTwo = tokenizer.nextToken().trim();
                s.figureStyle(tokenOne, tokenTwo);
            }
        } while (!tokenOne.equalsIgnoreCase("end"));
    }
}

