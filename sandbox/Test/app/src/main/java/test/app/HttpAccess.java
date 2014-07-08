package test.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.*;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by JMZ on 6/27/2014.
 */
public class HttpAccess implements Runnable {
    //String baseURL = "http://nathanjwaters.com/gallery/wp-content/uploads/2014/01/S5000180-202x300.jpg";

    private String url = "http://www.nathanjwaters.com/gallery/wp-content/uploads/2014/01/S5000180-202x300.jpg";
    private WeakReference theReference = null;
    private android.os.Handler theHandler = null;

    public HttpAccess(String url, WeakReference mainActivity, Handler theHandler) {
        this.url = url;
        this.theReference = mainActivity;
        this.theHandler = theHandler;
    }

    public HttpAccess(WeakReference mainActivity, Handler theHandler) {
        this.theReference = mainActivity;
        this.theHandler = theHandler;
    }

    public void run(){
        try{

            URL httpUrl = new URL(url);

            HttpURLConnection con = (HttpURLConnection) httpUrl.openConnection();
            //readStream(con.getInputStream());
            final Bitmap bitmap = BitmapFactory.decodeStream(con.getInputStream());
            con.disconnect();
            theHandler.post(new Runnable() {
                @Override
                public void run() {
                    MainActivity theActivity = (MainActivity)theReference.get();
                    ImageView imgView =
                            (ImageView) theActivity.findViewById(R.id.imageView);
                    if(theActivity != null){
                        imgView.setImageBitmap(bitmap);
                    }


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

}

