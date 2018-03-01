/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpart;
import java.io.*;
import java.util.*;
import java.net.*;
public class ClientPart {


    public static void main(String[] args)throws UnknownHostException,IOException {
        Scanner input = new Scanner(System.in);//for the user input
        
        int num, result;
       
            Socket client = new Socket("localhost",8080);
            Scanner server = new Scanner(client.getInputStream());
           System.out.println("Type in a number: ");
           num = input.nextInt();
           PrintStream pass = new PrintStream(client.getOutputStream());
           pass.println(num);
           result = server.nextInt();
            System.out.println(result);
       
        
        
    }
}
