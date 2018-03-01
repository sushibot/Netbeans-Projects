package hpu.edu.team2.server;
import java.io.*;
import java.net.*;
import java.util.logging.*;
import java.util.*;
import java.text.*;
import java.time.*;

/*This class is responsible for appending any actions
between PC and server to a ServerLog.txt file*/
public class Log{
PrintWriter out;
String name = "";
String msg = "";
SocketAddress addr = null;

  public Log(String name, String line,SocketAddress addr){
    this.name = name;
    this.msg = line;
    this.addr = addr;
  }

  public void log() throws Exception{//start of log file
    Date date = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
      out = new PrintWriter(new FileOutputStream("ServerLog.txt",true));
      out.println(name+": "+msg+" from address: "+addr+" on "+formatter.format(date));
      out.flush();
  }//end of log file

}//end of Log Class