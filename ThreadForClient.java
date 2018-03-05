package maman16targil1;

import java.nio.file.Paths;
import java.util.Scanner;
import java.net.*;
import java.io.*;



/******************* Class Thread Foe Handling The Client ***************************************/
public class ThreadForClient extends Thread
/**********************************************************************************************/
{
	private Socket socket = null;
	PrintWriter out;
	BufferedReader in;
	boolean isMenu;
	boolean isOrder;
	Scanner input;
	ObjectInputStream objInput;
	ObjectOutputStream output;
	boolean reply;
	ServerSocket SrvSocket=null;
	
	
	/*******************  Constructor *************************************************/
		public ThreadForClient(Socket socket)
	/**********************************************************************************/	
	   {
		this.socket = socket;
		try {
			
	         output = new ObjectOutputStream( socket.getOutputStream());
		    objInput = new ObjectInputStream(socket.getInputStream());
			
			
		}catch(IOException e)
		{
			System.out.println(" couldn't open I/O on connection");

		}
	}
	/******************** Checks if all the fields are properly insert ****************************/
		 public boolean checkTheOrder( Order o)
   /**********************************************************************************************/
		 {
			 String ad=o.get_adress();
			// String  sr =o.get_serialNumber();
			 String n =o.get_name();
			 String ph =o.get_phone();
			
			
			 
			 if( !(ad.equals("Add_Adress"))&&!(n.equals("Add_Name"))&&!(ph.equals("Add_Phone" ))   ) 
			 {
				 return true;
			 }
			 return false;
 		 }
	
    /*********************** Run method *****************************************/
	public void run()
	/**********************************************************************/
	{
		  String[] f2=new String [12];
		 int inputLine;
		 try {
			 	
			 
			 inputLine = (int) objInput.readObject();
					
			 int result=inputLine;
			    if (result==0)
			    {
					System.out.println(" i am sending you the menu ");
					output.writeObject("this is the menu");  
					 
			         
			         FileReader re = new FileReader("menu.txt");
			         BufferedReader br = new BufferedReader( re);
			      //   String s= br.readLine();
			         
			        // output.writeObject(s);              
			       
			         int i=0;
			         int k=0;
		        	 String s= br.readLine();
			         while(s !=null)
			         {
			        		if( (i%4)!=0)
			    			{
			        			  
			        			f2[k]=s;			        			
			        			k++;
			    			}
			        	 output.writeObject(s);             
			            output.flush();
			        	 s =  br.readLine();
			        	 i++;
			         }

			    }

			 /********************** New Connection ***************************/   
			    
			    
			    output.close();
			    objInput.close();
			    socket.close();
			//    SrvSocket.close();
			    
				try {
					SrvSocket  = new ServerSocket(4444);
				}catch(IOException e) {
					System.err.println("Could not listen on port : 4444");
					System.exit(1);
				}
				
				socket = null;
					try {
						socket	= SrvSocket.accept();
					}catch(IOException e) {
						System.out.println("Accept failed");
						System.exit(1);
					}
				
					
					try {
						
				         output = new ObjectOutputStream( socket.getOutputStream());
					    objInput = new ObjectInputStream(socket.getInputStream());
						
						
					}catch(IOException e)
					{
						System.out.println(" couldn't open I/O on connection");

					}
						
				/*****************************************************************/	
					
					
					
					
					
					
					
					
				
	 
			    Order r=null;			   
			   reply = false;
			   		
			 // read the Order
			   while ( !(reply) )
			   {
				    r= (Order) objInput.readObject();
                   reply=checkTheOrder(r);
//                  if (!reply) 
//                	  {
//                	      output.writeObject("a");
//                	  }
			   }
			   
			   if (r!=null)
			   {
				   boolean [] f=r.get_food();
				   int[] am=r.get_amount();
				   System.out.println("            " );   
				   
				   System.out.println(" you ordered  :" );
				  for( int i=0;i<12;i++)
				  {
					  if (f[i])
					  {
						  System.out.println( am[i] + " " + f2[i]);  
					  }
				  }
				   System.out.println("  the price is  :" + r.get_price()   );
				   System.out.println("  your Name  is  :" + r.get_name() );
				   System.out.println("  your Adress is : " + r.get_adress() );
				   System.out.println(" and your Phone is : " + r.get_phone()   );
				   System.out.println("            " );

			   }
			   
   
			      String answer = "orderOk";
			      output.writeObject(answer);
			     			     			     		     
			     
			   objInput.close();
			   output.close();
             socket.close();
             
		 }catch(IOException e)
		 {
				System.out.println(" couldn't read from connection");

		 } 
		  catch (ClassNotFoundException e) 
		 {
			e.printStackTrace();
		}
		 
		

	}
}
