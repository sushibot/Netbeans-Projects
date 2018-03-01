package hpu.edu.team2.client;

import java.io.*;
import java.net.*;
/*
*This floods message out to everyting
*/
public class ListeningThread extends Thread{
Socket listen = null;

  public ListeningThread(Socket listen){
  this.listen = listen;
  }
/*This method will run the thread and will flood
all the other PC's on the network with messages that One PC sent out*/
  @Override
  public void run(){//start of run method
    try{
      BufferedReader read = new BufferedReader(new InputStreamReader(listen.getInputStream()));
      String line = null;
      while( ((line = read.readLine())!=null)  ){
        System.out.println("Receiving message [ "+line+" ]");
        String want_file = "requesting file";
          if(line.toLowerCase().contains(want_file)){
            request();
          }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }//end of run method
/*This method is responsible for */
  public void request() throws IOException{
    BufferedReader name_in = new BufferedReader(new InputStreamReader(listen.getInputStream()));
    String name = name_in.readLine();
    System.out.println("Requesting file from: "+name);

  }

}