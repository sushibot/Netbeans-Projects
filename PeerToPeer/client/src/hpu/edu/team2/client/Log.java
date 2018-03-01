package hpu.edu.team2.client;

import java.util.logging.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.time.*;
import java.util.*;
/*This log file will be responsible for appending any actions Done by the PC
side and log them into a ClientLog.txt file */
public class Log{

String name = "";
SocketAddress addr = null;
String msg = "";
PrintWriter out = null;

  public Log(String name, SocketAddress addr, String msg){
    this.name = name;
    this.addr = addr;
    this.msg = msg;
  }

  public void log() throws Exception{
    Date date = new Date();
    SimpleDateFormat date_format = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
    out = new PrintWriter(new FileOutputStream("ClientLog.txt",true));
    out.println(name+": "+msg+" from address: "+addr+" on "+date_format.format(date));
    out.flush();
  }
}