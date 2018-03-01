/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.net.*; 
import java.io.*; 
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author yzhu
 */
public class Server { 
 
 public static void main(String[] args) throws IOException 
   { 
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(8090); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: 80."); 
         System.exit(1); 
        } 

    Socket clientSocket = null; 
    System.out.println ("Waiting for connection.....");

    try { 
         clientSocket = serverSocket.accept(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Connection Unsuccessful."); 
         System.exit(1); 
        } 

    System.out.println ("Connection successful");
    System.out.println ("Waiting for input.....");

    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                                      true); 
    BufferedReader in = new BufferedReader( 
            new InputStreamReader( clientSocket.getInputStream())); 
    

 
   
    String inputLine; 
    boolean done = false;
    while ((inputLine = in.readLine()) != null) 
        { 
         System.out.println ("Server: " + inputLine); 
         out.println("Aloha"); 
         
            ArrayList<Integer> data = new ArrayList<Integer>();
            int data1 = 0;
            while((data1 = Integer.parseInt(in.readLine())) != -1)
            {
                data.add(data1);
            }
            System.out.println("Your file " + writeToFile(data).getName());

         if (inputLine.equalsIgnoreCase("Bye")) 
             break; 
        } 

    out.close(); 
    in.close(); 
    clientSocket.close(); 
    serverSocket.close(); 
   } 
  private static File writeToFile(ArrayList<Integer> data)
    {
        File file = new File("Server" + new Random().nextInt(10) + "" + new Random().nextInt(10) + "" + new Random().nextInt(10) + ".txt");
        FileOutputStream fileOut = null;
        try {
             fileOut = new FileOutputStream(file);
            for (int i = 1; i < data.size(); i++) {
                fileOut.write(data.get(i));
            }

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Error writing file!");
        }
        finally{
            try {
                fileOut.flush(); fileOut.close();
            } catch (IOException ex) {
                System.err.println("Error writing file!");
            }
        }
        return file;
        
    }
}