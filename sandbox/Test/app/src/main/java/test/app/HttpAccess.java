package test.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import org.apache.http.protocol.HTTP;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by JMZ on 6/27/2014.
 */
public class HttpAccess implements Runnable {
    //String baseURL = "http://nathanjwaters.com/gallery/wp-content/uploads/2014/01/S5000180-202x300.jpg";

    String url = new String("http://www.nathanjwaters.com/gallery/wp-content/uploads/2014/01/S5000180-202x300.jpg");
    MainActivity mainActivity = null;

    public HttpAccess(String url, MainActivity mainActivity) {
        this.url = url;
        this.mainActivity = mainActivity;
    }

    public HttpAccess(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public HttpAccess(){
    }

    public void run(){
        try{

            URL httpUrl = new URL(url);

            HttpURLConnection con = (HttpURLConnection) httpUrl.openConnection();
            //readStream(con.getInputStream());
            final Bitmap bitmap = BitmapFactory.decodeStream(con.getInputStream());
            con.disconnect();
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setImage(bitmap);
                }
            });
        }
        catch(Exception e){
            System.out.println("Fail");
            e.printStackTrace();
        }
    }

    private void readStream(InputStream in) {
        Bitmap bitmap = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Change the image in imageView
    public void setImage(Bitmap img){
        final ImageView imgView =
                (ImageView)mainActivity.findViewById(R.id.imageView);
        imgView.setImageBitmap(img);
    }

}

