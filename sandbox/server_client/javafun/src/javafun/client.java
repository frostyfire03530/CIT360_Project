package javafun;

import java.net.Socket;

import org.quickconnectfamily.json.*;

public class client {
	// Scanner host=new Scanner(System.in);
	public static void main(String[] args){
		String host = "127.0.0.1";
		try{
			Socket toServer = new Socket(host, 9292);
			JSONInputStream inFromServer = 
				new JSONInputStream(toServer.getInputStream());
			JSONOutputStream outToServer = 
				new JSONOutputStream(toServer.getOutputStream());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
