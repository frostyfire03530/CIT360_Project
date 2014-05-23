package test.app;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;
import java.net.ServerSocket;
import java.net.Socket;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.net.Socket;
import java.util.Scanner;
/**
 * Created by JMZ on 5/21/2014.
 */
public class server {
    public static void main (String[] args){
        try{
            ServerSocket aListeningSocket = new ServerSocket(9292);
            Socket clientSocket = aListeningSocket.accept();

            JSONInputStream inFromClient =
                    new JSONInputStream(clientSocket.getInputStream());
            JSONOutputStream outToClient =
                    new JSONOutputStream(clientSocket.getOutputStream());

            String message = (String) inFromClient.readObject();
            System.out.println("Your password is "+ message );
            String comp = "Server Says: Success!";
            outToClient.writeObject(comp);
        }
        catch(Exception e){

            //e.printStackTrace();
        }
    }


}
