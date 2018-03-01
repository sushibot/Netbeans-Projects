
package client;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("127.0.0.1");

        if (args.length > 0)
           serverHostname = args[0];
        System.out.println ("Attemping to connect to host " +
		serverHostname + " on port 21.....");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
          
            echoSocket = new Socket(serverHostname,8090);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

	BufferedReader input = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

        System.out.print ("input: ");
        
	while ((userInput = input.readLine()) !=  null) {
	    out.println(userInput);
	    try{
                System.out.println("echo: " + in.readLine());
                for (Integer data : readFile("xxx.txt")) {
                    out.println(data);
                }
                System.out.println(in.readLine());
            }
            catch (Exception e)
            {
                System.out.println("Socket Closed!");
                break;
            }
            
            System.out.print ("input: ");
            
	}

	out.close();
	in.close();
	input.close();
	echoSocket.close();
    }
      private static ArrayList<Integer> readFile(String fileName)
    {
        ArrayList<Integer> data = new ArrayList<Integer>();
        FileInputStream fileIn;
        File file = null;
        try {
            file = new File(fileName);
            fileIn = new FileInputStream(file);
            int temp = 0;
            data.add((int)file.length());
            while((temp = fileIn.read()) != -1)
            {
                data.add(temp);
            }
            return data;
        } catch (FileNotFoundException ex) {
            System.err.println("File Not found!");
            System.exit(0);
        } catch (IOException ex) {
            System.err.println("Error Reading File!");
            System.exit(0);
        }
        return data;
    }
}