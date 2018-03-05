package maman16targil1;

import java.io.*;


import java.net.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import ServerClient.ObjectForTransfer;


/***************** Class For Client ****************************************************************/
public class Client
/***************************************************************************************************/
{
	
	private final  String newline = "\n";
	 private final static int SIZE = 16;
	

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		
		while(true)
		{
  
			
		ObjectInputStream objInput=null;
		ObjectOutputStream output = null;
		Socket orderSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String host = "localhost";
		if ( args.length>0)
		{
			host=args[0];
		}
		try {
			orderSocket = new Socket(host,3333);
			
		    output = new ObjectOutputStream( orderSocket.getOutputStream());
		    objInput = new ObjectInputStream(orderSocket.getInputStream());

			
		}catch (UnknownHostException e) { 
			System.out.println(" don't know about host " + host);
			System.exit(1);
		}catch (IOException e) {
			System.out.println(" couldn't get I/O for the connection to : " + host);
            System.exit(1);
		}
		
		System.out.println("after connections");		
		BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
	
	String userInput;

	
	
	int a= JOptionPane.showConfirmDialog( null, " Do you want to order? " );	
	System.out.println(" sending to server your descision: "    ); 
	output.writeObject(a);             
	
	  userInput= (String) objInput.readObject();
	System.out.println(" from server: " + userInput );
	

	String s;
	String arr[] = new String [SIZE];
	String arr2[] = new String [SIZE-4];
	int i;
	int h=0;
	for(i=0;i<16;i++)
	{
		s= (String) objInput.readObject();

		arr[i]=s;
		if( (i%4)!=0)
		{
			
			arr2[h]=s;
			h++;
		}
	}
	
	Menu menu = new Menu(arr);     
	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	menu.setSize(590, 720); 
	menu.setVisible(true); 
	
	Controller c = new Controller();
	menu.setController(c);
	Thread thread1 = new Thread(menu);
	thread1.start();
	
	
	/******************* new connection **************************************/
	
	
	
	output.close();
	objInput.close();
	orderSocket.close();
	
	
	c.waitForThread();
	
	try {
		orderSocket = new Socket(host,4444);
		
	    output = new ObjectOutputStream( orderSocket.getOutputStream());
	    objInput = new ObjectInputStream(orderSocket.getInputStream());

		
	}catch (UnknownHostException e) { 
		System.out.println(" don't know about host " + host);
		System.exit(1);
	}catch (IOException e) {
		System.out.println(" couldn't get I/O for the connection to : " + host);
        System.exit(1);
	}
	
			
	
	/**************************************/
	
	
	
	
	
	
	
	Order r =menu.getOrder();
				boolean  [] f=r.get_food();
				int [] am=r.get_amount();
				int pr= r.get_price();                 
				
				String conclution="";
				for ( i=0; i<12;i++)
				{
					if (f[i])
					{
						conclution=" "+ conclution+ "  " + am[i]+  "  : " +arr2[i];
					}
				}
     JOptionPane.showMessageDialog(null, "you ordered :" + conclution + " ,  and it cost you : " + pr);
     
	int y= JOptionPane.showConfirmDialog( null," do you confirm the order  ?");
	if( y==0 )
	{
			try   // send the Object to server
			{
			
		
				output.writeObject(r);
		     	output.flush();
			}catch(IOException ioException)
			{
				System.err.println( "Error writing Object");
			}
		
		
			String st="b";
			while (  !(st.equals("orderOk")) )
			{
		
				   st= (String) objInput.readObject();
		

			
			}
		
		
			JOptionPane.showMessageDialog(null, "your order has recived" );
	  }
	
		c.waitForThread();
		
		output.close();
		objInput.close();
		stdIn.close();
		orderSocket.close();
	}
}
}
