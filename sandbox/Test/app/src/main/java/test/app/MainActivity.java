package test.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.*;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
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
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;

import java.net.Socket;
import java.util.Scanner;
//import java.awt.*;

public class MainActivity extends ActionBarActivity {

    Button   mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.sendDataButton);

        mButton.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View view){
                    android.os.Handler aHandler = new Handler();
                    HttpAccess HttpAccessRunnable = null;
                    EditText dataBox = (EditText)findViewById(R.id.data);
                    String data = dataBox.getText().toString();
                    System.out.println("Data:["+data+"]");
                    if (data.length() == 0){
                        HttpAccessRunnable = new HttpAccess(new WeakReference<MainActivity>(MainActivity.this), aHandler);
                    } else {
                        HttpAccessRunnable = new HttpAccess(data, new WeakReference<MainActivity>(MainActivity.this), aHandler);
                    }
                    final Thread HTTPThread = new Thread(HttpAccessRunnable);
                    HTTPThread.start();
                }
            }
        );



/*        mButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        EditText dataBox = (EditText)findViewById(R.id.data);
                        String data = dataBox.getText().toString();
                        EditText hostBox = (EditText)findViewById(R.id.host);
                        String host   = hostBox.getText().toString();
                        Client clientRunnable = new Client(host, data);
                        Thread clientThread = new Thread(clientRunnable);
                        clientThread.start();
                    }
                }
        );   */

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
