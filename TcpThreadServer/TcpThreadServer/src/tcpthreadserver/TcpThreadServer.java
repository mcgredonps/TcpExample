
package tcpthreadserver;

import java.io.*;
import java.net.*;

/**
 * An example of using threads to handle multiple connections
 * at the same time. 
 * 
 * @author mcgredo
 */
public class TcpThreadServer {

    
    public static void main(String[] args) 
    {
      try
        {
            ServerSocket serverSocket = new ServerSocket(2317);
            
            while(true)
            {
                Socket clientConnection = serverSocket.accept();

                // create a new thread to handle every request made by the client.
                // Once the thread is created and handed off to handle the client, 
                // this goes back and listens for another connection.
                
                HandlerThread handlerThread = new HandlerThread(clientConnection);
                handlerThread.start();
               
            }
                        
        }
        catch(Exception e)
        {
            System.out.println("problem with networking");
            System.out.println("Error: " + e);
        }

    }
    
}
