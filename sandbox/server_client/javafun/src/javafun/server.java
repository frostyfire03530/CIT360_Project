package javafun;

import java.net.ServerSocket;
import java.net.Socket;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;


public class server {

	public static void main (String[] args){
		try{
		ServerSocket aListeningSocket = new ServerSocket(9292);
		Socket clientSocket = aListeningSocket.accept();

		JSONInputStream inFromClient = 
				new JSONInputStream(clientSocket.getInputStream());
		JSONOutputStream outToClient = 
				new JSONOutputStream(clientSocket.getOutputStream());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}

}
