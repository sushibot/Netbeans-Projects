/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalspractice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author yzhu1
 */
public class FinalsPractice extends JFrame{
    private final int WIN_WIDTH = 1000;
    private final int WIN_HEIGHT = 800;
    private JPanel panel;
    
    public FinalsPractice(){
        setTitle("Advanced GUI Example");
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildMenu();
        setVisible(true);
    }

    
    public static void main(String[] args) {
        new FinalsPractice();// TODO code application logic here
    }

    private void buildMenu() {
        final JRadioButtonMenuItem itemOne 
                = new JRadioButtonMenuItem("Koala", true);
        final JRadioButtonMenuItem itemTwo
                = new JRadioButtonMenuItem("Turing Machine");
        final JMenuItem open = new JMenuItem("Open");
        final JMenuItem save = new JMenuItem("Save");
        final JMenuItem color = new JMenuItem("Color");
        final JMenuItem exit = new JMenuItem("Exit");
        
        final JMenu menu = new JMenu("Menu");
        
        menu.add(itemOne);
        menu.add(itemTwo);
        menu.addSeparator();
        menu.add(open);
        menu.add(save);
        menu.addSeparator();
        menu.add(color);
        menu.addSeparator();
        menu.add(exit);
        
        final ButtonGroup group = new ButtonGroup();
        group.add(itemOne);
        group.add(itemTwo);
        
        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        
        final ImageIcon image = new ImageIcon("koala.jpg");
        final JLabel label = new JLabel(image);
        this.add(label);
        
        itemOne.addActionListener(new ActionListener(){
          @Override
         public void actionPerformed(ActionEvent evt) {
                final ImageIcon icon = new ImageIcon("koala.jpg");
                label.setIcon(icon);
            }
        });
        
        itemTwo.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent evt) {
              final ImageIcon icon = new ImageIcon("turing-machine.jpg");
              label.setIcon(icon);
            }
          });
        
        open.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                if(fileChooser.showOpenDialog(FinalsPractice.this)
                        == JFileChooser.APPROVE_OPTION)
                {
                    final File selected = fileChooser.getSelectedFile();
                     try{
                     final Scanner scanner = new Scanner(selected);
                     int count=0;
                     while(scanner.hasNextLine()){
                         count++;
                         System.out.println(scanner.nextLine());
                      }
                     label.setIcon(null);
                     label.setText("The total number of lines is "+count);
                    }catch(FileNotFoundException ex){
                        System.err.println("File Not Found!");
                    }} }  });
        
        save.addActionListener(new ActionListener(){
          @Override
            public void actionPerformed(ActionEvent e) {
               final JFileChooser fileChooser = new JFileChooser();
               if(fileChooser.showSaveDialog(FinalsPractice.this)
                  == JFileChooser.APPROVE_OPTION){
                 final File filename = fileChooser.getSelectedFile();
                   try {  
                       final PrintStream printer = new PrintStream(filename);
                       printer.println("This is the first line");
                       printer.println("This is the second line");
                   } catch (FileNotFoundException ex) {
                       System.out.println("File Not Found");
                   }}
            }       
        });
      
        color.addActionListener(new ActionListener(){
         @Override
            public void actionPerformed(ActionEvent e) {
              final Color selected = JColorChooser.showDialog(
                      FinalsPractice.this, 
                      "Color Chooser Example", 
                      Color.BLUE);
              label.setIcon(null);
              label.setText("Selected Color is "+selected);
            }
       });
        
       exit.addActionListener(new ActionListener(){
          @Override
            public void actionPerformed(ActionEvent e) {
             FinalsPractice.this.dispose();
            }
       });
        
    }
}