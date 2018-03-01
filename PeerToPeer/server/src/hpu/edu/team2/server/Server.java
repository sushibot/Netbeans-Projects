package hpu.edu.team2.server;
import java.io.*;
import java.net.*;
import java.util.logging.*;
import java.util.*;
import java.text.*;
import java.time.*;

public class Server{
  ServerSocket socket;
  ListeningThread thread;

  //specifies the TCP port on which the server will use to listen
  public Server(int port) throws IOException{
    socket = new ServerSocket(port);
  }

  //Start the listening thread
  public void start(){
    thread = new ListeningThread();
    thread.start();
    System.out.println("Thread Started: "+thread.getName());
  }

  //Shuts down listening thread if called upon
  public void shutdown() throws IOException{
    thread.shutdown();
  }

  //This class will only handle all of the socket acceptions and nothing else
  private class ListeningThread extends Thread{//start of listening thread class
      boolean goings;

      //Name of the thread
      public ListeningThread(){
        super("Server Thread");
      }

      //This method will shut down the listening thread.
      //The thread will not sniff out connections on the dedicated port
      public void shutdown() throws IOException{//start of shutdown method
        goings = false;
        System.out.println("Closing Server socket....");
        socket.close();
        try{ join();}
        catch(InterruptedException e){}
          System.out.println("Server shut down...");
      }//end of shut down method

      //this thread handles the incoming requests
      public void run(){//start of run method
        try{
          //handles a list of connectors whenever a new client connects to the server
          ArrayList<Connection> connectors = new ArrayList<Connection>();
          boolean goings = true;
          while(goings){
            //This gets the client that the listening thread sniffs out
            Socket s = socket.accept();
            //Returns the client address
            SocketAddress addr = s.getRemoteSocketAddress();
            PrintWriter writer = new PrintWriter(s.getOutputStream(),true);

            /*Passes in current client-socket connected along with the writer*/
            Connection connect = new Connection(writer,s);
            /*Adds new client connection to list*/
            connectors.add(connect);

            /*Passes in client socket and new connection thread to client handler*/
            ClientHandler handle = new ClientHandler(s,connectors);
            /*Starts client handler thread*/
            handle.start();
            System.out.println("Got a connection from:"+addr);
          }
        }catch(IOException e){
          e.printStackTrace();
        }
      }//end of run method
  }//end of listening thread class

/*
*This class will handle each client connection accordingly
*each client will have its own thread connected to the Server
*and each client will spawn a new connection thread with the Connection object
*causing all clients to receive a flooded message
*/
  private class ClientHandler extends Thread{
     Socket socket;
     SocketAddress addr;
     String name = "name";
     ArrayList<Connection> connectors;

     public ClientHandler(Socket socket, ArrayList<Connection> connectors){
       this.connectors = connectors;
       this.socket = socket;
       addr = socket.getRemoteSocketAddress();
     }//end of constructor

     public void run(){//Start of run method
       try{
         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

         while(true){//start of while loop
            name = reader.readLine();
            String line = reader.readLine();
            System.out.println("PC connected: "+name);
            System.out.println("Got message: "+line+" and PC: "+name);
            addr = socket.getRemoteSocketAddress();
            boolean pc_requests = false;
           /*loops through list and prints out PC name and message*/

           for(Connection conn : connectors){
             String file_request = "request file";
            // if(line.toLowerCase().contains(file_request)){
               conn.writer.println(name + ": " + line+" from: "+addr);
               conn.writer.println(name);
            // }
           }

           PrintWriter pc_out_msg = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
           pc_out_msg.println("Testing reply message....");
           pc_out_msg.flush();
           pc_out_msg.println(name+": "+addr);//sends out the PC name and address back to the PC that wants the file
           if(line.equals("shutdown")){
             Server.this.shutdown();
             writer.println("Server won't take any more connections");
             writer.flush();
             return;
           }
           /*Logs in the file*/
           Log file = new Log(name,line,addr);
           file.log();
         }//end of while loop
             }catch(Exception e){//start of catch
         e.printStackTrace();
       }//end of catch
     }//end of Run Method
  }//end of ClientHandler
}//end of server