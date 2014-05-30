package test.app;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.net.Socket;

/**
 * Created by JMZ on 5/29/2014.
 */
public class Client implements Runnable {

    String host = "192.168.1.2";
    String data = "default";

    public Client(String host, String data) {
        this.host = host;
        this.data = data;
    }

    public void run() {
        try{
            Socket toServer = new Socket(host, 80);
            // System.out.println(toServer.toString());

            //System.out.println("socket worked");
            JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
            JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
            outToServer.writeObject(data);
            System.out.println(inFromServer.readObject());
        }
        catch(Exception e){
            System.out.println("Fail");
            e.printStackTrace();
        }
    }
}
