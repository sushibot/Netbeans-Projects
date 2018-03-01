package hpu.edu.team2.client;
import java.io.*;
import java.util.*;
import java.text.*;
import java.time.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
import java.net.*;

public class Client{//Start of Client Class
 private static Scanner in;
 private static Socket main_control = null;
 ServerSocket client_main_socket = null;
 public static PrintWriter writer;
 static ListeningThread thread1;
 static String pcName="";
 static String line = "";

    public static void main(String [] args) throws Exception{
      SocketAddress addr;
      /*Sets up new connection to the server*/
      in = new Scanner(System.in);
      Socket connect_server = new Socket("localhost",2222);

      writer = new PrintWriter(connect_server.getOutputStream(),true);
      thread1 = new ListeningThread(connect_server);
      thread1.start();
      BufferedReader port_reader = new BufferedReader(new InputStreamReader(System.in));
      //Reads in a line of text to the server.
      //Tak ses in the controller message

      System.out.println("Input PC Name: ");
      pcName = in.nextLine();

      while(true){//start of while loop
        System.out.println("Input message: ");
        line = in.nextLine();

        //Shuts client connection down if user types in disconnect
        if(line.equals("disconnect")){
          connect_server.close();
          break;
        }


        //The next few lines of code writes to the server
        //sends the start message to start the simulation
        System.out.println("Sending message "+line+" and PC: "+pcName);
        writer.println(pcName);
        writer.println(line);
    }//end of while loop
}//End of main

/*
*This new class will instatiate a new temporary peer connection when the server
*echo's back the port that the PC will want to connect to
*/

private class PeerConnector{//start of peer connector class
  ServerSocket pc_socket = null;
  PeerListener connect_to_peer = null;
  public PeerConnector(int port) throws IOException{
    pc_socket = new ServerSocket(port);
  }

  public void start(){
    connect_to_peer = new PeerListener();
    connect_to_peer.start();
  }

  public void shutdown()throws IOException{
    connect_to_peer.shutdown();
  }

/*Class that listens for new client connections*/
private class PeerListener extends Thread{//Start of Peer Listener Class
  boolean goings = true;

  public PeerListener(){
    super("P2P listener");
  }
/*
*This method will shutdown the temporary connection between the PC's
*/
  public void shutdown() throws IOException{//start of shutdown method
    goings = false;
    System.out.println("Closing peer connection ");
    client_main_socket.close();
    try{//start of try
      join();
    }catch(InterruptedException e){//start of catch block
      e.printStackTrace();
    }//end of catch block
  }//end of shutdown method

  public void run(){//start of run block
    try{//start of try block
      boolean go = true;
      while(go){//start of while loop
        Socket pc_accept = client_main_socket.accept();
        SocketAddress addr = pc_accept.getRemoteSocketAddress();
        PeerConnection peer_handler = new PeerConnection(pc_accept);
        peer_handler.start();
        System.out.println("Received a connection from: "+addr);
      }//end of while loop
    }catch(Exception e){//start of catch block
      e.printStackTrace();
    }//end of catch block
  }//end of run block
}//end of Peer listener Class

/*Class that spawns a new thread for the P2P connection*/
  private class PeerConnection extends Thread{//Start of PeerConnection Class
    Socket pc_socket =null;
    String pc_id="";
    String msg = "";

    public PeerConnection(Socket pc_socket){
      this.pc_socket = pc_socket;
    }

     public void run(){
       try{//start of try
         BufferedReader pc_reader = new BufferedReader(new InputStreamReader(pc_socket.getInputStream()));
         PrintWriter pc_write_out = new PrintWriter(new OutputStreamWriter(pc_socket.getOutputStream()));
         SocketAddress addr = pc_socket.getRemoteSocketAddress();

         while(true){//start of while loop
           pc_id = pc_reader.readLine();
           msg = pc_reader.readLine();
           System.out.println("Establising Connection to PC: "+pc_id);
           Log pc_log = new Log(pc_id, addr,msg);
           /*This bit will append to the PC log file seperate from the server's one*/
           pc_log.log();
           /*Code here to download file from the other PC*/
         }//End of while loops
       }//end of try
       catch(Exception e){//start of catch
       }//end of catch
     }//end of run method
  }//end of Peer Connection
}//end of peer Connector class
}//End of Class