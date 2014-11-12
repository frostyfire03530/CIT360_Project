package CatBox;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.mysql.fabric.*;

public class server {

	public static void main (String[] args){
		String cmd = "";
		while (true) {


			try{
				ServerSocket aListeningSocket = new ServerSocket(80);
				Socket clientSocket = aListeningSocket.accept();

				JSONInputStream inFromClient = 
						new JSONInputStream(clientSocket.getInputStream());
				JSONOutputStream outToClient = 
						new JSONOutputStream(clientSocket.getOutputStream());

				String message = (String) inFromClient.readObject();
				//JOptionPane.showMessageDialog (null,"Your password is "+ message );
				String comp = "Server Says: Your data is " + "\"" + message + "\"";
				outToClient.writeObject(comp);
				
			}
			
			
			catch(Exception e){

				//e.printStackTrace();
			}
		}
	}
	

}
