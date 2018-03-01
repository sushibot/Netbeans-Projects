package hpu.edu.team2.server;
import java.io.*;
import java.net.*;

/*This class is responsible for holding the connection socket values
between PC's*/
public class Connection{
 PrintWriter writer;
 Socket socket;
    public Connection( PrintWriter writer, Socket socket){
      this.writer = writer;
      this.socket = socket;
    }
}