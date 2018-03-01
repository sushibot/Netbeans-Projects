/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myprogram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerPart {
    
    public static void main (String args[])throws IOException{
    int clientData, p;
    ServerSocket getServed = new ServerSocket(8000);//connects to specified port number from client
    Socket serverSide = getServed.accept();//listens for any connections on the port and accepts them
    Scanner serverIn = new Scanner(serverSide.getInputStream());//gets the data from the client
    clientData = serverIn.nextInt();//stores the data from the client
    /**
    For the next couple of lines, do whatever the hell lines of
    code pretaining to the client or whatever
    **/
     p = clientData * 2;
    
    PrintStream pass = new PrintStream(serverSide.getOutputStream());
    pass.println(p);
    }
    
}
