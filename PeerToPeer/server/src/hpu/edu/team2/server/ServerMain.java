package hpu.edu.team2.server;

public class ServerMain{
  //This just starts the server
  public static void main(String[] args) throws Exception {
      Server server = new Server(2222);
      server.start();
  } // end of main

}