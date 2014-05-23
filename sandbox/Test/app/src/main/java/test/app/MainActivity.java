package test.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import android.widget.EditText;

import java.net.Socket;
import java.util.Scanner;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    String password ="josh";

    public void connectToServer(String password){
        String host = "10.18.151.154";
        // Scanner input = new Scanner(System.in);

        try{
            Socket toServer = new Socket(host, 9292);
            JSONInputStream inFromServer =
                    new JSONInputStream(toServer.getInputStream());
            JSONOutputStream outToServer =
                    new JSONOutputStream(toServer.getOutputStream());



            outToServer.writeObject(password);

            // System.out.println(inFromServer.readObject());
        }
        catch(Exception e){
            System.out.println("Fail");
            // e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
