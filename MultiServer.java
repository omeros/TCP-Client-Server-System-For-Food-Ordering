package maman16targil1;

import java.io.BufferedReader;
import java.io.*;
import java.net.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**************** Class for the Main Server *************************************/
public class MultiServer
/******************************************************/
{

	public static void main(String[] args) throws IOException
	{
		ServerSocket SrvSocket=null;
		boolean listening= true;
		try {
			SrvSocket  = new ServerSocket(3333);
		}catch(IOException e) {
			System.err.println("Could not listen on port : 3333");
			System.exit(1);
		}
		System.out.println( "server ready");
		Socket socket = null;
		
		
		

		
		while (listening)
		{
			try {
				socket = SrvSocket.accept();
				new ThreadForClient(socket).start();	
			}catch (IOException e) {
				System.out.println(" Accept failed");
				System.exit(1);
			}
		}
		

		
		
		SrvSocket.close();
		
	}

}
