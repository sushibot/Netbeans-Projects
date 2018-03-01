
package javalesson20;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
 class JavaLesson20 extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    
        new JavaLesson20();
        
        
    }
    public JavaLesson20()
    {
        this.setSize(400,400);
        //set size for the frame
        this.setLocationRelativeTo(null);
        //will set postition base off what the screen is
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        //allows me to access different methods
        
        Dimension dim = tk.getScreenSize();
                //holds width and height for a component
        // returns height and width
        
        int xPos = (dim.width/2)-(this.getWidth() /2); //return width 
        int yPos = (dim.height /2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setResizable(false);
        this.setVisible(true);
        
        
    }
}
