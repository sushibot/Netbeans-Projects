
package gamethingy;

import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Image;
import java.awt.Font;

public class Gamethingy extends JFrame {
    
    int x;
    int y;
    private Image dbImage;
    private Graphics dbg;
    
    Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);

public class AL extends KeyAdapter {
    public void keyPressed (KeyEvent e ){
        int keyCode = e.getKeyCode();
        
        if (keyCode == e.VK_A){
           if (x <=-3)
               x =-3;
           else
            x-=7;
        
        } if (keyCode == e.VK_D){
            if (x >=285)
                x = 285;
            else
            x+=7;
        
        } if (keyCode == e.VK_W){
            if(y <=20)
                y = 20;
            else
                
            y-=7;
            
        
        } if (keyCode == e.VK_S){
          if (y >=285)
              y = 285;
          else
            y +=7;
       
        }
}

public void keyReleased (KeyEvent e) {

}
}
public Gamethingy(){//GAME PROPERTIES//////
    //Constructor
    
    
    ////Game Properties ///////(down)
    addKeyListener(new AL());
    setTitle("Move the circle");
    setSize(300, 300);//Grid Size///////////////////////////
    setResizable(false);
    setVisible(true);
    setBackground (Color.BLACK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    x = 150;
    y = 150;
    ////Game Properties //////(Up)
}   

public void paint (Graphics g) {
    dbImage = createImage (getWidth(), getHeight());
    dbg = dbImage.getGraphics();
    paintComponent(dbg);
    g.drawImage(dbImage, 0, 0, this);
    
    
}
public void paintComponent(Graphics g){
  g.setColor(Color.GRAY);
   //g.drawString("Eat Stuff.",50,50);
    g.setColor(Color.red);
   g.fillOval(x, y, 15, 15);
    
    repaint();
}

    public static void main(String[] args) {
       new Gamethingy ();
    }
}
