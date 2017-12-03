

package tcpthreadserver;

import java.io.*;
import java.net.*;

/**
 * Handles all the logic associated with one connection
 * by running in a thread of its own. 
 * 
 * @author DMcG
 */

public class HandlerThread extends Thread
{
    /** The socket connection to a client */
    Socket socket;
    
    /** The threat creator creates the socket from
     * a ServerSocket, and passes one to the thread
     * responsible for handling the connection.
     * 
     * @param socket The socket connection handled by this thread
     */
    public HandlerThread(Socket socket)
    {
        this.socket = socket;
    }
    
    /** Handles one connection. We add an artificial slowness
     * to handling the connection with a sleep(). This means
     * the client won't see a server connection response for ten seconds.
     * 
     */
    public void run()
    {
        try
        {
            System.out.println("Starting to handle a thread...");
            
            // get the connection output stream, then write to the cient
             OutputStream os = socket.getOutputStream();
             PrintStream ps = new PrintStream(os);

            ps.println("A message sent by the server");
            ps.flush();
            socket.close();
            System.out.println("Finished handling a thread");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }


    
}
