package test.app;

/**
 * Created by JMZ on 5/21/2014.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.net.Socket;
import java.util.Scanner;
public class client_bak extends MainActivity{





        // Scanner host=new Scanner(System.in);
        public static void main(String[] args){
            String host = "127.0.0.1";
            Scanner input = new Scanner(System.in);

            try{
                Socket toServer = new Socket(host, 9292);
                JSONInputStream inFromServer =
                        new JSONInputStream(toServer.getInputStream());
                JSONOutputStream outToServer =
                        new JSONOutputStream(toServer.getOutputStream());

                System.out.println("please enter a password: ");
                String password= input.nextLine();

                outToServer.writeObject(password);

                System.out.println(inFromServer.readObject());
            }
            catch(Exception e){
                System.out.println("Fail");
                // e.printStackTrace();
            }
        }
}
