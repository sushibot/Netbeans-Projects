
package noobgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class NoobGame extends JFrame
{
    int x, y, xDirection , yDirection;
    private Image dbImage;
    private Graphics dbg;
    Font font = new Font("Arial, ", Font.BOLD | Font.ITALIC, 17);
    Image Face;
    
    public void move()
    {
        x += xDirection;
        y += yDirection;
        
    }  
    public void setXDir (int xdir)
    {
     xDirection = xdir;
    }
    public void setYDir (int ydir)
    {
        yDirection = ydir;
    }
    public class actionListener extends KeyAdapter 
    {
        public void keyPressed (KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_LEFT)
            {
              setxDirection (-1);
            }
             if(keyCode == e.VK_RIGHT)
            {
               
            }
              if(keyCode == e.VK_UP)
            {
             
            }
               if(keyCode == e.VK_DOWN)
            {
              
            }
        }
        public void keyReleased (KeyEvent e)
        {
               int keyCode = e.getKeyCode();
            if(keyCode == e.VK_LEFT)
            {
              
            }
             if(keyCode == e.VK_RIGHT)
            {
               
            }
              if(keyCode == e.VK_UP)
            {
             
            }
               if(keyCode == e.VK_DOWN)
            {
              
            }
            
        }
    }
    public NoobGame()//constructor gets called whenever an instance is created
    {   
        //LOADING IMAGES
        
        ImageIcon i = new ImageIcon("null");
        Face = i.getImage();
        //GAME PROPERTIES
        addKeyListener (new actionListener());
        setTitle("null");
        setSize(250,250);
        setResizable(false);
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        x=150;
        y=150;
                
    }
    public void paint (Graphics g)
    {
        dbImage = createImage(getWidth(),getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent (Graphics g)
    {
        g.setColor(Color.red);
        g.drawImage(Face, x, y, this);
        g.setFont(font);
        g.drawString("Aloha", 69, 69); 
        g.setColor(Color.cyan);
        g.fillOval(x, y, 17, 17);
        repaint();
       
        
        
    }
  
    public static void main(String[] args) 
    {
       new NoobGame();
    }
}
