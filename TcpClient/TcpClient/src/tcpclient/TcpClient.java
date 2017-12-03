package tcpclient;

import java.io.*;
import java.net.*;
import java.time.LocalTime;

/**
 * This is a slightly different client. It establishes a connection
 * to the server, then checks how long it takes to read the single
 * line it expects.
 * 
 * @author mcgredo
 */
public class TcpClient 
{

    public static void main(String[] args) 
    {
        try
        {
           System.out.println("creating socket");
           
           // We request an IP to connect to ("localhost") and
           // port number at that IP (2317). This establishes
           // a connection to that IP in the form of the Socket
           // object; the server uses a ServerSocket to wait for
           // connections.
           
           long startTime = System.currentTimeMillis();
           
           Socket socket = new Socket("localhost", 2317); 
           
          
            // Read the single line written by the server. We'd
            // do things a bit differently if many lines to be read
            // from the server, instead of one only.
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String serverMessage = br.readLine();
            long readTime = System.currentTimeMillis();
            long timeLength = readTime - startTime;

            System.out.println("The message the server sent was " + serverMessage);
            System.out.println("The time to read in ms was " + timeLength);
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Problem with client");
        }

    }
    

    
}