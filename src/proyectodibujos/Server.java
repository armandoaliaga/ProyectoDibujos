/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodibujos;

/**
 *
 * @author NANDO
 */
/**
   @author Cay Horstmann
   @version 1.20 2004-08-03
*/

import com.sun.security.ntlm.Client;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
     
     public static void main(String[] args )
   {        
       List<Socket> sockets= new ArrayList<Socket>();
      try
      {  
         int i = 1;
         ServerSocket s = new ServerSocket(2121);

         while (true)
         {  
            Socket incoming = s.accept();                      
            System.out.println("Spawning " + i);            
            ThreadedEchoHandler r = new ThreadedEchoHandler(incoming,sockets, i);                       
            sockets.add(incoming);            
            Thread t = new Thread(r);
            t.start();
            i++;
         }
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }

}
class ThreadedEchoHandler implements Runnable
{ 
   /**
      Constructs a handler.
      @param i the incoming socket
      @param c the counter for the handlers (used in prompts)
   */
   private List<Socket> clientes;
   public ThreadedEchoHandler(Socket inc,List<Socket> i, int c)
   { 
     clientes = i; counter = c;incoming=inc;          
      
   }
   
   public void Anadircliente(Socket c)
   {
       clientes.add(c);
   }

    @Override
   public void run()
   {  
      try
      {  
         try
         {
            DataInputStream in=new DataInputStream(incoming.getInputStream());                      
                while(true)
                {
                    int tam=in.readInt();
                    byte[] bytes=new byte[tam];
                    in.readFully(bytes,0,bytes.length);
                    
                    for( Socket pedro: clientes)
                    {                        
                        if(pedro != incoming)
                        {                            
                            DataOutputStream out=new DataOutputStream(pedro.getOutputStream());
                            out.writeInt(tam);
                            out.write(bytes);
                        }
                    }
                }
         }
         finally
         {
            incoming.close();
         }
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }

   private Socket incoming;
   private int counter;
}