/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodibujos;

/**
 *
 * @author NANDO
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

     
   public static void main(String[] args )
   {              
      try
      {           
         Socket s=new Socket("localhost",2126);         
         OutputStream out=s.getOutputStream();
         PrintWriter writer=new PrintWriter(out,true);    
         writer.println("Hoola a todos");
         InputStream inStream=s.getInputStream();
         Scanner in = new Scanner(inStream);
         System.out.println(in.nextLine().toString());
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }

}
